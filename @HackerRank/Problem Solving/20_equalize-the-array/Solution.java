/* https://www.hackerrank.com/challenges/equality-in-a-array/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> counter = createCounter(arr);
        int highestCount = getHighestCount(counter);
        return arr.length - highestCount;
    }

    static Map<Integer, Integer> createCounter(int[] arr) {
        Map<Integer, Integer> counter = new LinkedHashMap<>();
        for (int num : arr) {
            if (counter.putIfAbsent(num, 1) != null)
                counter.put(num, counter.get(num) + 1);
        }
        return counter;
    }

    static int getHighestCount(Map<Integer, Integer> counter) {
        int max = Integer.MIN_VALUE;
        for (int value : counter.values()) {
            if (value > max)
                max = value;
        }
        return max;
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

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
