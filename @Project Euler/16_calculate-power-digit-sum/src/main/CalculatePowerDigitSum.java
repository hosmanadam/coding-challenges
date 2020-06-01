package main;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=16
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */
public class CalculatePowerDigitSum {

    public static void main(String[] args) {
        long solution = new CalculatePowerDigitSum().solve(1000);
        System.out.println("The solution is: " + solution);
    }

    public long solve(int exponent) {
        checkExponentIsNotNegative(exponent);
        final BigInteger power = BigInteger.valueOf(2).pow(exponent);
        return sumDigits(power.toString());
    }

    private int sumDigits(final String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.valueOf(number.substring(i, i + 1));
        }
        return sum;
    }

    private void checkExponentIsNotNegative(int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must not be negative");
        }
    }

}
