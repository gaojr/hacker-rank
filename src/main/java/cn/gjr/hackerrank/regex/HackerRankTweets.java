package cn.gjr.hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * hackerrank-tweets
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/hackerrank-tweets">HackerRank Tweets</a>
 */
public class HackerRankTweets {

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
//        Pattern pattern = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);
//        long count = 0L;
//        for (String input : inputs) {
//            Matcher matcher = pattern.matcher(input);
//            while (matcher.find()) {
//                count++;
//            }
//        }
//        System.out.println(count);
        Pattern pattern = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);
        long count = 0L;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            while (matcher.find()) {
                count++;
            }
        }
        scanner.close();
        System.out.println(count);
    }

}
