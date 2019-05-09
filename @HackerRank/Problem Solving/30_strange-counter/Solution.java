/* https://www.hackerrank.com/challenges/strange-code/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static long strangeCounter(long t) {
        long countDownValue = 3;
        long timerValue = 1;
        while (timerValue + countDownValue <= t) {
            timerValue += countDownValue;
            countDownValue *= 2;
        }
        return countDownValue - (t - timerValue);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
