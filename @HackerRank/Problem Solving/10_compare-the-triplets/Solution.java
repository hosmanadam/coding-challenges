/* https://www.hackerrank.com/challenges/compare-the-triplets/problem */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

   static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
       int pointsA = 0;
       int pointsB = 0;
       for (int i = 0; i < a.size(); i++) {
           int comparison = a.get(i).compareTo(b.get(i));
           if (comparison > 0) {
               pointsA += 1;
           } else if (comparison < 0) {
               pointsB += 1;
           }
       }
       List<Integer> result = new ArrayList<>();
       result.add(pointsA);
       result.add(pointsB);
       return result;
   }

   public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
               .map(Integer::parseInt)
               .collect(toList());

       List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
               .map(Integer::parseInt)
               .collect(toList());

       List<Integer> result = compareTriplets(a, b);

       bufferedWriter.write(
               result.stream()
                       .map(Object::toString)
                       .collect(joining(" "))
                       + "\n"
       );

       bufferedReader.close();
       bufferedWriter.close();
   }
}
