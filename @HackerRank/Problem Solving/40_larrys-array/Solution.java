package com.adamhosman;

/* https://www.hackerrank.com/challenges/larrys-array/problem */

import java.io.*;
import java.util.*;

/**
 * v2 - Shortcut logic
 *
 * We can perform 2 kinds of rotations on the triplets:
 *   Initial:     a b c
 *   1 rotation:  b c a  → resulting change in index/offset: +2 -1 -1
 *   2 rotations: c a b  → resulting change in index/offset: +1 +1 -2
 *
 * Each type of rotation makes one number jump above two others.
 * Therefore, the total number of inversions always changes in twos.
 *
 * We can't reduce an odd number to 0 by subtracting a multiple of 2.
 * Therefore, an odd number of inversions is non-sortable.
 */
public class Solution {

    static String larrysArray(int[] A) {
        return inversions(A) % 2 == 0 ? "YES" : "NO";
    }

    /** Return total number of inversions (when a higher number precedes a lower one) */
    static int inversions(int[] arr) {
        int inversions = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int x = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (x > arr[j])
                    inversions++;
            }
        }
        return inversions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            String result = larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


/**
 * v1 - Trying to actually sort it (doesn't work all that well, used to visualize process)
 *
 * Initial observations:
 *   - We know what the sorted array would look like: `range(1, A.length + 1)`
 *     Therefore, for each position, we know the offset: `index + 1 - value`
 *     E.g. if we have `2` at index `0`, its offset is `0 + 1 - 2 = -1`,
 *     meaning it's 1 place to the left of where it should be
 *
 *   - We can perform 2 kinds of rotations on the triplets
 *     Initial:     a b c
 *     1 rotation:  b c a  → resulting change in index/offset: +2 -1 -1
 *     2 rotations: c a b  → resulting change in index/offset: +1 +1 -2
 *
 *   - This could be viewed like a bubble sort where instead of swapping 2 values
 *     in an unambiguously useful way, we can only make clumsy moves that's likely
 *     to move one thing in the good direction and another in the wrong one
 *
 *   - We need to look at the usefulness of a move in terms of the whole triplet,
 *     Where the usefulness is equal to the reduction in their cumulative absolute
 *     offsets: `sum(abs(offset) for offset)`
 *
 * Possible edge cases:
 *   - Swap with usefulness < 1 needed to enable later swap we can't succeed without
 *   - Making a useful swap that isn't the most useful hurts us
 *     - Should we ever move 1 number in the wrong direction to move 2 in the right direction?
 *       YES (see example test case)
 *
 * Possible keys to a shortcut solution:
 *   - Number of displaced elements
 *   - Location (edge, middle) of displaced elements
 *   - Length of array
 *
 * Possible keys to a brute force solution:
 *   - Can't reduce cumulative absolute offset for any triplet in next step
 *   - We've arrived back to original array (impossible if we only make beneficial moves)
 *
 * Algorithm A:
 *   - While not sorted
 *     - Find triplet where we can make largest improvement by rotating
 *     - Rotate it
 *
 * Algorithm B:
 *   - While not sorted
 *     - For each triplet
 *       - If an improvement can be made by rotating
 *         - Rotate it
 *
 */
//public class Solution {
//
//    static String larrysArray(int[] A) {
//        System.out.println(Arrays.toString(A));
//        boolean didImprove;
//        do {
//            didImprove = false;
//            int bestRotationStartIndex = -1;
//            int bestRotationAmount = -1;
//            int bestRotationImprovement = -1;
//            for (int startIndex = 0; startIndex < A.length - 2; startIndex++) {
//                int[] analysis = shouldRotate(A, startIndex);
//                int rotationAmount = analysis[0];
//                int rotationImprovement = analysis[1];
//                if (rotationImprovement > bestRotationImprovement) {
//                    bestRotationImprovement = rotationImprovement;
//                    bestRotationStartIndex = startIndex;
//                    bestRotationAmount = rotationAmount;
//                    if (bestRotationImprovement == 4) break;  // No better rotation could be found
//                }
//
//            }
//            if (bestRotationAmount > 0) {
//                rotate(A, bestRotationStartIndex, bestRotationAmount);
//                didImprove = true;
//                System.out.println(Arrays.toString(A) + "  // rotated " + bestRotationAmount + " at index " + bestRotationStartIndex + " for an improvement of " + bestRotationImprovement);
//            }
//        } while (didImprove);
//        return isSorted(A) ? "YES" : "NO";
//    }
//
//    static boolean isSorted(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != i+1)
//                return false;
//        }
//        return true;
//    }
//
//    /** Return offsets for triplet at startIndex (where each value is compared to where it should be) */
//    static int[] offsets(int[] arr, int startIndex) {
//        int[] result = new int[3];
//        for (int i = 0; i < 3; i++) {
//            int index = startIndex + i;
//            int value = arr[index];
//            int offset = index + 1 - value;
//            result[i] = offset;
//        }
//        return result;
//    }
//
//    /** Return [best number of rotations, the improvement], or [-1, -1] if no improvement can be made */
//    static int[] shouldRotate(int[] arr, int startIndex) {
//        int[][] rotationVectors = new int[][] {
//            new int[] {+2, -1, -1},  // 1 rotation
//            new int[] {+1, +1, -2},  // 2 rotations
//        };
//        int[] offsets = offsets(arr, startIndex);
//
//        // See if we can reduce our cumulative absolute offset by rotating 1 or 2 times
//        int[] improvements = new int[] {0, 0};
//        for (int rotations = 1; rotations < 3; rotations++) {
//            for (int i = 0; i < 3; i++) {
//                int oldTrouble = Math.abs(offsets[i]);
//                int newTrouble = Math.abs(offsets[i] + rotationVectors[rotations-1][i]);
//                improvements[rotations-1] += oldTrouble - newTrouble;
//            }
//        }
//
//        // Return rotation with largest improvement
//        if (improvements[0] > 0 || improvements[1] > 0) {
//            return (improvements[0] >= improvements[1])
//                    ? new int[] {1, improvements[0]}
//                    : new int[] {2, improvements[1]};
//        }
//        return new int[] {-1, -1};
//    }
//
//    /** Mutate array passed in by rotating subarray at startIndex */
//    static void rotate(int[] arr, int startIndex, int rotations) {
//        int i = startIndex;
//        int j = startIndex + 1;
//        int k = startIndex + 2;
//
//        int a = arr[i];
//        int b = arr[j];
//        int c = arr[k];
//
//        if (rotations == 1) {
//            arr[i] = b;
//            arr[j] = c;
//            arr[k] = a;
//        } else {
//            arr[i] = c;
//            arr[j] = a;
//            arr[k] = b;
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
//            int n = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            int[] A = new int[n];
//
//            String[] AItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < n; i++) {
//                int AItem = Integer.parseInt(AItems[i]);
//                A[i] = AItem;
//            }
//
//            String result = larrysArray(A);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
//}
