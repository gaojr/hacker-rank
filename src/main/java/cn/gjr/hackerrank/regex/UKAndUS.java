package cn.gjr.hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * uk-and-us
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/uk-and-us">The British and American Style of Spelling</a>
 */
public class UKAndUS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> sentences = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            sentences.add(scanner.nextLine());
        }
        int t = scanner.nextInt();
        scanner.nextLine();
        List<String> words = new ArrayList<>(t);
        for (int i = 0; i < t; i++) {
            words.add(scanner.nextLine());
        }
        scanner.close();

        for (String word : words) {
            int result = 0;
            Pattern pattern = Pattern.compile("\\b" + word.substring(0, word.length() - 2) + "[zs]e" + "\\b");
            for (String sentence : sentences) {
                Matcher matcher = pattern.matcher(sentence);
                while (matcher.find()) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

}
