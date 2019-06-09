/* https://www.hackerrank.com/challenges/making-anagrams/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the cumulative length of s1 and s2 */
    private static int makingAnagrams(String s1, String s2) {
        Map<Character, Integer> counter1 = counter(s1);
        Map<Character, Integer> counter2 = counter(s2);

        Set<Character> charset = new HashSet<>();
        charset.addAll(counter1.keySet());
        charset.addAll(counter2.keySet());

        int removals = 0;
        for (Character c : charset)
            removals += Math.abs(counter1.getOrDefault(c, 0) - counter2.getOrDefault(c, 0));

        return removals;
    }

    private static Map<Character, Integer> counter(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
