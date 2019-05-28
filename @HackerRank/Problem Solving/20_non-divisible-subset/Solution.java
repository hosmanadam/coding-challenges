/* https://www.hackerrank.com/challenges/non-divisible-subset/problem */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Toughest problem yet.
 * Took 5 tries, but each one was useful and got me closer to the final solution.
 */
public class Solution {

    /**
     * v5 - Doing the same without a dedicated class
     * 
     * Passes all tests after adding in the math principles from v2.
     * It all came together!
     *
     * We care not about the numbers in S, but their remainders with k.
     * We want to keep as many of them as possible without any two of them
     * adding up to k.
     *
     * We add remainders to our final set prioritizing ones that appear often
     * in favor of those that don't. This way we ensure that we get the maximum
     * amount.
     */
    static int nonDivisibleSubset(int k, int[] S) {
        // Count how many of each remainder there is
        Map<Integer, Integer> remainderCounter = new HashMap<>();
        for (int num : S) {
            int remainder = num % k;
            remainderCounter.put(remainder, remainderCounter.getOrDefault(remainder, 0) + 1);
        }
        // Reset count to 1 where remainder is 0 or half of k
        remainderCounter.replace(0, 1);
        if (k % 2 == 0) remainderCounter.replace(k/2, 1);

        // Create set of remainders sorted descending based on their count
        List<Integer> candidates = new ArrayList<>(remainderCounter.keySet());
        candidates.sort((Integer one, Integer other) ->
                remainderCounter.get(other) - remainderCounter.get(one)
        );

        // For each remainder that doesn't complement an earlier one to a
        // multiple of k, add its count to the total
        Set<Integer> confirmed = new HashSet<>();
        int count = 0;
        outer:
        for (int candidate : candidates) {
            for (int keeper : confirmed) {
                if ((candidate + keeper) % k == 0)
                    continue outer;
            }
            confirmed.add(candidate);
            count += remainderCounter.get(candidate);
        }
        return count;
    }

    /**
     * v4 - Using all I got from earlier tries
     * 
     * Passes half of the tests. Class is probably overkill.
     */
//    static int nonDivisibleSubset(int k, int[] S) {
//        remainderCounter.clear();
//
//        List<Candidate> candidates = new ArrayList<>();
//        for (int num : S)
//            candidates.add(new Candidate(num, k));
//        candidates.sort(Collections.reverseOrder());
//
//        Set<Integer> nonDivisible = new HashSet<>();
//        outer:
//        for (Candidate candidate : candidates) {
//            for (int confirmed : nonDivisible) {
//                if ((candidate.getValue() + confirmed) % k == 0)
//                    continue outer;
//            }
//            nonDivisible.add(candidate.getValue());
//        }
//
//        System.out.println(nonDivisible.toString());
//        return nonDivisible.size();
//    }
//
//    private static Map<Integer, Integer> remainderCounter = new HashMap<>();
//
//    private static class Candidate implements Comparable<Candidate> {
//
//        private int value;
//        private int remainder;
//
//        Candidate(int value, int divisor) {
//            this.value = value;
//            this.remainder = value % divisor;
//            remainderCounter.put(remainder, remainderCounter.getOrDefault(remainder, 0) + 1);
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        @Override
//        public int compareTo(Candidate other) {
//            return remainderCounter.get(this.remainder) - remainderCounter.get(other.remainder);
//        }
//
//    }

    /**
     * v3 - Maybe it's stupid simple?
     *
     * Just keep adding numbers that don't yet clash with anything we've already
     * added.
     *
     * Doesn't get right result, misses some possibilities.
     * It seems that by adding certain numbers, we prevent other, "better"
     * numbers from being added. How can there be a "better" number?
     *
     * Oh yes, I think I get it.
     * We don't really care about the numbers, we care about their remainders
     * with k. Numbers are unique, but remainders aren't, so certain remainders
     * will appear multiple times, and given that they aren't k/2 or 0, we may
     * actually keep all of them.
     *
     * For example:
     * S = [1, 4, 9, 14, 19, 24]
     * k = 5;
     *
     * S is composed of 1, and a bunch of numbers that are 1 short of being a 
     * multiple of k. If we add 1 to our set, we can't add any of the other
     * numbers anymore, so we've made a bad deal.
     *
     * Therefore, we need to sort our numbers in descending order based on how
     * many others there are with the same remainder with k.
     *
     * Then, we can use the below algorithm.
     */
//    static int nonDivisibleSubset(int k, int[] S) {
//        Set<Integer> nonDivisible = new HashSet<>();
//
//        outer:
//        for (int x : S) {
//            for (int y : nonDivisible) {
//                if ((x + y) % k == 0)
//                    continue outer;
//            }
//            nonDivisible.add(x);
//        }
//
//        System.out.println(nonDivisible.toString());
//        return nonDivisible.size();
//    }

