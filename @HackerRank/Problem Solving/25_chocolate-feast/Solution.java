/* https://www.hackerrank.com/challenges/chocolate-feast/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int chocolateFeast(int n, int c, int m) {
        int eaten = n/c;
        int wrappers = n/c;
        int canGet = wrappers / m;
        while (canGet > 0) {
            wrappers %= m;
            eaten += canGet;
            wrappers += canGet;
            canGet = wrappers / m;
        }
        return eaten;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
