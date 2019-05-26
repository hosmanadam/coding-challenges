/* https://www.hackerrank.com/challenges/magic-square-forming/problem */

import java.io.*;
import java.util.*;

/**
 * A brute force solution would be to actually try swapping numbers
 * until we arrive at a square that evaluates magical based on the
 * known criteria.
 *
 * However, unless we already know what the closest magic square would
 * look like, this would be enormously inefficient, as we'd need to try
 * each combination of changing every number into every other, then if
 * the result is magical, logging how many swaps it took to arrive, and
 * finding the minimum of those.
 *
 * We could surely find some optimizations, but in the worst case, we'd
 * create and check 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 = 3_265_920 squares.
 * Let's not even think about that.
 *
 * The rules for a magic square are so restrictive that there are probably
 * only a handful, so we should start out by knowing what they are:
 * https://en.wikipedia.org/wiki/Magic_square#Number_of_magic_squares_of_a_given_order
 *
 * Indeed, there is only 1 unique magic square with the size of 3x3.
 * With 4 rotations and a reflection for each, there are a total of
 * 8 matrixes we need to compare our initial square to. (Horizontal and
 * vertical reflections are 180° rotations of each other, so we only
 * need one of them.)
 *
 * Once we have every possible square, calculate a conversion cost for
 * each and return the minimum.
 */
public class Solution {

    private static final int MAGIC_CONSTANT = 15;
    private static final int[][][] MAGIC_SQUARES = new int[8][3][3];

    static {
        MAGIC_SQUARES[0] = new int[][] {
                new int[] {2, 7, 6},
                new int[] {9, 5, 1},
                new int[] {4, 3, 8},
        };
        MAGIC_SQUARES[1] = rotate90(MAGIC_SQUARES[0]);
        MAGIC_SQUARES[2] = rotate90(MAGIC_SQUARES[1]);
        MAGIC_SQUARES[3] = rotate90(MAGIC_SQUARES[2]);
        MAGIC_SQUARES[4] = mirror(MAGIC_SQUARES[0]);
        MAGIC_SQUARES[5] = mirror(MAGIC_SQUARES[1]);
        MAGIC_SQUARES[6] = mirror(MAGIC_SQUARES[2]);
        MAGIC_SQUARES[7] = mirror(MAGIC_SQUARES[3]);
    }

    private static int formingMagicSquare(int[][] square) {
        if (isMagicSquare(square))
            return 0;

        int minCost = Integer.MAX_VALUE;
        for (int[][] magic : MAGIC_SQUARES) {
            int cost = costToConvert(square, magic);
            if (cost < minCost)
                minCost = cost;
        }
        return minCost;
    }

    private static boolean isMagicSquare(int[][] square) {
        if (hasDuplicates(square))
            return false;
        return (square[0][0] + square[0][1] + square[0][2] == MAGIC_CONSTANT &&
                square[1][0] + square[1][1] + square[1][2] == MAGIC_CONSTANT &&
                square[2][0] + square[2][1] + square[2][2] == MAGIC_CONSTANT &&
                square[0][0] + square[1][1] + square[2][2] == MAGIC_CONSTANT &&
                square[2][0] + square[1][1] + square[0][2] == MAGIC_CONSTANT);
    }

    private static boolean hasDuplicates(int[][] square) {
        Set<Integer> nums = new TreeSet<>();
        for (int[] row : square) {
            for (int num : row) {
                if (nums.contains(num))
                    return true;
                nums.add(num);
            }
        }
        return false;
    }

    private static int costToConvert(int[][] from, int[][] to) {
        int cost = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cost += Math.abs(from[row][col] - to[row][col]);
            }
        }
        return cost;
    }

    /** Return deep copy of matrix rotated 90 degrees clockwise */
    private static int[][] rotate90(int[][] matrix) {
        int[][] result = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result[col][2-row] = matrix[row][col];
            }
        }
        return result;
    }

    /** Return deep copy of matrix mirrored along the Y axis */
    private static int[][] mirror(int[][] matrix) {
        int[][] result = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result[row][2-col] = matrix[row][col];
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
