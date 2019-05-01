/* https://www.hackerrank.com/challenges/apple-and-orange/problem */

import java.util.*;

public class Solution {

   static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
       printFruitHits(s, t, a, apples);
       printFruitHits(s, t, b, oranges);
   }

   static void printFruitHits(int houseStart, int houseEnd, int fallStart, int[] fallVectors) {
       int fruitHits = 0;
       for (int fallVector : fallVectors)
           if (fallsOnHouse(houseStart, houseEnd, fallStart, fallVector))
               fruitHits += 1;
       System.out.println(fruitHits);
   }

   static boolean fallsOnHouse(int houseStart, int houseEnd, int fallStart, int fallVector) {
       int fallLocation = fallStart + fallVector;
       return (fallLocation >= houseStart && fallLocation <= houseEnd);
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
       String[] st = scanner.nextLine().split(" ");

       int s = Integer.parseInt(st[0]);

       int t = Integer.parseInt(st[1]);

       String[] ab = scanner.nextLine().split(" ");

       int a = Integer.parseInt(ab[0]);

       int b = Integer.parseInt(ab[1]);

       String[] mn = scanner.nextLine().split(" ");

       int m = Integer.parseInt(mn[0]);

       int n = Integer.parseInt(mn[1]);

       int[] apples = new int[m];

       String[] applesItems = scanner.nextLine().split(" ");
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       for (int i = 0; i < m; i++) {
           int applesItem = Integer.parseInt(applesItems[i]);
           apples[i] = applesItem;
       }

       int[] oranges = new int[n];

       String[] orangesItems = scanner.nextLine().split(" ");
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       for (int i = 0; i < n; i++) {
           int orangesItem = Integer.parseInt(orangesItems[i]);
           oranges[i] = orangesItem;
       }

       countApplesAndOranges(s, t, a, b, apples, oranges);

       scanner.close();
   }
}
