/* https://www.hackerrank.com/challenges/cats-and-a-mouse/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static String catAndMouse(int catA, int catB, int mouseC) {
        int catADistance = Math.abs(catA - mouseC);
        int catBDistance = Math.abs(catB - mouseC);
        if (catADistance == catBDistance)
            return "Mouse C";
        if (catADistance < catBDistance)
            return "Cat A";
        return "Cat B";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
