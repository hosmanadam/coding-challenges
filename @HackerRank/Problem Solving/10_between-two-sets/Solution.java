/* https://www.hackerrank.com/challenges/between-two-sets/problem */

import java.io.*;
import java.util.*;

public class Solution {

   static int getTotalX(int[] a, int[] b) {
       Arrays.sort(a);
       Arrays.sort(b);
       int aMax = a[a.length-1];
       int bMin = b[0];

       int count = 0;
       for (int candidate = aMax; candidate <= bMin; candidate += aMax)
           if (isCommonMultipleOf(candidate, a) && isCommonFactorOf(candidate, b))
               count++;
       return count;
   }

   static boolean isCommonMultipleOf(int candidate, int[] arr) {
       for (int num : arr) {
           if (candidate % num != 0)
               return false;
       }
       return true;
   }

   static boolean isCommonFactorOf(int candidate, int[] arr) {
       for (int num : arr) {
           if (num % candidate != 0)
               return false;
       }
       return true;
   }

   private static final Scanner scan = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
       BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       String[] nm = scan.nextLine().split(" ");

       int n = Integer.parseInt(nm[0].trim());

       int m = Integer.parseInt(nm[1].trim());

       int[] a = new int[n];

       String[] aItems = scan.nextLine().split(" ");

       for (int aItr = 0; aItr < n; aItr++) {
           int aItem = Integer.parseInt(aItems[aItr].trim());
           a[aItr] = aItem;
       }

       int[] b = new int[m];

       String[] bItems = scan.nextLine().split(" ");

       for (int bItr = 0; bItr < m; bItr++) {
           int bItem = Integer.parseInt(bItems[bItr].trim());
           b[bItr] = bItem;
       }

       int total = getTotalX(a, b);

       bw.write(String.valueOf(total));
       bw.newLine();

       bw.close();
   }
}
