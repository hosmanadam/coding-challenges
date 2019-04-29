/* https://www.hackerrank.com/challenges/java-string-compare/problem? */

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String substring;
        for (int i = 0; i <= s.length()-k; i++) {
            substring = s.substring(i, i+k);
            if (substring.compareTo(smallest) < 0 || smallest.isEmpty())
                smallest = substring;
            if (substring.compareTo(largest) > 0)
                largest = substring;
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
