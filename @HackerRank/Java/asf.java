/* https://www.hackerrank.com/challenges/java-negative-subarray/problem */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        scanner.nextLine();
        String[] strings = scanner.nextLine().split(" ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        int negatives = 0;
        for (int first = 0; first < len; first++) {
            for (int last = first; last < len; last++) {
                int sum = 0;
                for (int i = first; i <= last; i++) {
                    sum += arr[i];
                }
                if (sum < 0)
                    negatives++;
            }
        }

        System.out.println(negatives);
    }
}
