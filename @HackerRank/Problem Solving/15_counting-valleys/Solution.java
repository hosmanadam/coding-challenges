/* https://www.hackerrank.com/challenges/counting-valleys/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n) */
    private static int countingValleys(int n, String s) {
        int valleys = 0;
        int seaLevel = 0;
        for (int i = 0; i < n; i++) {
            char step = s.charAt(i);
            seaLevel += (step == 'U' ? 1 : -1);
            valleys += (seaLevel == 0 && step == 'U' ? 1 : 0);
        }
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
