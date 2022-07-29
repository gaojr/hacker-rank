package cn.gjr.hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * detecting-valid-latitude-and-longitude
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude">Detecting Valid Latitude and Longitude Pairs</a>
 */
public class DetectingValidLatitudeAndLongitudePairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> inputs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        Pattern pattern = Pattern.compile("^\\([+-]?(90(\\.0+)?|[1-8]\\d(\\.\\d+)?|\\d(\\.\\d+)?), [+-]?(180(\\.0+)?|1[0-7]\\d(\\.\\d+)?|[1-9]\\d(\\.\\d+)?|\\d(\\.\\d+)?)\\)$");
        inputs.stream().map(pattern::matcher).map(matcher -> matcher.matches() ? "Valid" : "Invalid").forEach(System.out::println);
    }

}
