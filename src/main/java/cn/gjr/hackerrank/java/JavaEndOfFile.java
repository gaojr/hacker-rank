package cn.gjr.hackerrank.java;

import java.util.Scanner;

/**
 * java-end-of-file
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/java-end-of-file">Java End-of-file</a>
 */
public class JavaEndOfFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; sc.hasNext(); i++) {
            String line = sc.nextLine();
            System.out.println(i + " " + line);
        }
    }

}
