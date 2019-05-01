/* https://www.hackerrank.com/challenges/birthday-cake-candles/problem */

import java.io.*;
import java.util.*;

public class Solution {

   static int birthdayCakeCandles(int[] ar) {
       return count(max(ar), ar);
   }

   static int count(int what, int[] where) {
       int count = 0;
       for (int num : where) {
           if (num == what)
               count++;
       }
       return count;
   }

   static int max(int[] ar) {
       int max = Integer.MIN_VALUE;
       for (int num : ar) {
           if (num > max)
               max = num;
       }
       return max;
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       int arCount = scanner.nextInt();
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       int[] ar = new int[arCount];

       String[] arItems = scanner.nextLine().split(" ");
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       for (int i = 0; i < arCount; i++) {
           int arItem = Integer.parseInt(arItems[i]);
           ar[i] = arItem;
       }

       int result = birthdayCakeCandles(ar);

       bufferedWriter.write(String.valueOf(result));
       bufferedWriter.newLine();

       bufferedWriter.close();

       scanner.close();
   }
}
