/* https://www.hackerrank.com/challenges/funny-string/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the length of s */
    static String funnyString(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            int diffFront = Math.abs(s.charAt(i) - s.charAt(i+1));
            int diffBack = Math.abs(s.charAt(len-i-1) - s.charAt(len-i-2));
            if (diffFront != diffBack)
                return "Not Funny";
        }
        return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
