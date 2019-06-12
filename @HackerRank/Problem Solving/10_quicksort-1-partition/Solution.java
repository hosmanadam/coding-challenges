/* https://www.hackerrank.com/challenges/quicksort1/problem */

import java.io.*;
import java.util.*;

public class Solution {

    /** I know it's terrible, but it's good enough for this challenge */
    private static int[] quickSort(int[] arr) {
        int pivot = arr[0];
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        for (int num : arr) {
            if (num < pivot)
                less.add(num);
            else if (num == pivot)
                equal.add(num);
            else
                more.add(num);
        }

        int i = 0;
        for (int num : less) {
            arr[i] = num;
            i++;
        }
        for (int num : equal) {
            arr[i] = num;
            i++;
        }
        for (int num : more) {
            arr[i] = num;
            i++;
        }

        return arr;
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

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
