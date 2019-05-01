/* https://www.hackerrank.com/challenges/solve-me-first/problem */

import java.util.*;

public class Solution {

   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int a = in.nextInt();
       int b = in.nextInt();
       int sum = solveMeFirst(a, b);
       System.out.println(sum);
   }

   static int solveMeFirst(int a, int b) {
       return a + b;
   }

}
