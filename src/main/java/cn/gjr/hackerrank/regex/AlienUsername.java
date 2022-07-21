package cn.gjr.hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * alien-username
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/alien-username">Alien Username</a>
 */
public class AlienUsername {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> inputs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        Pattern pattern = Pattern.compile("^[_.]\\d+[a-zA-Z]*_?$");
        inputs.stream().map(pattern::matcher).map(matcher -> matcher.matches() ? "VALID" : "INVALID").forEach(System.out::println);
    }

}
