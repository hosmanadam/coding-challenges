/* https://www.hackerrank.com/challenges/mini-max-sum/problem */

import java.util.*;

public class Solution {

   static void miniMaxSum(int[] arr) {
       long minSum = Long.MAX_VALUE;
       long maxSum = Long.MIN_VALUE;
       long currentSum;
       for (int i = 0; i < arr.length; i++) {
           currentSum = 0;
           for (int j = 0; j < arr.length; j++) {
               if (i != j)
                   currentSum += arr[j];
           }
           if (currentSum < minSum)
               minSum = currentSum;
           if (currentSum > maxSum)
               maxSum = currentSum;
       }
       System.out.println(minSum + " " + maxSum);
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
       int[] arr = new int[5];

       String[] arrItems = scanner.nextLine().split(" ");
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       for (int i = 0; i < 5; i++) {
           int arrItem = Integer.parseInt(arrItems[i]);
           arr[i] = arrItem;
       }

       miniMaxSum(arr);

       scanner.close();
   }
}
