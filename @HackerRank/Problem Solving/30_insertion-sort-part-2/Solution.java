/* https://www.hackerrank.com/challenges/insertionsort2/problem */

import java.util.*;

public class Solution {

    private static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int head = i;
            while (--head >= 0 && arr[head] > val) {
                arr[head + 1] = arr[head];
            }
            arr[head+1] = val;
            print(arr);
        }
    }

    private static void print(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");

        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort2(n, arr);

        scanner.close();
    }
}
