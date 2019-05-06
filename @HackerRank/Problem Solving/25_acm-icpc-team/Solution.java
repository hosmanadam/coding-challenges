/* https://www.hackerrank.com/challenges/acm-icpc-team/problem */

import java.io.*;
import java.util.*;

public class Solution {

    static int[] acmTeam(String[] topic) {
        int maxTopics = 0;
        int waysToForm = 0;
        int knownTopics;
        for (int i = 0; i < topic.length - 1; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                knownTopics = countKnownTopics(topic[i], topic[j]);
                if (knownTopics > maxTopics) {
                    maxTopics = knownTopics;
                    waysToForm = 1;
                } else if (knownTopics == maxTopics) {
                    waysToForm++;
                }
            }
        }
        return new int[] {maxTopics, waysToForm};
    }

    static int countKnownTopics(String member1, String member2) {
        int knownTopics = 0;
        for (int i = 0; i < member1.length(); i++) {
            if (member1.charAt(i) == '1' || member2.charAt(i) == '1')
                knownTopics++;
        }
        return knownTopics;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
