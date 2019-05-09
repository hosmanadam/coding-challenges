/* https://www.hackerrank.com/challenges/cavity-map/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String[] cavityMap(String[] grid) {
        char value;
        boolean isCavity;
        for (int row = 1; row < grid.length -1; row++) {
            for (int col = 1; col < grid.length -1; col++) {
                value = grid[row].charAt(col);
                isCavity = (value > grid[row-1].charAt(col))
                        && (value > grid[row+1].charAt(col))
                        && (value > grid[row].charAt(col-1))
                        && (value > grid[row].charAt(col+1));
                if (isCavity) {
                    grid[row] = grid[row].substring(0, col) + "X" + grid[row].substring(col + 1);
                    col++;
                }
            }
        }
        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
