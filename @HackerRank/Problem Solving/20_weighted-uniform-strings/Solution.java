/* https://www.hackerrank.com/challenges/weighted-uniform-string/problem */

import java.io.*;
import java.util.*;

public class Solution {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Map<Character, Integer> WEIGHTS;

    static {
        WEIGHTS = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++)
            WEIGHTS.put(ALPHABET.charAt(i), i+1);
    }

    /** T(n) = O(n), where n is the length of s or the number of queries */
    private static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> U = new HashSet<>();

        int i = 0;
        int j = 0;
        char first = s.charAt(i);
        while (j < s.length()) {
            if (s.charAt(j) == first) {
                U.add(WEIGHTS.get(first) * (j-i+1));
                j++;
            } else {
                i = j;
                first = s.charAt(i);
            }
        }

        String[] result = new String[queries.length];
        for (int k = 0; k < queries.length; k++)
            result[k] = U.contains(queries[k]) ? "Yes" : "No";

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
