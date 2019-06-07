/* https://www.hackerrank.com/challenges/two-characters/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /**
     * Time complexity: O(C^2 * L)
     * - C is the number of unique characters in s
     * - L is the length of s
     * */
    private static int alternate(String s) {
        List<Character> chars = uniqueChars(s);

        int longestAlternating = 0;
        for (int i = 0; i < chars.size()-1; i++) {
            char c1 = chars.get(i);
            for (int j = i+1; j < chars.size(); j++) {
                char c2 = chars.get(j);
                int length = lengthIfAlternating(s, c1, c2);
                if (length > longestAlternating)
                    longestAlternating = length;
            }
        }

        return longestAlternating;
    }

    private static int lengthIfAlternating(String s, char c1, char c2) {
        String candidate = s.replaceAll("[^" + c1 + c2 + "]", "");
        if (candidate.matches(".*(.)\\1.*"))
            return -1;
        return candidate.length();
    }

    private static ArrayList<Character> uniqueChars(String s) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            charSet.add(s.charAt(i));
        return new ArrayList<>(charSet);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
