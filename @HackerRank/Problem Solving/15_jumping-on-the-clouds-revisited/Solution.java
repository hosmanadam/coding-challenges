/* https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int jumpingOnClouds(int[] clouds, int jumpSize) {
        int energyLevel = 100;
        int currentIndex = 0;
        do {
            currentIndex = (currentIndex + jumpSize) % clouds.length;
            energyLevel -= 1;
            if (clouds[currentIndex] == 1)
                energyLevel -= 2;
        } while (currentIndex != 0);
        return energyLevel;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
