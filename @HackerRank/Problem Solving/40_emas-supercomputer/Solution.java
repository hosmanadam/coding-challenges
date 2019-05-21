/* https://www.hackerrank.com/challenges/two-pluses/problem */

import java.io.*;
import java.util.*;

/**
 * Initial observations
 *   - If there were no good/bad cells, we could follow this logic:
 *     1. Find largest plus, take its area, mark its cells bad
 *     2. Given the remaining cells, find the second largest plus
 *     3. Multiply their areas
 *   - Can there be a situation where making the firstPlus plus smaller than
 *     the maximum possible would result in a larger final product?
 *
 *     Let's try with 100% good cells:
 *
 *     • • • • ■ • • • • •     • • ■ • • • • • • •  // If `n` & `m` are even:
 *     • • • • ■ • • • • •     • • ■ • • □ • • • •  // 17 * 9 == 9 * 17
 *     • • • • ■ • • • • •     ■ ■ ■ ■ ■ □ • • • •  // NO
 *     • • • • ■ • • • • •     • • ■ • • □ • • • •
 *     ■ ■ ■ ■ ■ ■ ■ ■ ■ •     • • ■ • • □ • • • •
 *     • • • • ■ • • □ • •     • □ □ □ □ □ □ □ □ □
 *     • • • • ■ • • □ • •     • • • • • □ • • • •
 *     • • • • ■ □ □ □ □ □     • • • • • □ • • • •
 *     • • • • ■ • • □ • •     • • • • • □ • • • •
 *     • • • • • • • □ • •     • • • • • □ • • • •
 *
 *     • • • • • ■ • • • • •     • • • ■ • • • • • • •  // If `n` & `m` are odd:
 *     • • • • • ■ • • • • •     • • • ■ • • • • • • •  // 21 * 9 = 189  >  13 * 13 = 169
 *     • • • • • ■ • • • • •     • • • ■ • • • • • • •  // NO
 *     • • • • • ■ • • • • •     ■ ■ ■ ■ ■ ■ ■ • • • •
 *     • • • • • ■ • • • • •     • • • ■ • • • □ • • •
 *     ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■     • • • ■ • • • □ • • •
 *     • • • • • ■ • • □ • •     • • • ■ • • • □ • • •
 *     • • • • • ■ • • □ • •     • • • • □ □ □ □ □ □ □
 *     • • • • • ■ □ □ □ □ □     • • • • • • • □ • • •
 *     • • • • • ■ • • □ • •     • • • • • • • □ • • •
 *     • • • • • ■ • • □ • •     • • • • • • • □ • • •
 *
 *     Let's try with strategically placed bad cells:
 *
 *     • • • • • ■ • • • • •     • • • ■ • • • • • • •  // 21 * 5 = 105  <  13 * 13 = 169
 *     • • • • • ■ • • • • •     • • • ■ • • • • • • •  // YES
 *     • • X • • ■ • • X • •     • • X ■ • • • • X • •
 *     • • • • • ■ • • • • •     ■ ■ ■ ■ ■ ■ ■ • • • •
 *     • • • • • ■ • • • • •     • • • ■ • • • □ • • •
 *     ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■     • • • ■ • • • □ • • •
 *     • • • • • ■ • □ • • •     • • • ■ • • • □ • • •
 *     • • • • • ■ □ □ □ • •     • • • • □ □ □ □ □ □ □
 *     • • X • • ■ • □ X • •     • • X • • • • □ X • •
 *     • • • • • ■ • • • • •     • • • • • • • □ • • •
 *     • • • • • ■ • • • • •     • • • • • • • □ • • •
 *
 *     Also consider that with certain first pluses, second plus might mot fit at all:
 *
 *     X • X     X ■ X     X • X  // 5 * 0 < 1 * 1
 *     • • •     ■ ■ ■     • ■ □
 *     X • X     X ■ X     X • X
 *
 *   - So we have to deal with the fact that the correct first plus won't always be the largest
 *   - A possible, albeit expensive method would be to:
 *     - Create grid for each possible first plus
 *     - For each, calculate maximal second plus (ditch if it doesn't fit) and store product of areas if it's maximal
 *   - Reasons why this is actually not THAT bad:
 *     - Maximum grid size is 15 * 15
 *     - Our data (good/bad) is binary, so we can use a boolean array
 *     - In the worst case, we calculate about (15*15*4)*(15*15*4) = 810_000 pluses
 *     - This can probably be reduced via some optimizations
 */
public class Solution {

    static class Plus {

        /** Contains an int[2] of row and array indexes for each cell this Plus occupies */
        private int[][] coordinates;
        private int reach;

