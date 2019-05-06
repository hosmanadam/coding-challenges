/* https://www.hackerrank.com/challenges/taum-and-bday/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static long taumBday(long countBlack, long countWhite, long costBlack, long costWhite, long costToConvert) {
        boolean worthConverting = Math.abs(costBlack - costWhite) > costToConvert;
        if (worthConverting) {
            long countMoreExpensive = costBlack > costWhite ? countBlack : countWhite;
            return (countWhite + countBlack) * Math.min(costBlack, costWhite) + (countMoreExpensive * costToConvert);
        }
        return (countBlack * costBlack) + (countWhite * costWhite);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] bw = scanner.nextLine().split(" ");

            int b = Integer.parseInt(bw[0]);

            int w = Integer.parseInt(bw[1]);

            String[] bcWcz = scanner.nextLine().split(" ");

            int bc = Integer.parseInt(bcWcz[0]);

            int wc = Integer.parseInt(bcWcz[1]);

            int z = Integer.parseInt(bcWcz[2]);

            long result = taumBday(b, w, bc, wc, z);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
