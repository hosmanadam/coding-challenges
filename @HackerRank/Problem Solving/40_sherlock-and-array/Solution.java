/* https://www.hackerrank.com/challenges/sherlock-and-array/problem */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    /** T(n) = O(n), where n is the length of arr */
    private static String balancedSums(List<Integer> arr) {
        int[] leftSums = new int[arr.size()];
        int leftSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            leftSums[i] = leftSum;
            leftSum += arr.get(i);
        }

        int sumRight = 0;
        for (int i = arr.size()-1; i >= 0; i--) {
            if (sumRight == leftSums[i])
                return "YES";
            else
                sumRight += arr.get(i);
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
