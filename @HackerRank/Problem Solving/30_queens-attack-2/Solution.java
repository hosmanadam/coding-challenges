/* https://www.hackerrank.com/challenges/queens-attack-2/problem */

import java.io.*;
import java.util.*;

public class Solution {

    private static final int[][] DIRECTIONS = new int[8][2];

    static {
        DIRECTIONS[0] = new int[] {0, 1};    // right
        DIRECTIONS[1] = new int[] {0, -1};   // left
        DIRECTIONS[2] = new int[] {1, 1};    // downright
        DIRECTIONS[3] = new int[] {1, 0};    // down
        DIRECTIONS[4] = new int[] {1, -1};   // downleft
        DIRECTIONS[5] = new int[] {-1, 1};   // upright
        DIRECTIONS[6] = new int[] {-1, 0};   // up
        DIRECTIONS[7] = new int[] {-1, -1};  // upleft
    }

    static class Location {
        private int rowIndex;
        private int colIndex;

        Location(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        /** Changes hashCode(), don't use if `this` is in a HashSet or is a key in a HashMap */
        void move(int rowIndex, int colIndex) {
            this.rowIndex += rowIndex;
            this.colIndex += colIndex;
        }

        /** Return whether both coordinates are within the inclusive range of parameters */
        boolean withinBounds(int min, int max) {
            return (rowIndex >= min && colIndex >= min && rowIndex <= max && colIndex <= max);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Location location = (Location) o;
            return rowIndex == location.rowIndex && colIndex == location.colIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowIndex, colIndex);
        }
    }

    static int queensAttack(int boardSize, int k, int queenRow, int queenCol, int[][] obstacles) {
        Set<Location> obstacleSet = obstaclesToSet(obstacles);
        int attackCount = 0;
        for (int[] direction : DIRECTIONS) {
            attackCount += countAttacksInDirection(
                    boardSize, queenRow, queenCol, obstacleSet,
                    direction[0], direction[1]);
        }
        return attackCount;
    }

    private static Set<Location> obstaclesToSet(int[][] obstacles) {
        Set<Location> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(new Location(obstacle[0], obstacle[1]));
        }
        return obstacleSet;
    }

    private static int countAttacksInDirection(int boardSize, int queenRow, int queenCol, Set<Location> obstacleSet,
                                               int rowStep, int colStep) {
        int attacksInDirection = 0;
        Location nextLocation = new Location(queenRow + rowStep, queenCol + colStep);
        while (!obstacleSet.contains(nextLocation) && nextLocation.withinBounds(1, boardSize)) {
            attacksInDirection++;
            nextLocation.move(rowStep, colStep);
        }
        return attacksInDirection;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
