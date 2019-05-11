/* https://www.hackerrank.com/challenges/absolute-permutation/problem */

import java.io.*;
import java.util.*;


/**
 * v4 - Finally fast enough!
 *
 * Additional profiling revealed that most time is spent in `contains(result, x)`
 * (checking whether `x` has been used before).
 * I sped this up by duplicating results into a TreeSet
 * and checking contains() on that instead.
 */
public class Solution {

    static int[] absolutePermutation(int n, int k) {
        int[] result = new int[n];
        Set<Integer> resultSet = new TreeSet<>();
        boolean impossible = false;

        if (k == 0) {
            for (int i = 1; i <= n; i++)
                result[i - 1] = i;
        } else if (n % 2 != 0) {
            impossible = true;
        } else {
            boolean found;
            int a;
            int b;
            for (int i = 1; i <= n; i++) {
                found = false;
                // Determine two numbers `x` that satisfy `|x - i| = k`
                a = i + k;
                b = i + k * -1;
                // Use smallest that's in range and hasn't been used yet
                for (int x : new int[] {Math.min(a, b), Math.max(a, b)}) {
                    if (x > 0 && x <= n && !resultSet.contains(x)) {
                        result[i-1] = x;
                        resultSet.add(x);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    impossible = true;
                    break;
                }
            }
        }

        if (impossible)
            result = new int[] {-1};

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


/** v3 - Much faster again, still not fast enough
 *
 * I looked at results from v2 output to come up with a more efficient solution
 *
 * Pattern analysis:
 * 1. All results begin with `k + 1`
 * 2. All results have a pattern that loops in `k` increments
 * 3. All results for the same `k`, regardless of `n`, are identical up to the length of the shorter
 *    - `n` has no bearing on what pos[i] will be
 *    - `k` determines the pattern
 *    - `n` determines whether it's possible and how long it is
 * 4. There are no results for any odd `n` except where `k = 0`
 *
 * Profiling analysis:
 * 1. The larger `k` is, the more recursive calls it takes to eliminate all options
 * 2. Every time a smallest absolute permutation is found, it happens in exactly `n + 1` recursive calls
 *    - THIS IS THE KEY
 *    - for any given `i`, we only need to consider the smaller `x` that satisfies all conditions
 *    - if that `x` doesn't work, we won't have any results -> no need to branch out
 */
//public class Solution {
//
//    static int[] absolutePermutation(int n, int k) {
//        int[] result = new int[n];
//        boolean impossible = false;
//
//        if (k == 0) {
//            for (int i = 1; i <= n; i++)
//                result[i - 1] = i;
//        } else if (n % 2 != 0) {
//            impossible = true;
//        } else {
//            boolean found;
//            int a;
//            int b;
//            for (int i = 1; i <= n; i++) {
//                found = false;
//                // Determine two numbers `x` that could possibly satisfy `|x - i| = k`
//                a = i + k;
//                b = i + k * -1;
//                // Use smallest that's in range and hasn't been used yet
//                for (int x : new int[] {Math.min(a, b), Math.max(a, b)}) {
//                    if (x > 0 && x <= n && !contains(result, x)) {
//                        result[i-1] = x;
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    impossible = true;
//                    break;
//                }
//            }
//        }
//
//        if (impossible)
//            result = new int[] {-1};
//
//        return result;
//    }
//
//    public static boolean contains(int[] arr, int value) {
//        for (int num : arr) {
//            if (num == value)
//                return true;
//        }
//        return false;
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            String[] nk = scanner.nextLine().split(" ");
//
//            int n = Integer.parseInt(nk[0]);
//
//            int k = Integer.parseInt(nk[1]);
//
//            int[] result = absolutePermutation(n, k);
//
//            for (int i = 0; i < result.length; i++) {
//                bufferedWriter.write(String.valueOf(result[i]));
//
//                if (i != result.length - 1) {
//                    bufferedWriter.write(" ");
//                }
//            }
//
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
//}


/**
 * v2 - Much faster, but not fast enough
 *
 * Finds smallest absolute permutation first with recursive algorithm
 */
//public class Solution {
//
//    static List<Integer> absolutePermutation(int n, int k) {
//        if (k == 0) {
//            ArrayList<Integer> result = new ArrayList<>();
//            for (int i = 1; i <= n; i++)
//                result.add(i);
//            return result;
//        }
//
//        List<Integer> result = calculateSmallestPermutation(new ArrayList<>(), n, k);
//        if (result == null) {
//            ArrayList<Integer> sorry = new ArrayList<>();
//            sorry.add(-1);
//            return sorry;
//        }
//        return result;
//    }
//
//    private static List<Integer> calculateSmallestPermutation(ArrayList<Integer> nodes, int n, int k) {
//        if (nodes.size() == n) {
//            return nodes;
//        }
//
//        int i = nodes.size() + 1;
//        List<Integer> result;
//        // Find two numbers `x` that could possibly satisfy `|x - i| = k`
//        int a = i + k;
//        int b = i + k * -1;
//        // Try smaller one first (guarantees that if we have a complete match, it's the smallest possible match)
//        for (int x : new int[] {Math.min(a, b), Math.max(a, b)}) {
//            // See if we have them (they are in range and haven't been used yet)
//            if (x > 0 && x <= n && !nodes.contains(x)) {
//                ArrayList<Integer> nodesWithX = new ArrayList<>(nodes);
//                nodesWithX.add(x);
//                result = calculateSmallestPermutation(nodesWithX, n, k);
//                if (result != null)
//                    return result;
//            }
//        }
//        return null;
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            String[] nk = scanner.nextLine().split(" ");
//
//            int n = Integer.parseInt(nk[0]);
//
//            int k = Integer.parseInt(nk[1]);
//
//            List<Integer> result = absolutePermutation(n, k);
//
//            for (int i = 0; i < result.size(); i++) {
//                bufferedWriter.write(String.valueOf(result.get(i)));
//
//                if (i != result.size() - 1) {
//                    bufferedWriter.write(" ");
//                }
//            }
//
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
//}


/**
 * v1 - Works, but very slow
 *
 * Finds all absolute permutations with recursive algorithm, sorts them and returns smallest
 */
//public class Solution {
//
//    private static List<List<Integer>> absolutePermutations = new ArrayList<>();
//
//    static List<Integer> absolutePermutation(int n, int k) {
//
//        if (k == 0) {
//            ArrayList<Integer> result = new ArrayList<>();
//            for (int i = 1; i <= n; i++)
//                result.add(i);
//            return result;
//        }
//
//        absolutePermutations.clear();
//        calculateSmallestPermutation(new ArrayList<>(), n, k);
//
//        if (absolutePermutations.size() == 0) {
//            ArrayList<Integer> sorry = new ArrayList<>();
//            sorry.add(-1);
//            return sorry;
//        }
//
//        absolutePermutations.sort((list1, list2) -> {
//            int comparison;
//            for (int i = 0; i < list1.size(); i++) {
//                comparison = list1.get(i).compareTo(list2.get(i));
//                if (comparison != 0)
//                    return comparison;
//            }
//            return 0;
//        });
//        return absolutePermutations.get(0);
//    }
//
//    static void calculateSmallestPermutation(ArrayList<Integer> nodes, int n, int k) {
//        if (nodes.size() == n) {
//            absolutePermutations.add(nodes);
//            return;
//        }
//
//        int i = nodes.size() + 1;
//        // Find two numbers `x` that could possibly satisfy `|x - i| = k`
//        for (int x : new int[] {i + k, i + k * -1}) {
//            // See if we have them (they are in range and haven't been used yet)
//            if (x > 0 && x <= n && !nodes.contains(x)) {
//                ArrayList<Integer> nodesWithX = new ArrayList<>(nodes);
//                nodesWithX.add(x);
//                calculateSmallestPermutation(nodesWithX, n, k);
//            }
//        }
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            String[] nk = scanner.nextLine().split(" ");
//
//            int n = Integer.parseInt(nk[0]);
//
//            int k = Integer.parseInt(nk[1]);
//
//            List<Integer> result = absolutePermutation(n, k);
//
//            for (int i = 0; i < result.size(); i++) {
//                bufferedWriter.write(String.valueOf(result.get(i)));
//
//                if (i != result.size() - 1) {
//                    bufferedWriter.write(" ");
//                }
//            }
//
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
//}
