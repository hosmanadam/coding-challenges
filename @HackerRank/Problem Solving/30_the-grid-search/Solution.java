/* https://www.hackerrank.com/challenges/the-grid-search/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String gridSearch(String[] grid, String[] pattern) {
        int patternRowLength = pattern[0].length();
        int gridRowLength = grid[0].length();
        for (int row = 0; row <= grid.length - pattern.length; row++) {
            for (int col = 0; col <= gridRowLength - patternRowLength; col++) {
                if (grid[row].substring(col, col + patternRowLength).equals(pattern[0])
                        && isCompleteMatch(grid, pattern, row, col))
                    return "YES";
            }
        }
        return "NO";
    }

    static boolean isCompleteMatch(String[] grid, String[] pattern, int startRow, int startColumn) {
        int patternRowLength = pattern[0].length();
        int patternRow = 0;
        for (int row = startRow; row < startRow + pattern.length; row++) {
            if (!grid[row].substring(startColumn, startColumn + patternRowLength).equals(pattern[patternRow])) {
                return false;
            }
            patternRow++;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
