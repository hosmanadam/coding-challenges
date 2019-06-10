/* https://www.hackerrank.com/challenges/richie-rich/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String highestValuePalindrome(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Integer, Character> toChange = new HashMap<>();
        for (int i = 0; i < chars.length / 2; i++) {
            int j = chars.length-i-1;
            if (chars[i] < chars[j])
                toChange.put(i, chars[j]);
            if (chars[j] < chars[i])
                toChange.put(j, chars[i]);
        }

        if (toChange.size() > k)
            return "-1";

        // Change the edges to 9s while we have extra changes
        // other than those needed to make the palindrome
        int i = 0;
        int j = chars.length-i-1;
        while ((toChange.size() <= k-2
                || toChange.size() <= k-1
                        && (toChange.keySet().contains(i)
                        || toChange.keySet().contains(j)
                        || chars.length == 1))
                && i < s.length()) {
            if (chars[i] != '9') {
                chars[i] = '9';
                toChange.remove(i);
                k--;
                if (chars[j] != '9') {
                    chars[j] = '9';
                    toChange.remove(j);
                    k--;
                }
            }
            i++;
            j--;
        }

        if (toChange.size() == k-1 && chars.length%2 != 0)
            chars[chars.length/2] = '9';

        // Complete the palindrome by changing mismatched pairs to higher value
        for (int key : toChange.keySet())
            chars[key] = toChange.get(key);

        return new String(chars);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
