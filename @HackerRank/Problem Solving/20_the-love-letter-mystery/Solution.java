/* https://www.hackerrank.com/challenges/the-love-letter-mystery/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the length of s */
    private static int theLoveLetterMystery(String s) {
        int cost = 0;
        int len = s.length();
        for (int i = 0; i < s.length() / 2; i++)
            cost += Math.abs(s.charAt(i) - s.charAt(len-i-1));
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
