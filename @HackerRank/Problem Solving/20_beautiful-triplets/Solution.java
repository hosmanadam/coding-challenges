/* https://www.hackerrank.com/challenges/beautiful-triplets/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int beautifulTriplets(int d, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int iVal = arr[i];
            for (int j = i+1; j < arr.length - 1; j++) {
                int jVal = arr[j];
                int jBeauty = jVal - iVal;
                if (jBeauty == d) {
                    for (int k = j+1; k < arr.length; k++) {
                        int kVal = arr[k];
                        int kBeauty = kVal - jVal;
                        if (kBeauty == d) {
                            count++;
                        } else if (kBeauty > d) {
                            break;
                        }
                    }
                } else if (jBeauty > d) {
                    break;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
