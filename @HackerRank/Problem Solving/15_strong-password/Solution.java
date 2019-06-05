/* https://www.hackerrank.com/challenges/strong-password/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int minimumNumber(int n, String password) {
        int charsNeeded = 0;

        charsNeeded += !password.matches(".*\\d.*") ? 1 : 0;
        charsNeeded += !password.matches(".*[a-z].*") ? 1 : 0;
        charsNeeded += !password.matches(".*[A-Z].*") ? 1 : 0;
        charsNeeded += !password.matches(".*[!@#$%^&*()\\-+].*") ? 1 : 0;

        int total = n + charsNeeded;
        if (total < 6)
            charsNeeded += 6 - total;

        return charsNeeded;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
