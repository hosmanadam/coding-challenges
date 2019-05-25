/* https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem */

import java.io.*;
import java.util.*;

/**
 * Since we can only move balls by swapping two out, it's impossible
 * to change the number of balls in a container.
 * 
 * Therefore, if there's 3 of a certain type of ball, this type can only ever
 * have its dedicated bucket if we already have a bucket with 3 balls in it.
 *
 * Apply this to all ball types.
 */
public class Solution {

    static String organizingContainers(int[][] container) {
        int[] containerLoads = rowSums(container);
        int[] ballTypeCounts = colSums(container);

        Arrays.sort(containerLoads);
        Arrays.sort(ballTypeCounts);

        for (int i = 0; i < container.length; i++) {
            if (containerLoads[i] != ballTypeCounts[i])
                return "Impossible";
        }
        return "Possible";
    }

    static int[] rowSums(int[][] matrix) {
        int[] rowSums = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;
            for (int n : matrix[row])
                sum += n;
            rowSums[row] = sum;
        }
        return rowSums;
    }

    static int[] colSums(int[][] matrix) {
        int[] colSums = new int[matrix.length];
        for (int col = 0; col < matrix.length; col++) {
            int sum = 0;
            for (int[] row : matrix)
                sum += row[col];
            colSums[col] = sum;
        }
        return colSums;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
