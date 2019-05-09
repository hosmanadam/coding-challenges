/* https://www.hackerrank.com/challenges/happy-ladybugs/problem */

import java.io.*;
import java.util.*;

public class Solution {

    // If there are at least two of each color and there's at least one space,
    // the bugs can be made happy.
    static String happyLadybugs(String bugs) {
        if (bugsAreAlreadyHappy(bugs))
            return "YES";
        if (!bugs.contains("_"))
            return "NO";
        for (int count : counter(bugs).values()) {
            if (count == 1)
                return "NO";
        }
        return "YES";
    }

    static Map<Character, Integer> counter(String string) {
        Map<Character, Integer> counter = new LinkedHashMap<>();
        char c;
        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            if (c == '_')
                continue;
            if (counter.putIfAbsent(c, 1) != null)
                counter.put(c, counter.get(c) + 1);
        }
        return counter;
    }

    static boolean bugsAreAlreadyHappy(String b) {
        if (b.length() == 1)
            return b.equals("_");
        if (b.charAt(0) != b.charAt(1) || b.charAt(b.length() - 1) != b.charAt(b.length() - 2))
            return false;
        for (int i = 1; i < b.length() - 1; i++) {
            if (b.charAt(i) != b.charAt(i-1) && b.charAt(i) != b.charAt(i+1))
                return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
