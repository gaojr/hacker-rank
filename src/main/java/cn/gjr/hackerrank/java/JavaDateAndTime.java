package cn.gjr.hackerrank.java;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * java-date-and-time
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/java-date-and-time">Java Date and Time</a>
 */
public class JavaDateAndTime {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);
        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

}

class Result {

    /**
     * @param month INTEGER
     * @param day INTEGER
     * @param year INTEGER
     * @return STRING
     */
    public static String findDay(int month, int day, int year) {
        String[] weekDays = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[dayOfWeek];
    }

}
