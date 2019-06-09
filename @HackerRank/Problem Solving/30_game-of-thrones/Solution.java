/* https://www.hackerrank.com/challenges/game-of-thrones/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the length of s */
    private static String gameOfThrones(String s) {
        Map<Character, Integer> counter = counter(s);
        int odds = 0;
        for (int count : counter.values()) {
            if (count % 2 != 0) {
                odds++;
                if (odds > 1)
                    return "NO";
            }
        }
        return "YES";
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

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
