/* https://www.hackerrank.com/challenges/reduced-string/problem */

import java.io.*;

public class Solution {

    /**
     * T(L) = O(LM), where L is the length of s and M is the number of
     * subsequent operations to reach final result (unknown at compile time,
     * may range from 1 as in "ab" to L/2 as in "abcdefghiihgfedcba")
     */
    private static String superReducedString(String s) {
        boolean didReduce;

        do {
            didReduce = false;
            StringBuilder result = new StringBuilder();
            int i = 0;
            int len = s.length();
            while (i < len) {
                char current = s.charAt(i);
                if (i == len-1 || current != s.charAt(i+1)) {
                    result.append(current);
                    i += 1;
                } else {
                    didReduce = true;
                    i += 2;
                }
            }
            s = result.toString();
        } while (didReduce);
        
        return s.length() > 0 ? s : "Empty String";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
