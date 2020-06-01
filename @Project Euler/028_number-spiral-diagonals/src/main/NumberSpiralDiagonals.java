package main;

/**
 * https://projecteuler.net/problem=28
 * 
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * 
 * @formatter:off
 * 
 * 21 22 23 24 25  ← ring 2
 * 20  7  8  9 10  ← ring 1
 * 19  6  1  2 11  ← ring 0
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * 1   3   5   7   9  13  17  21  25  ← the spiral
 *  +2  +2  +2  +2  +4  +4  +4  +4    ← the increments
 * 101                                ← the sum
 * 
 * @formatter:on
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * 
 */
public class NumberSpiralDiagonals {

    public static void main(String[] args) {
        long solution = new NumberSpiralDiagonals().sumDiagonals(1001);
        System.out.println("The solution is: " + solution);
    }

    public long sumDiagonals(int sideLength) {
        checkSideLengthIsOdd(sideLength);
        checkSideLengthIsPositive(sideLength);
        return doSumDiagonals(sideLength);
    }

    private long doSumDiagonals(int sideLength) {
        long sum = 1; // Center is only counted once
        int position = 1;
        int rings = (int) Math.ceil(sideLength / 2.0);
        for (int ring = 1; ring < rings; ring++) {
            for (int corner = 0; corner < 4; corner++) {
                position += ring * 2;
                sum += position;
            }
        }
        return sum;
    }

    private void checkSideLengthIsOdd(int sideLength) {
        if (sideLength % 2 == 0) {
            throw new IllegalArgumentException("Side length must be odd");
        }
    }

    private void checkSideLengthIsPositive(int sideLength) {
        if (sideLength < 1) {
            throw new IllegalArgumentException("Side length must be a positive integer");
        }
    }

}
