package cn.gjr.hackerrank.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * valid-pan-format
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/valid-pan-format">Valid PAN format</a>
 */
public class ValidPanFormat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Pattern pattern = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            System.out.println(pattern.matcher(s).matches() ? "YES" : "NO");
        }
        scanner.close();
    }

}
