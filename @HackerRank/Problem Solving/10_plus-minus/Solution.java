/* https://www.hackerrank.com/challenges/plus-minus/problem */

import java.util.*;

public class Solution {

   static void plusMinus(int[] arr) {
       int positives = 0;
       int negatives = 0;
       int zeroes = 0;
       for (int num : arr) {
           if (num > 0) {
               positives += 1;
           } else if (num < 0) {
               negatives += 1;
           } else {
               zeroes += 1;
           }
       }
       System.out.printf("%.6f\n", (double) positives / arr.length);
       System.out.printf("%.6f\n", (double) negatives / arr.length);
       System.out.printf("%.6f\n", (double) zeroes / arr.length);
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

       plusMinus(arr);

       scanner.close();
   }
}