    /**
     * v2 - Coming up with mathematical principles
     *
     * The set can contain any number whose remainder with k is less than k/2.
     * This way, adding any two up will not result in a multiple of k.
     * In addition, there can be:
     *   - 1 multiple of k
     *   - 1 number whose remainder with k is exactly k/2.
     *
     * Unfortunately, there also may be numbers with higher remainders that
     * happen to not complement any of the smaller reminders to k.
     *
     * Doesn't get right result, misses some possibilities.
     */
//    static int nonDivisibleSubset(int k, int[] S) {
//        Set<Integer> result = Arrays.stream(S)
//                .boxed()
//                .collect(Collectors.toSet());
//
//        Iterator<Integer> iter = result.iterator();
//
//        boolean consumedHalfRemainder = false;
//        boolean consumedMultiple = false;
//        while (iter.hasNext()) {
//            int num = iter.next();
//            int remainder = num % k;
//            boolean isMultipleOfK = (remainder == 0);
//            boolean hasHalfRemainder = (remainder * 2 == k);
//            boolean aboveHalfRemainder = (remainder * 2 > k);
//
//            if (aboveHalfRemainder || hasHalfRemainder && consumedHalfRemainder || isMultipleOfK && consumedMultiple)
//                iter.remove();
//            if (isMultipleOfK)
//                consumedMultiple = true;
//            if (hasHalfRemainder)
//                consumedHalfRemainder = true;
//        }
//
//        System.out.println(result.toString());
//        return result.size();
//    }

    /**
     * v1 - Brute force approach
     *
     * Try taking out each individual number, then each pair of numbers, then
     * each triplet, and so on.
     * This is O(n^n), so it's not a good solution, but it gets correct results
     * and doesn't blow up given S.length < 12, so I'll use it to generate small
     * scale results and
     *   - recognize patterns to be used as a shortcut solution on a larger scale
     *   - test later, smarter algorithms against.
     */
//    static int nonDivisibleSubset(int k, int[] S) {
//        Set<List<Integer>> results = new HashSet<>();
//        int resultLength = 0;
//
//        List<List<Integer>> subsetsLast = new ArrayList<>();
//        List<List<Integer>> subsetsNext = new ArrayList<>();
//        subsetsLast.add(
//                Arrays.stream(S)
//                .boxed()
//                .collect(Collectors.toList())
//        );
//
//        boolean done = false;
//        while (!done && subsetsLast.get(0).size() > 1) {
//            for (List<Integer> subset : subsetsLast) {
//                if (isNonDivisible(k, subset)) {
//                    results.add(subset);
//                    resultLength = subset.size();
//                    done = true;
//                }
//                for (int i = 0; i < subset.size(); i++) {
//                    List<Integer> next = new ArrayList<>(subset);
//                    next.remove(i);
//                    subsetsNext.add(next);
//                }
//            }
//            subsetsLast = new ArrayList<>(subsetsNext);
//            subsetsNext.clear();
//        }
//
//        for (List<Integer> result : results) {
//            System.out.println(result.toString());
//        }
//
//        return resultLength;
//    }
//
//    static boolean isNonDivisible(int k, List<Integer> subset) {
//        for (int i = 0; i < subset.size(); i++) {
//            int a = subset.get(i);
//            for (int j = i+1; j < subset.size(); j++) {
//                int b = subset.get(j);
//                if ((a + b) % k == 0)
//                    return false;
//            }
//        }
//        return true;
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
