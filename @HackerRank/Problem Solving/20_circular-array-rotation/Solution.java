/* https://www.hackerrank.com/challenges/circular-array-rotation/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int[] circularArrayRotation(int[] original, int rotations, int[] queries) {
        int[] rotated = rotate(original, rotations);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = rotated[queries[i]];
        }
        return result;
    }

    static int[] rotate(int[] original, int rotations) {
        int len = original.length;
        int[] rotated = new int[len];
        int newIndex;
        for (int oldIndex = 0; oldIndex < len; oldIndex++) {
            newIndex = (oldIndex + rotations) % len;
            rotated[newIndex] = original[oldIndex];
        }
        return rotated;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

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
