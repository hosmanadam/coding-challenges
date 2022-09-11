import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    public static String gridChallenge(List<String> grid) {
        return areColumnsSorted(withSortedRows(grid)) ? "YES" : "NO";
    }

    private static boolean areColumnsSorted(List<List<Integer>> grid) {
        for (int col = 0; col < grid.get(0).size(); col++) {
            for (int row = 0; row < grid.size() - 1; row++) {
                if (grid.get(row).get(col) > grid.get(row + 1).get(col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<List<Integer>> withSortedRows(List<String> grid) {
        return grid.stream()
                .map(row -> row.chars().sorted().boxed().collect(toList()))
                .collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

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
