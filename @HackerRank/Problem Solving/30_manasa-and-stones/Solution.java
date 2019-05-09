/* https://www.hackerrank.com/challenges/manasa-and-stones/problem */

import java.io.*;
import java.util.*;

public class Solution {

    // Since we only care about the end result,
    // the order of additions doesn't matter, only how many of which there is.
    // This can be described in terms of a simple sliding scale.
    static int[] stones(int n, int a, int b) {
        n--;  // Needed to pass test cases, which clash with description
        if (a == b)
            return new int[] {n * a};
        int smaller = Math.min(a, b);
        int larger = Math.max(a, b);
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = (smaller * (n-i)) + (larger * i);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
