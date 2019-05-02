/* https://www.hackerrank.com/challenges/migratory-birds/problem */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> counter = new TreeMap<>();
        Integer previousCount;
        for (int bird : arr) {
            previousCount = counter.putIfAbsent(bird, 1);
            if (previousCount != null)
                counter.put(bird, previousCount + 1);
        }

        int maxType = 0;
        int maxCount = 0;
        int count;
        for (Integer bird : counter.keySet()) {
            count = counter.get(bird);
            if (count > maxCount) {
                maxType = bird;
                maxCount = count;
            }
        }
        return maxType;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
