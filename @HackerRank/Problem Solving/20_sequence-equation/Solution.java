/* https://www.hackerrank.com/challenges/permutation-equation/problem */

import java.io.*;
import java.util.*;

/**
 * We'll be working with two versions of `range(1, p.length + 1)`:
 *   - One of them is `p`, which is a shuffled version.
 *   - The other is an ascending version we'll iterate through.
 *
 * For each value `x` of the ascending version, we need to output the answer
 * to the following question:
 *   - In `p`, which 1-based index holds the value that's the 1-based index of
 *     the value `x`?
 *
 * A triple indirection with the added complication of 1-indexing.
 *
 * Walk-through of the example [4, 3, 5, 1, 2] => [1, 3, 5, 4, 2]:
 * Looking for the value 1. It's at index 4. Which index holds the value 4? 1.
 * Looking for the value 2. It's at index 5. Which index holds the value 5? 3.
 * Looking for the value 3. It's at index 2. Which index holds the value 2? 5.
 * Looking for the value 4. It's at index 1. Which index holds the value 1? 4.
 * Looking for the value 5. It's at index 3. Which index holds the value 3? 2.
 */
public class Solution {

    static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        for (int x = 1; x <= p.length; x++) {
            for (int y = 1; y <= p.length; y++) {
                if (x == p[p[y-1]-1]) {
                    result[x-1] = y;
                    break;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
