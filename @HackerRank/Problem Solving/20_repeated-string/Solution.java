/* https://www.hackerrank.com/challenges/repeated-string/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static long repeatedString(String s, long n) {
        return aCount(s) * (n / s.length()) + aCount(s, n % s.length());
    }

    static long aCount(String string) {
        return aCount(string, string.length());
    }

    static long aCount(String string, long upTo) {
        long count = 0;
        for (int i = 0; i < upTo; i++) {
            if (string.charAt(i) == 'a')
                count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
