/* https://www.hackerrank.com/challenges/cut-the-sticks/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int[] cutTheSticks(int[] arr) {
        List<Integer> stickCounts = new ArrayList<>();
        while (hasStick(arr)) {
            stickCounts.add(stickCount(arr));
            cutEach(arr, shortestStick(arr));
        }
        return listToArray(stickCounts);
    }

    static boolean hasStick(int[] arr) {
        for (int num : arr) {
            if (num > 0)
                return true;
        }
        return false;
    }

    /** Return smallest non-zero value in array */
    static int shortestStick(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min && num > 0)
                min = num;
        }
        return min;
    }

    /** Mutate input array by reducing each value by `howMuch` */
    static int[] cutEach(int[] arr, int howMuch) {
        for (int i = 0; i < arr.length; i++)
            arr[i] -= howMuch;
        return arr;
    }

    /** Return count of non-zero values in array */
    static int stickCount(int[] arr) {
        int stickCount = 0;
        for (int num : arr) {
            if (num > 0)
                stickCount++;
        }
        return stickCount;
    }

    static int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
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

        int[] result = cutTheSticks(arr);

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
