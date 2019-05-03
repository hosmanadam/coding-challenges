/* https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int day = i; day <= j; day++) {
            if ((day - reverse(day)) % k == 0)
                count++;
        }
        return count;
    }

    static int reverse(int num) {
        String reversed =
                new StringBuilder(String.valueOf(num))
                .reverse().toString();
        return Integer.parseInt(reversed);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
