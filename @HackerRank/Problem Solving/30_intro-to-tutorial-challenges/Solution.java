/* https://www.hackerrank.com/challenges/tutorial-intro/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** Recursive binary search with O(log |arr|) time complexity */
    static int introTutorial(int V, int[] arr) {
        return introTutorial(V, arr, 0, arr.length);
    }

    private static int introTutorial(int V, int[] arr, int start, int stop) {
        int len = stop-start;
        if (len == 1)
            return (arr[start] == V ? start : -1);

        int middleIndex = start + len / 2;
        int comparison = arr[middleIndex] - V;

        if (comparison < 0)
            return introTutorial(V, arr, middleIndex+1, stop);
        if (comparison > 0)
            return introTutorial(V, arr, start, middleIndex);
        return middleIndex;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int V = scanner.nextInt();
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

        int result = introTutorial(V, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
