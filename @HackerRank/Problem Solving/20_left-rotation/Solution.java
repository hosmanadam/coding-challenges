/* https://www.hackerrank.com/challenges/array-left-rotation/problem */

import java.util.*;

public class Solution {

    /** T(n) = O(n), where n is the length of arr */
    static int[] rotate(int[] arr, int rotations) {
        int[] rotated = new int[arr.length];
        rotations %= arr.length;
        for (int i = 0; i < arr.length; i++) {
            int destination = i-rotations;
            if (destination < 0)
                destination = arr.length + destination;
            rotated[destination] = arr[i];
        }

        return rotated;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] rotated = rotate(a, d);

        for (int num : rotated)
            System.out.print(num + " ");

        scanner.close();
    }
}
