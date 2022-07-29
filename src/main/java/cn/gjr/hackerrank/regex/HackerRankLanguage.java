package cn.gjr.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * hackerrank-language
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/hackerrank-language">HackerRank Language</a>
 */
public class HackerRankLanguage {

    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("^\\d{4,5} (C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)$");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            boolean b1 = p1.matcher(input).find();
            if (b1) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
            }
        }
        scanner.close();
    }

}
