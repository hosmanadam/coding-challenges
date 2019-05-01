/* https://www.hackerrank.com/challenges/staircase/problem */

import java.util.*;

public class Solution {

   static void staircase(int n) {
       for (String stair = "#"; stair.length() <= n; stair += "#") {
           System.out.printf("%" + n + "s\n", stair);
       }
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
       int n = scanner.nextInt();
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       staircase(n);

       scanner.close();
   }
}
