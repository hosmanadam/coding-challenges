/* https://www.hackerrank.com/challenges/java-string-reverse/problem */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String answer = (isPalindrome(A) ? "Yes" : "No");
        System.out.println(answer);
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

}
