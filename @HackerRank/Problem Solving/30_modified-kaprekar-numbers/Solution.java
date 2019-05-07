/* https://www.hackerrank.com/challenges/kaprekar-numbers/problem */

import java.util.*;

public class Solution {

    static void kaprekarNumbers(int p, int q) {
        boolean found = false;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                System.out.print((found) ? " " + i : i);
                found = true;
            }
        }
        if (!found)
            System.out.println("INVALID RANGE");
    }

    static boolean isKaprekar(int candidate) {
        if (candidate < 1)
            return false;
        String squared = Long.toString((long) candidate * candidate);
        if (squared.length() == 1)
            squared = "0" + squared;
        int middle = squared.length() / 2;
        int a = Integer.parseInt(squared.substring(0, middle));
        int b = Integer.parseInt(squared.substring(middle));
        return a + b == candidate;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
