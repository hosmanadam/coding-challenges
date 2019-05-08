/* https://www.hackerrank.com/challenges/lisa-workbook/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int workbook(int chapters, int problemsPerPage, int[] problemsPerChapter) {
        int specialCount = 0;
        int pageNumber = 0;
        for (int chapterIndex = 0; chapterIndex < chapters; chapterIndex++) {
            for (int problemNumber = 1; problemNumber <= problemsPerChapter[chapterIndex]; problemNumber++) {
                if (problemNumber % problemsPerPage == 1 || problemsPerPage == 1)
                    pageNumber++;
                if (problemNumber == pageNumber)
                    specialCount++;
            }
        }
        return specialCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
