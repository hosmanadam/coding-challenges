/* https://www.hackerrank.com/challenges/find-digits/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int findDigits(int number) {
        int[] digits = breakUp(number);
        int count = 0;
        for (int digit : digits) {
            if (digit != 0 && number % digit == 0)
                count++;
        }
        return count;
    }

    static int[] breakUp(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = Character.getNumericValue(chars[i]);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
