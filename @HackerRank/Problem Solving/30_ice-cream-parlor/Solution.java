/* https://www.hackerrank.com/challenges/icecream-parlor/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** T(n) = O(n * log n), where n is the length of arr */
    private static int[] icecreamParlor(int m, int[] arr) {
        Map<Integer, Integer> seen = new TreeMap<>();  // Key: price, Value: one-based index
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = m - num;
            int oneBasedIndex = i+1;
            Integer oneBasedIndexOfComplement = seen.get(complement);
            if (oneBasedIndexOfComplement != null)
                return new int[] {
                        Math.min(oneBasedIndex, oneBasedIndexOfComplement),
                        Math.max(oneBasedIndex, oneBasedIndexOfComplement)
                };
            else
                seen.put(num, oneBasedIndex);
        }

        return new int[] {-1, -1};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
