/* https://www.hackerrank.com/challenges/fair-rations/problem */

import java.io.*;
import java.util.*;

public class Solution {

     // We don't care about the number of loaves anyone has, only about its parity.
     // All [odd number][any even numbers][odd number] sequences can be evened out in len-1 flips.
     // Odd number of odd numbers is non-flippable.
    static int fairRations(int[] loavesPerCitizen) {
        int loavesNeeded = 0;
        int lastOddIndex = -1;
        boolean seekingSecond = false;
        for (int i = 0; i < loavesPerCitizen.length; i++) {
            if (loavesPerCitizen[i] % 2 != 0) {
                if (!seekingSecond) {
                    lastOddIndex = i;
                    seekingSecond = true;
                } else {
                    loavesNeeded += (i - lastOddIndex) * 2;
                    seekingSecond = false;
                }
            }
        }
        return (seekingSecond) ? -1 : loavesNeeded;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        bufferedWriter.write((result == -1) ? "NO" : String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
