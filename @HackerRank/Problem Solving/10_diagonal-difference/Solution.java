/* https://www.hackerrank.com/challenges/diagonal-difference/problem */

import java.io.*;
import java.util.*;

public class Solution {

   static int diagonalDifference(int[][] arr) {
       int sumLR = 0;
       int sumRL = 0;
       int size = arr[0].length;
       for (int i = 0; i < size; i++) {
           sumLR += arr[i][i];
           sumRL += arr[i][size-i-1];
       }
       return Math.abs(sumLR - sumRL);
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       int n = scanner.nextInt();
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       int[][] arr = new int[n][n];

       for (int i = 0; i < n; i++) {
           String[] arrRowItems = scanner.nextLine().split(" ");
           scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

           for (int j = 0; j < n; j++) {
               int arrItem = Integer.parseInt(arrRowItems[j]);
               arr[i][j] = arrItem;
           }
       }

       int result = diagonalDifference(arr);

       bufferedWriter.write(String.valueOf(result));
       bufferedWriter.newLine();

       bufferedWriter.close();

       scanner.close();
   }
}