        Plus(int centerRow, int centerCol, int reach) {
            this.reach = reach;
            this.coordinates = new int[area()][2];

            coordinates[0] = new int[] {centerRow, centerCol};
            int i = 1;
            for (int col = centerCol-reach; col <= centerCol+reach; col++) {
                if (col == centerCol) continue;
                coordinates[i][0] = centerRow;
                coordinates[i][1] = col;
                i++;
            }
            for (int row = centerRow-reach; row <= centerRow+reach; row++) {
                if (row == centerRow) continue;
                coordinates[i][0] = row;
                coordinates[i][1] = centerCol;
                i++;
            }
        }

        int[][] coordinates() {
            return coordinates;
        }

        int area() {
            return reach * 4 + 1;
        }

        int reach() {
            return reach;
        }
    }

    static class Grid {

        /** Good cells are `true`, bad ones are `false` */
        private boolean[][] cells;
        private int height;
        private int width;
        private Plus firstPlus;
        private Plus secondPlus = null;
        /** Whether first Plus has been placed on good cells */
        private boolean isValid;

        /** Creates Grid with first Plus. Won't create Grid with 0 or 2 pluses because we never need that. */
        Grid(boolean[][] cells, Plus firstPlus) {
            this.height = cells.length;
            this.width = cells[0].length;
            this.firstPlus = firstPlus;

            this.cells = new boolean[height][width];
            for (int row = 0; row < height; row++) {
                System.arraycopy(cells[row], 0, this.cells[row], 0, width);
            }

            boolean possible = true;
            for (int[] c : firstPlus.coordinates()) {
                int row = c[0];
                int col = c[1];
                if (this.cells[row][col]) {
                    this.cells[row][col] = false;
                } else {
                    possible = false;
                    break;
                }
            }
            this.isValid = possible;
        }

        boolean isValid() {
            return isValid;
        }

        boolean placeSecondPlus() {
            Plus largest = null;
            int fullReach = (Math.min(height, width) - 1) / 2;
            centers: for (int[] cCenter : this.coordinates()) {
                int centerRow = cCenter[0];
                int centerCol = cCenter[1];
                int maxReach = maxReach(height, width, centerRow, centerCol);
                int nextLargerReach = (largest != null ? largest.reach() + 1 : 0);
                reaches: for (int reach = nextLargerReach; reach <= maxReach; reach++) {
                    Plus candidate = new Plus(centerRow, centerCol, reach);
                    for (int[] c : candidate.coordinates()) {
                        int row = c[0];
                        int col = c[1];
                        if (!cells[row][col]) {
                            break reaches;
                        }
                    }
                    largest = candidate;
                    if (reach == fullReach) {
                        break centers;
                    }
                }
            }

            boolean found = largest != null;
            if (found) {
                secondPlus = largest;
                for (int[] c : secondPlus.coordinates()) {
                    int row = c[0];
                    int col = c[1];
                    cells[row][col] = false;
                }
            }
            return found;
        }

        int[][] coordinates() {
            int[][] coordinates = new int[height * width][2];
            int i = 0;
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    coordinates[i][0] = row;
                    coordinates[i][1] = col;
                    i++;
                }
            }
            return coordinates;
        }

        int plusCoverage() {
            return firstPlus.area() * secondPlus.area();
        }

        String[] toStringArray() {
            String[] stringArray = new String[height];
            for (int row = 0; row < height; row++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (boolean cell : cells[row]) {
                    stringBuilder.append(cell ? "• " : "X ");
                }
                stringArray[row] = stringBuilder.toString();
            }
            return stringArray;
        }

        void print() {
            for (String row : toStringArray()) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    static int twoPluses(String[] grid) {
        int height = grid.length;
        int width = grid[0].length();
        boolean[][] matrix = matrixify(grid, height, width);

        // Create grids with all possible first pluses
        int max = 0;
        for (int centerRow = 0; centerRow < height; centerRow++) {
            for (int centerCol = 0; centerCol < width; centerCol++) {
                int maxReach = maxReach(height, width, centerRow, centerCol);
                for (int reach = 0; reach <= maxReach; reach++) {
                    Grid g = new Grid(matrix, new Plus(centerRow, centerCol, reach));
                    // Find largest second plus and check total coverage
                    if (g.isValid() && g.placeSecondPlus()) {
                        int plusCoverage = g.plusCoverage();
                        if (plusCoverage > max) {
                            max = plusCoverage;
                        }
                    }
                }
            }
        }
        return max;
    }

    static int maxReach(int height, int width, int centerRow, int centerCol) {
        return Math.min(
                Math.min(centerCol, width-centerCol-1),
                Math.min(centerRow, height-centerRow-1)
        );
    }

    static boolean[][] matrixify(String[] rows, int height, int width) {
        boolean[][] matrix = new boolean[height][width];
        for (int row = 0; row < height; row++) {
            char[] cells = rows[row].toCharArray();
            for (int col = 0; col < width; col++) {
                char cell = cells[col];
                matrix[row][col] = (cell == 'G');
            }
        }
        return matrix;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
