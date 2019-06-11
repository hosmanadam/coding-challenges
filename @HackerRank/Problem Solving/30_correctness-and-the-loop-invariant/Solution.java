/* https://www.hackerrank.com/challenges/correctness-invariant/problem */

import java.util.*;

public class Solution {

    static void insertionSort(int[] A){
        int[] original = Arrays.copyOf(A, A.length);
        for (int i = 1; i < A.length; i++) {
            checkInvariant(original, A, i);
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = value;
        }
        checkInvariant(original, A, A.length);
        printArray(A);
    }

    /**
     * v2 - Assertions
     *
     * Not good for debugging since they terminate loop at first error
     * */
//    private static void checkInvariant(int[] original, int[] result, int stop) {
//        assert counter(original, stop).equals(counter(result, stop)) :
//            "Counters not equal at stop=" + stop;
//
//        assert isSorted(result, stop) :
//            "Subarray not sorted at stop=" + stop;
//    }

    /** v1 - Plain old console prints */
    private static void checkInvariant(int[] original, int[] result, int stop) {
        if (!counter(original, stop).equals(counter(result, stop)))
            System.out.println("Counters not equal at stop=" + stop);
        if (!isSorted(result, stop))
            System.out.println("Subarray not sorted at stop=" + stop);
    }

    private static Map<Integer, Integer> counter(int[] arr, int stop) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < stop; i++) {
            int n = arr[i];
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        return counter;
    }

    private static boolean isSorted(int[] arr, int stop) {
        for (int i = 1; i < stop; i++) {
            if (arr[i] < arr[i-1])
                return false;
        }
        return true;
    }

    private static void printArray(int[] ar) {
        for (int n : ar)
            System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
