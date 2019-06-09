/* https://www.hackerrank.com/challenges/palindrome-index/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /**
     * T(n) = O(n), where n is the length of s
     *
     * Even though a looping function is called inside the loop, we iterate
     * through the string at most 3*0.5 times, because we return after the third
     * iteration the latest.
     * */
    private static int palindromeIndex(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            int j = len-i-1;
            if (s.charAt(i) != s.charAt(j)) {
                if (isPalindrome(s.substring(0, i) + s.substring(i+1)))
                    return i;
                else if (isPalindrome(s.substring(0, j) + s.substring(j+1)))
                    return j;
                else
                    return -1;
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len-i-1))
                return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
