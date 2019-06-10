/* https://www.hackerrank.com/challenges/morgan-and-a-string/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String morganAndString(String a, String b) {
        int headA = 0;
        int headB = 0;
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder result = new StringBuilder();

        while (headA < lenA || headB < lenB) {
            // We're done
            if (headA == lenA) {
                result.append(b.substring(headB));
                break;
            }
            if (headB == lenB) {
                result.append(a.substring(headA));
                break;
            }

            // Look for next difference
            int lookaheadA = headA;
            int lookaheadB = headB;
            char first = a.charAt(headA);
            boolean foundHorizontalDifference = false;
            int greed = 1;  // Horizontally identical chars at start of (possibly) upcoming sequence of vertically identical chars
            while (lookaheadA < lenA && lookaheadB < lenB && a.charAt(lookaheadA) == b.charAt(lookaheadB)) {
                if (a.charAt(lookaheadA) != first)
                    foundHorizontalDifference = true;
                if (!foundHorizontalDifference && lookaheadA != headA)
                    greed++;
                lookaheadA++;
                lookaheadB++;
            }

            // We have a difference or reached the end of one or both
            // In case of one lookahead reaching the end and the other not,
            // consume from the latter, as it gives an extra option for the next choice
            boolean endOfA = lookaheadA == lenA;
            boolean endOfB = lookaheadB == lenB;
            if (endOfB && !endOfA || !endOfB && !endOfA && a.charAt(lookaheadA) < b.charAt(lookaheadB)) {
                result.append(a, headA, headA+greed);
                headA += greed;
            } else {  // End of `a` or both, or `b` has smaller
                result.append(b, headB, headB+greed);
                headB += greed;
            }
        }

        return result.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = morganAndString(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
