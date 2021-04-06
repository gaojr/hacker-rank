package cn.gjr.hackerrank.java;

import java.util.Scanner;

/**
 * java-output-formatting
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/java-output-formatting">Java Output Formatting</a>
 */
public class JavaOutputFormatting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            System.out.println(print(s, x));
        }
        System.out.println("================================");
    }

    private static String print(String s, int x) {
        return String.format("%-15s%03d", s, x);
    }

}
