package cn.gjr.hackerrank.regex;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/**
 * detect-the-domain-name
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/detect-the-domain-name">Detect the Domain Name</a>
 */
public class DetectTheDomainName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> inputs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        Set<String> targets = new HashSet<>();
        Pattern pattern = Pattern.compile("\\bhttps?://(ww[w2]\\.)?[\\w-]+\\.[\\w-.]*\\b");
        inputs.stream().map(pattern::matcher).forEach(matcher -> {
            while (matcher.find()) {
                targets.add(matcher.group());
            }
        });
        AtomicBoolean isFirst = new AtomicBoolean(true);
        targets.stream().map(s -> s.replaceAll("https?://(ww[w2]\\.)?", "")).distinct().sorted()
            .forEach(s -> System.out.print(isFirst.getAndSet(false) ? s : ";" + s));
    }

}
