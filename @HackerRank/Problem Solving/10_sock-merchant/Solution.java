/* https://www.hackerrank.com/challenges/sock-merchant/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int sockMerchant(int n, int[] ar) {
        return sumPairs(countPieces(ar));
    }

    static Map<Integer, Integer> countPieces(int[] ar) {
        Map<Integer, Integer> count = new TreeMap<>();
        Integer previousCount;
        for (int num : ar) {
            previousCount = count.putIfAbsent(num, 1);
            if (previousCount != null)
                count.put(num, previousCount + 1);
        }
        return count;
    }

    static int sumPairs(Map<Integer, Integer> count) {
        int pairs = 0;
        for (int batch : count.values())
            pairs += batch / 2;
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
