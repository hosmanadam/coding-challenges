/* https://www.hackerrank.com/challenges/beautiful-binary-string/problem */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int beautifulBinaryString(String b) {
        Pattern p = Pattern.compile("010(10)*");
        Matcher m = p.matcher(b);
        int count = 0;
        while (m.find())
            count += Math.ceil((m.group().length() - 1) / 4.0);
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
