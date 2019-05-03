/* https://www.hackerrank.com/challenges/strange-advertising/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int viralAdvertising(int n) {
        int totalLikes = 0;
        int newReach = 5;
        int newLikes;
        for (int day = 1; day <= n; day++) {
            newLikes = newReach / 2;
            totalLikes += newLikes;
            newReach = newLikes * 3;
        }
        return totalLikes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
