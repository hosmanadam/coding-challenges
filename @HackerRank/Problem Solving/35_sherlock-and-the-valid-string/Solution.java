/* https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n s the length of s */
    private static String isValid(String s) {
        Map<Character, Integer> counter = counter(s);
        ArrayList<Integer> countSet = new ArrayList<>(new HashSet<>(counter.values()));

        if (countSet.size() == 1)
            return "YES";

        if (countSet.size() == 2) {
            int first = countSet.get(0);
            int second = countSet.get(1);
            int larger = Math.max(first, second);
            int smaller = Math.min(first, second);
            Collection<Integer> counts = counter.values();
            if (smaller == 1 && count(counts, smaller) == 1
                    || larger-smaller == 1 && count(counts, larger) == 1)
                return "YES";
        }

        return "NO";
    }

    private static Map<Character, Integer> counter(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        return counter;
    }

    private static int count(Collection<Integer> coll, int val) {
        int count = 0;
        for (int num : coll) {
            if (num == val)
                count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
