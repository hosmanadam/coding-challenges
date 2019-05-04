/* https://www.hackerrank.com/challenges/append-and-delete/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String appendAndDelete(String s, String t, int stepsAvailable) {
        if (stepsAvailable >= s.length() + t.length())
            // We can consume extra steps one by one
            return "Yes";
        // We can only consume extra steps two at a time
        int diffStartIndex = diffStartIndex(s, t);
        int toDelete = s.length() - diffStartIndex;
        int toAdd = t.length() - diffStartIndex;
        int stepsNeeded = toDelete + toAdd;
        if (stepsNeeded <= stepsAvailable) {
            int extraSteps = stepsAvailable - stepsNeeded;
            if (extraSteps % 2 == 0)
                return "Yes";
        }
        return "No";
    }

    static int diffStartIndex(String first, String second) {
        int len = Math.min(first.length(), second.length());
        int i;
        for (i = 0; i < len; i++) {
            if (first.charAt(i) != second.charAt(i))
                break;
        }
        System.out.println(i);
        return i;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
