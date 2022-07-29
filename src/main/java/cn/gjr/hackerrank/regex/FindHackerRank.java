package cn.gjr.hackerrank.regex;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * find-hackerrank
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/find-hackerrank">Find HackerRank</a>
 */
public class FindHackerRank {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        List<String> inputs = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            inputs.add(scanner.nextLine());
//        }
//        scanner.close();
//
//        Pattern p1 = Pattern.compile("^hackerrank");
//        Pattern p2 = Pattern.compile("hackerrank$");
//        inputs.stream().forEach(input -> {
//            boolean b1 = p1.matcher(input).find();
//            boolean b2 = p2.matcher(input).find();
//            if (b1 && b2) {
//                System.out.println(0);
//            } else if (b1) {
//                System.out.println(1);
//            } else if (b2) {
//                System.out.println(2);
//            } else {
//                System.out.println(-1);
//            }
//        });
        Pattern p1 = Pattern.compile("^hackerrank");
        Pattern p2 = Pattern.compile("hackerrank$");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            boolean b1 = p1.matcher(input).find();
            boolean b2 = p2.matcher(input).find();
            if (b1 && b2) {
                System.out.println(0);
            } else if (b1) {
                System.out.println(1);
            } else if (b2) {
                System.out.println(2);
            } else {
                System.out.println(-1);
            }
        }
        scanner.close();
    }

}
