/* https://www.hackerrank.com/challenges/sherlock-and-squares/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int squares(int a, int b) {
        int currentRoot = (int) Math.sqrt(a);
        if (currentRoot * currentRoot < a)
            currentRoot++;
        int squareCount = 0;
        while (currentRoot * currentRoot <= b) {
            squareCount++;
            currentRoot++;
        }
        return squareCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
