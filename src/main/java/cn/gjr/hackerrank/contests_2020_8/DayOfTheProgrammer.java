package cn.gjr.hackerrank.contests_2020_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * day-of-the-programmer
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/day-of-the-programmer">Day of the Programmer</a>
 */
public class DayOfTheProgrammer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static String dayOfProgrammer(int year) {
        String date;
        if (year == 1918) {
            return "26.09.1918";
        }
        if (year > 1918) {
            // Gregorian
            date = isLeapG(year) ? "12.09." : "13.09.";
        } else {
            // Julian
            date = isLeapJ(year) ? "12.09." : "13.09.";
        }
        return date + year;
    }

    /**
     * 判断闰年-Julian
     *
     * @param year 年份
     * @return {@code true} 是
     */
    private static boolean isLeapJ(int year) {
        return year % 4 == 0;
    }

    /**
     * 判断闰年-Gregorian
     *
     * @param year 年份
     * @return {@code true} 是
     */
    private static boolean isLeapG(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

}
