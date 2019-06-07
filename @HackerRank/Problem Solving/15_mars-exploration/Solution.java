/* https://www.hackerrank.com/challenges/mars-exploration/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the length of s */
    private static int marsExploration(String s) {
        int count = 0;
        String sos = "SOS";
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != sos.charAt(i%3))
                count++;
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
