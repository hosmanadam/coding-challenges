/* https://www.hackerrank.com/challenges/2d-array/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** Time complexity: O(nm), where n is the height of arr and m is the width */
    private static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < arr.length-2; row++) {
            for (int col = 0; col < arr[0].length-2; col++) {
                int sum = getHourglassSum(arr, row, col);
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    private static int getHourglassSum(int[][] arr, int row, int col) {
        int[][] hourglass = new int[][] {
                new int[] {0, 0}, new int[] {0, 1}, new int[] {0, 2},
                                  new int[] {1, 1},
                new int[] {2, 0}, new int[] {2, 1}, new int[] {2, 2}
        };
        int sum = 0;
        for (int[] c : hourglass)
            sum += arr[row+c[0]][col+c[1]];

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
