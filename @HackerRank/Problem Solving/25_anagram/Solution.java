/* https://www.hackerrank.com/challenges/anagram/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the length of s */
    private static int anagram(String s) {
        if (s.length() % 2 != 0)
            return -1;

        Map<Character, Integer> counterL = new HashMap<>();
        for (int i = 0; i < s.length() / 2; i++) {
            char c = s.charAt(i);
            counterL.put(c, counterL.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> counterR = new HashMap<>();
        for (int i = s.length() / 2; i < s.length(); i++) {
            char c = s.charAt(i);
            counterR.put(c, counterR.getOrDefault(c, 0) + 1);
        }

        int difference = 0;
        for (Character c : counterL.keySet()) {
            int countDiff = counterL.get(c) - counterR.getOrDefault(c, 0);
            difference += Math.max(countDiff, 0);
        }

        return difference;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
