/* https://www.hackerrank.com/challenges/3d-surface-area/problem */

import java.io.*;
import java.util.*;

public class Solution {

    private static int surfaceArea(int[][] A) {
        int total = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                int current = A[row][col];
                int up = row == 0 ? 0 : A[row-1][col];
                int right = col == A[0].length-1 ? 0 : A[row][col+1];
                int down = row == A.length-1 ? 0 : A[row+1][col];
                int left = col == 0 ? 0 : A[row][col-1];

                int area = 2;
                for (int neighbor : new int[] {up, right, down, left}) {
                    area += Math.max(0, current-neighbor);
                }
                total += area;
            }
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
