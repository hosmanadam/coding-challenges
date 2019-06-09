/* https://www.hackerrank.com/challenges/two-strings/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the cumulative length of s1 and s2 */
    private static String twoStrings(String s1, String s2) {
        Set<Character> charset1 = charset(s1);
        Set<Character> charset2 = charset(s2);
        for (char c : charset1)
            if (charset2.contains(c))
                return "YES";

        return "NO";
    }

    private static Set<Character> charset(String s) {
        Set<Character> charset = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            charset.add(s.charAt(i));
        return charset;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
