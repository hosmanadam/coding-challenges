/* https://www.hackerrank.com/challenges/matrix-rotation-algo/problem */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> result = deepcopy(matrix);
        int layers = Math.min(matrix.size(), matrix.get(0).size()) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int[][] indexes = peel(matrix, layer);
            int rotations = r % indexes.length;
            for (int i = 0; i < indexes.length; i++) {
                int[] from = indexes[(i + rotations) % indexes.length];
                int[] to = indexes[i];
                int value = matrix.get(from[0]).get(from[1]);
                result.get(to[0]).set(to[1], value);
            }
        }

        print(result);
    }

    /**
     * @param matrix The matrix to peel indexes from
     * @param layer 0-based index of matrix layer (counting from outside)
     * @return All <code>[row, col]</code> indexes belonging to requested <code>layer</code> of <code>matrix</code>
     */
    static int[][] peel(List<List<Integer>> matrix, int layer) {
        int height = matrix.size();
        int width = matrix.get(0).size();
        int layerSize = (width - 2 * layer - 1) * 2 + (height - 2 * layer - 1) * 2;

        int[][] indexes = new int[layerSize][2];
        int i = 0;
        for (int col = layer; col < width-layer-1; col++) {
            indexes[i++] = new int[] {layer, col};
        }
        for (int row = layer; row < height-layer-1; row++) {
            indexes[i++] = new int[] {row, width-layer-1};
        }
        for (int col = width-layer-1; col > layer; col--) {
            indexes[i++] = new int[] {height-layer-1, col};
        }
        for (int row = height-layer-1; row > layer; row--) {
            indexes[i++] = new int[] {row, layer};
        }

        return indexes;
    }

    static void print(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> deepcopy(List<List<Integer>> matrix) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> row : matrix) {
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
