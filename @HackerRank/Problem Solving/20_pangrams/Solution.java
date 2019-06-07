/* https://www.hackerrank.com/challenges/pangrams/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the length of s */
    static String pangrams(String s) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> abcSet = new HashSet<>();
        for (int i = 0; i < abc.length(); i++)
            abcSet.add(abc.charAt(i));

        String candidate = s.toLowerCase();
        Set<Character> candidateSet = new HashSet<>();
        for (int i = 0; i < candidate.length(); i++)
            candidateSet.add(candidate.charAt(i));

        for (Character c : abcSet)
            if (!candidateSet.contains(c))
                return "not pangram";

        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
