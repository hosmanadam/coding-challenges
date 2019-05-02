/* https://www.hackerrank.com/challenges/drawing-book/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int pageCount(int totalPages, int desiredPage) {
        int fromFront = desiredPage / 2;
        int fromBack = (totalPages % 2 == 0) ? (totalPages + 1 - desiredPage) / 2 : (totalPages - desiredPage) / 2;
        return Math.min(fromFront, fromBack);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
