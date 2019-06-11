/* https://www.hackerrank.com/challenges/insertionsort1/problem */

import java.util.*;

public class Solution {

    static void insertionSort1(int n, int[] arr) {
        int val = arr[arr.length - 1];
        for (int i = arr.length - 2; i > -2 ; i--) {
            if (i == -1 || arr[i] < val) {
                arr[i+1] = val;
                print(arr);
                return;
            } else {
                arr[i + 1] = arr[i];
                print(arr);
            }
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

        insertionSort1(n, arr);

        scanner.close();
    }
}
