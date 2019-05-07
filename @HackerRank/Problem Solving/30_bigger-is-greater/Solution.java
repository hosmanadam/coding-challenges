/* https://www.hackerrank.com/challenges/bigger-is-greater/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String biggerIsGreater(String w) {
        if (w.length() < 2)
            return "no answer";

        // Find latest (least significant) char that can be made greater by swapping with a later one
        // This will be first value that isn't in ascending order counted from the end
        int indexChangeStart = -1;
        for (int i = w.length() - 2; i >= 0; i--) {
            if (w.charAt(i) < w.charAt(i + 1)) {
                indexChangeStart = i;
                break;
            }
        }
        if (indexChangeStart == -1)
            return "no answer";

        // Find smallest larger char later in the string
        // This is guaranteed to exist, and guaranteed to be the first larger found from end
        int indexSmallestLarger = -1;
        for (int i = w.length() - 1; i > indexChangeStart; i--)
            if (w.charAt(i) > w.charAt(indexChangeStart)) {
                indexSmallestLarger = i;
                break;
            }

        // Swap these two
        String result = swapChars(w, indexChangeStart, indexSmallestLarger);

        // Sort all following chars in ascending order to minimize lexicographic value
        result = sortEndAscending(result, indexChangeStart + 1);
        return result;
    }
    
    static String swapChars(String string, int indexEarlier, int indexLater) {
        String result = "";
        result += string.substring(0, indexEarlier);
        result += string.substring(indexLater, indexLater + 1);
        result += string.substring(indexEarlier + 1, indexLater);
        result += string.substring(indexEarlier, indexEarlier + 1);
        result += string.substring(indexLater + 1);
        return result;
    }

    static String sortEndAscending(String string, int indexSortStart) {
        StringBuilder builder = new StringBuilder();
        builder.append(string, 0, indexSortStart);
        char[] end = string.substring(indexSortStart).toCharArray();
        Arrays.sort(end);
        builder.append(end);
        return builder.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
