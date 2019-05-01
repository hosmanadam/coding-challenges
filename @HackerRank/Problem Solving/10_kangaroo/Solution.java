/* https://www.hackerrank.com/challenges/kangaroo/problem */

import java.io.*;
import java.util.*;

public class Solution {

   static String kangaroo(int x1, int v1, int x2, int v2) {
       boolean did1StartAhead = x1 > x2;
       boolean is1Faster = v1 > v2;
       if (did1StartAhead && is1Faster)
           return "NO";

       boolean is1Ahead;
       boolean didSwitchPositions;
       while (x1 != x2) {
           is1Ahead = x1 > x2;
           didSwitchPositions = is1Ahead != did1StartAhead;
           if (didSwitchPositions)
               return "NO";
           x1 += v1;
           x2 += v2;
       }
       return "YES";
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       String[] x1V1X2V2 = scanner.nextLine().split(" ");

       int x1 = Integer.parseInt(x1V1X2V2[0]);

       int v1 = Integer.parseInt(x1V1X2V2[1]);

       int x2 = Integer.parseInt(x1V1X2V2[2]);

       int v2 = Integer.parseInt(x1V1X2V2[3]);

       String result = kangaroo(x1, v1, x2, v2);

       bufferedWriter.write(result);
       bufferedWriter.newLine();

       bufferedWriter.close();

       scanner.close();
   }
}
