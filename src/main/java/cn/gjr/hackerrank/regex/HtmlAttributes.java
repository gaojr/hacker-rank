package cn.gjr.hackerrank.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * html-attributes
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/html-attributes">Detect HTML Attributes</a>
 */
public class HtmlAttributes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> inputs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        Map<String, Set<String>> result = new HashMap<>();
        Pattern pattern = Pattern.compile("<\\s*(\\w+)(.*?)>");
        Pattern pattern_attr = Pattern.compile("(?<=\\s)\\w+(?==)");
        inputs.stream().map(pattern::matcher).forEach(matcher -> {
            while (matcher.find()) {
                String group = matcher.group();
                String[] split = group.split(" ");
                String tag = split[0].replaceAll("[<>]", "");
                result.putIfAbsent(tag, new HashSet<>());
                Matcher m = pattern_attr.matcher(group);
                while (m.find()) {
                    String attr = m.group();
                    result.get(tag).add(attr);
                }
            }
        });
        result.keySet().stream().sorted().forEach(k -> {
            System.out.println(k + ":" + result.get(k).stream().sorted().collect(Collectors.joining(",")));
        });
    }

}
