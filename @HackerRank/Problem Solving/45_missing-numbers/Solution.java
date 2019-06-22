/* https://www.hackerrank.com/challenges/missing-numbers/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /**
     * Time complexity: O((m * log m) + (n * log n))
     * - m is the cumulative length of arr and brr
     * - n is the number of unique elements in brr
     * */
    static List<Integer> missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> counterA = counter(arr);
        Map<Integer, Integer> counterB = counter(brr);

        List<Integer> result = new ArrayList<>();
        for (int key : counterB.keySet()) {
            Integer countA = counterA.get(key);
            Integer countB = counterB.get(key);
            if (countA == null || countB > countA)
                result.add(key);
        }

        return result;
    }

    private static Map<Integer, Integer> counter (int[] arr) {
        Map<Integer, Integer> counter = new TreeMap<>();
        for (int num : arr)
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        List<Integer> result = missingNumbers(arr, brr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
