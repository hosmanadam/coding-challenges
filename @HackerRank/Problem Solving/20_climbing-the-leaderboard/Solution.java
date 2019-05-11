/* https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem */

import java.io.*;
import java.util.*;


/**
 * v2 - Much faster, much worse to read
 *
 * We iterate over aliceScores (ascending) in reverse to align it with otherScores (descending).
 * (Rank can only be determined if we start at the top.)
 * The alignment enables us to perform just one iteration each in parallel -> O(n)
 */
public class Solution {

    static int[] climbingLeaderboard(int[] otherScores, int[] aliceScores) {
        Iterator<Integer> otherScoresSet = createSortedSet(otherScores).iterator();
        int[] result = new int[aliceScores.length];

        int rank = 1;
        int otherScore = otherScoresSet.next();
        boolean last = false;
        for (int i = aliceScores.length - 1; i >= 0; i--) {
            int aliceScore = aliceScores[i];
            while (aliceScore < otherScore && otherScoresSet.hasNext()) {
                rank++;
                otherScore = otherScoresSet.next();
            }
            if (aliceScore < otherScore && !last) {
                rank++;
                last = true;
            }
            result[i] = rank;
        }

        return result;
    }

    static Set<Integer> createSortedSet(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();  // Maintain insertion order (already descending)
        for (int num : nums)
            set.add(num);
        return set;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


/**
 * v1 - Works, not fast enough
 */
//public class Solution {
//
//    static int[] climbingLeaderboard(int[] otherScores, int[] aliceScores) {
//        Set<Integer> uniqueOtherScores = createSortedSet(otherScores);
//
//        int[] result = new int[aliceScores.length];
//        for (int i = 0; i < aliceScores.length; i++)
//            result[i] = determineRank(uniqueOtherScores, aliceScores[i]);
//        return result;
//    }
//
//    static int determineRank(Set<Integer> uniqueOtherScores, int score) {
//        int rank = 1;
//        for (int otherScore : uniqueOtherScores) {
//            if (otherScore <= score)
//                break;
//            rank++;
//        }
//        return rank;
//    }
//
//    static Set<Integer> createSortedSet(int[] nums) {
//        Set<Integer> set = new LinkedHashSet<>();  // Maintain insertion order (already descending)
//        for (int num : nums)
//            set.add(num);
//        return set;
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int scoresCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] scores = new int[scoresCount];
//
//        String[] scoresItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < scoresCount; i++) {
//            int scoresItem = Integer.parseInt(scoresItems[i]);
//            scores[i] = scoresItem;
//        }
//
//        int aliceCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] alice = new int[aliceCount];
//
//        String[] aliceItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < aliceCount; i++) {
//            int aliceItem = Integer.parseInt(aliceItems[i]);
//            alice[i] = aliceItem;
//        }
//
//        int[] result = climbingLeaderboard(scores, alice);
//
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
//}
