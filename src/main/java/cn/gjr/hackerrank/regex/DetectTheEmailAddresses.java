package cn.gjr.hackerrank.regex;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/**
 * detect-the-email-addresses
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/detect-the-email-addresses">Detect the Email Addresses</a>
 */
public class DetectTheEmailAddresses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> inputs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        Set<String> emails = new HashSet<>();
        Pattern pattern = Pattern.compile("\\b\\w+(\\.\\w+)*@\\w+(\\.\\w+)*\\b");
        inputs.stream().map(pattern::matcher).forEach(matcher -> {
            while (matcher.find()) {
                emails.add(matcher.group());
            }
        });
        AtomicBoolean isFirst = new AtomicBoolean(true);
        emails.stream().sorted().forEach(s -> System.out.print(isFirst.getAndSet(false) ? s : ";" + s));
    }

}
