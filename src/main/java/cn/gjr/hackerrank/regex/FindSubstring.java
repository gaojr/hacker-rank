package cn.gjr.hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * find-substring
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/find-substring">Find A Sub-Word</a>
 */
public class FindSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> sentences = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            sentences.add(scanner.nextLine());
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        List<String> queries = new ArrayList<>(q);
        for (int i = 0; i < q; i++) {
            queries.add(scanner.nextLine());
        }
        scanner.close();

        for (String query : queries) {
            int result = 0;
            Pattern pattern = Pattern.compile("\\B" + query + "\\B");
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
