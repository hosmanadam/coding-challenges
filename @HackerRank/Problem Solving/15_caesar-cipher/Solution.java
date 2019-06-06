/* https://www.hackerrank.com/challenges/caesar-cipher-1/problem */

import java.io.*;
import java.util.*;

public class Solution {

    private static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * v2 - Less duplication
     *
     * T(n) = O(n), where n is the length of s
     * */
    private static String caesarCipher(String s, int k) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char oldChar = s.charAt(i);
            boolean isUpper = ALPHABET_UPPER.indexOf(oldChar) != -1;
            boolean isLetter = isUpper || ALPHABET_LOWER.indexOf(oldChar) != -1;

            if (!isLetter) {
                result.append(oldChar);
            } else {
                String alphabet = isUpper ? ALPHABET_UPPER : ALPHABET_LOWER;
                int oldIndex = alphabet.indexOf(oldChar);
                int newIndex = (oldIndex + k) % alphabet.length();
                result.append(alphabet.charAt(newIndex));
            }
        }

        return result.toString();
    }

    /** v1 */
//    private static String caesarCipher(String s, int k) {
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            char oldChar = s.charAt(i);
//            boolean isUpper = ALPHABET_UPPER.indexOf(oldChar) != -1;
//            boolean isLetter = isUpper || ALPHABET_LOWER.indexOf(oldChar) != -1;
//
//            if (!isLetter) {
//                result.append(oldChar);
//            } else if (isUpper) {
//                int oldIndex = ALPHABET_UPPER.indexOf(oldChar);
//                int newIndex = (oldIndex + k) % ALPHABET_UPPER.length();
//                result.append(ALPHABET_UPPER.charAt(newIndex));
//            } else {
//                int oldIndex = ALPHABET_LOWER.indexOf(oldChar);
//                int newIndex = (oldIndex + k) % ALPHABET_LOWER.length();
//                result.append(ALPHABET_LOWER.charAt(newIndex));
//            }
//        }
//
//        return result.toString();
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
