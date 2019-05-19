/* https://www.hackerrank.com/challenges/java-primality-test/problem */

import java.math.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger num = new BigInteger(n);
        System.out.println(num.isProbablePrime(10) ? "prime" : "not prime");
        scanner.close();
    }
}
