/* https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem */

import java.io.*;
import java.util.*;

public class Solution {

    private static String hackerrankInString(String s) {
        return s.matches(".*h.*a.*c.*k.*e.*r.*r.*a.*n.*k.*") ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
