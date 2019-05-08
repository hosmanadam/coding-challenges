/* https://www.hackerrank.com/challenges/flatland-space-stations/problem */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static int flatlandSpaceStations(int cities, int[] spaceStations) {
        List<Integer> sortedSpaceStations = Arrays.stream(spaceStations)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int distance;
        int maxDistance = Math.max(
                sortedSpaceStations.get(0),
                cities - 1 - sortedSpaceStations.get(sortedSpaceStations.size() -1)
        );
        for (int i = 0; i < sortedSpaceStations.size() - 1; i++) {
            distance = (sortedSpaceStations.get(i + 1) - sortedSpaceStations.get(i)) / 2;
            if (distance > maxDistance)
                maxDistance = distance;
        }

        return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
