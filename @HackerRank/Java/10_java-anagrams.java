/* https://www.hackerrank.com/challenges/java-anagrams/problem */

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        return counter(a.toLowerCase()).equals(counter(b.toLowerCase()));
    }

    public static java.util.HashMap<Character, Integer> counter(String string) {
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            int count = map.getOrDefault(currentChar, 0);
            map.put(currentChar, count + 1);
        }
        return map;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
