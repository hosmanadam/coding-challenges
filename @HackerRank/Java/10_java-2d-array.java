/* https://www.hackerrank.com/challenges/java-2d-array/problem */

import java.util.*;

public class Solution {

    static int calcHourglassSum(int[][] arr, int startRow, int startCol) {
        int sum = 0;
        
        sum += arr[startRow][startCol];
        sum += arr[startRow][startCol + 1];
        sum += arr[startRow][startCol + 2];
        sum += arr[startRow + 1][startCol + 1];
        sum += arr[startRow + 2][startCol];
        sum += arr[startRow + 2][startCol + 1];
        sum += arr[startRow + 2][startCol + 2];

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();

        int largestSum = Integer.MIN_VALUE;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int sum = calcHourglassSum(arr, row, col);
                if (sum > largestSum)
                    largestSum = sum;
            }
        }
        System.out.println(largestSum);
    }
}
