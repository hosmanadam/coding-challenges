/* https://www.hackerrank.com/challenges/day-of-the-programmer/problem */

import java.io.*;
import java.util.*;

public class Solution {

    private static final int DAY_OF_THE_PROGRAMMER = 256;

    static String dayOfProgrammer(int year) {
        return getRussianDayOfYear(DAY_OF_THE_PROGRAMMER, year);
    }

    static String getRussianDayOfYear(int day, int year) {
        Map<Integer, Integer> months = getRussianMonths(year);
        int daysOfMonth;
        int dayAtStartOfMonth = 0;
        int dayAtEndOfMonth = 0;
        int monthResult = 0;
        int dayResult = 0;
        for (int month : months.keySet()) {
            daysOfMonth = months.get(month);
            dayAtEndOfMonth += daysOfMonth;
            if (dayAtEndOfMonth >= day) {
                monthResult = month;
                dayResult = day - dayAtStartOfMonth;
                break;
            }
            dayAtStartOfMonth += daysOfMonth;
        }
        return String.format("%02d.%02d.%d", dayResult, monthResult, year);
    }

    static Map<Integer, Integer> getRussianMonths(int year) {
        Map<Integer, Integer> months = new LinkedHashMap<>();
        months.put(1, 31);
        if (year == 1918)
            months.put(2, 15);
        else
            months.put(2, isRussianLeapYear(year) ? 29 : 28);
        months.put(3, 31);
        months.put(4, 30);
        months.put(5, 31);
        months.put(6, 30);
        months.put(7, 31);
        months.put(8, 31);
        months.put(9, 30);
        months.put(10, 31);
        months.put(11, 30);
        months.put(12, 31);
        return months;
    }

    static boolean isRussianLeapYear(int year) {
        if (year < 1918)
            return (year % 4 == 0);
        if (year > 1918)
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
