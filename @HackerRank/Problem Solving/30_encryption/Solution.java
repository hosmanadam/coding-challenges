/* https://www.hackerrank.com/challenges/encryption/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String encryption(String s) {
        String spaceless = s.replaceAll(" ", "");
        final int L = spaceless.length();
        double sqrtL = Math.sqrt(L);
        int rows = (int) sqrtL;
        int cols = (int) Math.ceil(sqrtL);
        if (rows * cols < L)
            rows++;

        int index;
        StringBuilder encrypted = new StringBuilder();
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                index = row * cols + col;
                if (index < L)
                    encrypted.append(spaceless.charAt(index));
            }
            if (col < cols -1)
                encrypted.append(' ');
        }
        return encrypted.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
