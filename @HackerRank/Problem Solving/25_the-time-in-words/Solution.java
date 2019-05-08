/* https://www.hackerrank.com/challenges/the-time-in-words/problem */

import java.io.*;
import java.util.*;

public class Solution {

    private static Map<Integer, String> numToWord = new TreeMap<>();
    static {
        numToWord.put(1, "one");
        numToWord.put(2, "two");
        numToWord.put(3, "three");
        numToWord.put(4, "four");
        numToWord.put(5, "five");
        numToWord.put(6, "six");
        numToWord.put(7, "seven");
        numToWord.put(8, "eight");
        numToWord.put(9, "nine");
        numToWord.put(10, "ten");
        numToWord.put(11, "eleven");
        numToWord.put(12, "twelve");
        numToWord.put(13, "thirteen");
        numToWord.put(18, "eighteen");
        numToWord.put(20, "twenty");
    }

    static String timeInWords(int h, int m) {
        if (m == 0)
            return numToWord.get(h) + " o' clock";
        if (m < 31)
            return wordifyMinutes(m) + " past " + numToWord.get(h);
        return wordifyMinutes(60 - m) + " to " + numToWord.get(h + 1);

    }

    static String wordifyMinutes(int m) {
        return (m == 1) ? "one minute"
                : (m == 15 || m == 45) ? "quarter"
                : (m == 30) ? "half"
                : (m < 14 || m == 18 || m == 20) ? numToWord.get(m) + " minutes"
                : (m < 20) ? numToWord.get(m % 10) + "teen minutes"
                : "twenty " + numToWord.get(m % 20) + " minutes";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
