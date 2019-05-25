/* https://www.hackerrank.com/challenges/almost-sorted/problem */

import java.util.*;

/** Duplication intentionally left in for ease of readability */
public class Solution {

    static void almostSorted(int[] arr) {
        List<Integer> downSteps = downSteps(arr);

        if (downSteps.size() == 0) {
            // Array is sorted
            System.out.println("yes");
            return;
        }

        else if (downSteps.size() == 1) {
            // See if we can swap between two neighbors
            int l = downSteps.get(0) - 1;
            int r = l + 1;
            if (becomesSorted(arr, l, r)) {
                System.out.println("yes\nswap " + (l+1) + " " + (r+1));
                return;
            }
        }

        else if (downSteps.size() == 2) {
            // See if we can swap between two non-neighbors
            int l = downSteps.get(0) - 1;
            int r = downSteps.get(1);
            if (becomesSorted(arr, l, r)) {
                System.out.println("yes\nswap " + (l+1) + " " + (r+1));
                return;
            }
        }

        else if (isConsecutive(downSteps)) {
            // See if we can reverse range
            int l = downSteps.get(0) - 1;
            int r = downSteps.get(downSteps.size()-1);
            if (becomesSorted(arr, l, r)) {
                System.out.println("yes\nreverse " + (l+1) + " " + (r+1));
                return;
            }
        }

        System.out.println("no");
    }

    /** Return list of indexes where value is smaller than the one preceding it */
    static List<Integer> downSteps(int[] arr) {
        List<Integer> downTrends = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1])
                downTrends.add(i);
        }
        return downTrends;
    }

    /** Return whether list contains consecutive numbers only */
    static boolean isConsecutive(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) != list.get(i+1) - 1)
                return false;
        }
        return true;
    }

    /** Return whether swapping or reversing given positions will put values in ascending order */
    static boolean becomesSorted(int[] arr, int l, int r) {
        boolean atStart = (l == 0);
        boolean atEnd = (r == arr.length-1);
        boolean areNeighbors = (r-l == 1);
        return ((atStart || arr[r] > arr[l-1])  &&  (atEnd || arr[l] < arr[r+1]))
                &&  (areNeighbors  ||  ((arr[r] < arr[l+1]) && (arr[l] > arr[r-1])));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
