/* https://www.hackerrank.com/challenges/halloween-sale/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int howManyGames(int p, int d, int m, int s) {
        int games = 0;
        while (s >= p) {
            s -= p;
            games++;
            p = (Math.max(p-d, m));
        }
        return games;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
