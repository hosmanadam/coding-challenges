/* https://www.hackerrank.com/challenges/bomber-man/problem */

import java.io.*;
import java.util.*;

/**
 * Initial observations
 *   - Test cases expect explosions to happen in a "+" shape with 4 casualties
 *     (as opposed to the "🖓" shape with 8 casualties shown in description)
 *   - On a 3x3 board with a single bomb, the pattern returns to initial state
 *     at seconds 5, 9, 13, etc (4 * i + 1) regardless of the bomb's location.
 *     If repeating pattern applies to multiple bombs & larger boards
 *     we could mod `n` by that number to speed things up
 *
 * Tests
 *   - Multiple bombs placed in overlapping blast radiuses result in the initial
 *     pattern not returning. However, the pattern reached at second 3 always
 *     returns after 4 ticks. This means that the actual duplication starts at
 *     second 7.
 *   - Board size has no effect on this behavior at all.
 *   - THEREFORE
 *     - if `n < 7`, return grid at second `n`
 *     - if `n > 6`, then grid at second `n` = grid at second `n % 4 + 4`
 *   - Grid is completely populated at all even seconds
 *     THEREFORE, if `n` is even, return board at second `2`
 */
public class Solution {

    static class Grid {

        /** Bombs are marked with the second they were planted, empty cells with -1 */
        private int[][] cells;
        private int second = 0;
        private int height;
        private int width;

        Grid(String[] rows) {
            height = rows.length;
            width = rows[0].length();
            this.cells = new int[height][width];
            for (int row = 0; row < height; row++) {
                char[] cells = rows[row].toCharArray();
                for (int col = 0; col < width; col++) {
                    char cell = cells[col];
                    this.cells[row][col] = (cell == 'O' ? second : -1);
                }
            }
        }

        String[] toStringArray() {
            String[] stringArray = new String[height];
            for (int row = 0; row < height; row++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int cell : cells[row]) {
                    stringBuilder.append(cell > -1 ? 'O' : '.');
                }
                stringArray[row] = stringBuilder.toString();
            }
            return stringArray;
        }

        void tick(int seconds) {
            for (int i = 0; i < seconds; i++) {
                tick();
            }
        }

        private void tick() {
            second++;
            if (second % 2 == 0)
                plantAll();
            else
                detonateAll();
        }

        private void detonateAll() {
            int[][] snapshot = snapshot();
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (snapshot[row][col] == second - 3) {
                        cells[row][col] = -1;
                        if (row - 1 >= 0)
                            cells[row-1][col] = -1;
                        if (col - 1 >= 0)
                            cells[row][col-1] = -1;
                        if (row + 1 < height)
                            cells[row+1][col] = -1;
                        if (col + 1 < width)
                            cells[row][col+1] = -1;
                    }
                }
            }
        }

        private void plantAll() {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (cells[row][col] == -1)
                        cells[row][col] = second;
                }
            }
        }

        private int[][] snapshot() {
            int[][] snapshot = new int[height][width];
            for (int row = 0; row < height; row++) {
                System.arraycopy(cells[row], 0, snapshot[row], 0, width);
            }
            return snapshot;
        }
    }

    static String[] bomberMan(int n, String[] grid) {
        if (n == 0)
            return grid;

        Grid g = new Grid(grid);

        // Grid is completely populated at all even seconds
        if (n % 2 == 0)
            g.tick(2);

        // Pattern reached at second 3 always returns after 4 ticks,
        // meaning that from the 7th second grids are duplicates of earlier ones.
        else if (n < 7)
            g.tick(n);
        else
            g.tick(n % 4 + 4);

        return g.toStringArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

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
