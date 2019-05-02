/* https://www.hackerrank.com/challenges/picking-numbers/problem */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int pickingNumbers(List<Integer> nums) {
        Set<Integer> numSet = new TreeSet<>(nums);
        int maxSelectionLength = 0;
        int selectionLength;
        for (int baseNum : numSet) {
            selectionLength = 0;
            for (int num : nums) {
                if (num == baseNum || num == baseNum + 1)
                    selectionLength++;
            }
            if (selectionLength > maxSelectionLength)
                maxSelectionLength = selectionLength;
        }
        return maxSelectionLength;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
