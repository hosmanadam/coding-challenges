/* https://www.hackerrank.com/challenges/extra-long-factorials/problem? */

import java.math.*;
import java.util.*;

public class Solution {

    static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.valueOf(n);
        while (--n > 0)
            factorial = factorial.multiply(BigInteger.valueOf(n));
        System.out.println(factorial);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
