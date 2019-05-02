/* https://www.hackerrank.com/challenges/bon-appetit/problem? */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    static void bonAppetit(List<Integer> bill, int k, int b) {
        int annaShouldPay = (sum(bill) - bill.get(k)) / 2;
        int brianOwes = b - annaShouldPay;
        System.out.println(brianOwes == 0 ? "Bon Appetit" : brianOwes);
    }

    static int sum(List<Integer> nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
