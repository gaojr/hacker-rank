package cn.gjr.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ide-identifying-comments
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/ide-identifying-comments">Building a Smart IDE: Identifying comments</a>
 */
public class IDEIdentifyingComments {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(scanner.nextLine().trim());
            sb.append("\n");
        } while (scanner.hasNext());
        scanner.close();

        Pattern pattern = Pattern.compile("//.*|/\\*[\\s\\S]*?\\*/");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }

}
