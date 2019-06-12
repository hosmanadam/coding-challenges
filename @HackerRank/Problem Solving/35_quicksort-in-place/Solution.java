/* https://www.hackerrank.com/challenges/quicksort3/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static void quickSort(int[] arr, int start, int stop) {
        int len = stop-start;
        if (len < 2)
            return;

        int pivotIndex = stop-1;
        int pivotValue = arr[pivotIndex];
        int i = start;
        int j = start;

        while (j < pivotIndex) {

            // Find the first value that's too large to be so left
            while (arr[i] < pivotValue)
                i++;

            // Find the first value that's too small to be so right
            j = i;
            while (arr[j] >= pivotValue && j < pivotIndex)
                j++;

            swap(arr, i, j);
        }
        print(arr);
        quickSort(arr, start,i);
        quickSort(arr, i+1, stop);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        quickSort(arr, 0, arr.length);

        scanner.close();
    }
}
