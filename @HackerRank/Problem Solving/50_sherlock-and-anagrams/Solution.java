/* https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /**
     * Time complexity: O(|s|^3)
     *
     * We run at most 171600 map insertions provided that |s| <= 100
     * */
    static int sherlockAndAnagrams(String s) {
        Map<Map<Character, Integer>, Integer> counterCounter = new HashMap<>();

        for (int len = 1; len < s.length(); len++) {
            for (int start = 0; start <= s.length() - len; start++) {
                Map<Character, Integer> counter = counter(s, start, start + len);
                counterCounter.put(counter, counterCounter.getOrDefault(counter, 0) + 1);
            }
        }
        int pairs = 0;
        for (int count : counterCounter.values())
            pairs += countToPair(count);

        return pairs;
    }

    private static Map<Character, Integer> counter(String s, int start, int end) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        return counter;
    }

    private static int countToPair(int count) {
        return (count - 1) * count / 2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
