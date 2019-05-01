/* https://www.hackerrank.com/challenges/time-conversion/problem */

import java.io.*;
import java.util.*;

public class Solution {

   static String timeConversion(String s) {
       boolean is12 = s.substring(0, 2).equals("12");
       boolean isPM = s.substring(8).equals("PM");
       boolean isNoon = is12 && isPM;
       boolean isMidnight = is12 && !isPM;
       boolean isMorning = !is12 && !isPM;

       if (isMidnight)
           return "00" + s.substring(2, 8);
       if (isMorning || isNoon)
           return s.substring(0, 8);
       int hour = Integer.parseInt(s.substring(0, 2));
       return hour + 12 + s.substring(2, 8);
   }

   private static final Scanner scan = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
       BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       String s = scan.nextLine();

       String result = timeConversion(s);

       bw.write(result);
       bw.newLine();

       bw.close();
   }
}
