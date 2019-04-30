/* https://www.hackerrank.com/challenges/java-string-tokens/problem */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        List<String> tokens = reFindAll("[a-zA-Z]+", s);
        System.out.println(tokens.size());
        for (String token : tokens)
                System.out.println(token);
        scan.close();
    }

    public static List<String> reFindAll(String regex, String string) {
        List<String> matches = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex).matcher(string);
        while (matcher.find())
            matches.add(matcher.group());
        return matches;
    }

}
