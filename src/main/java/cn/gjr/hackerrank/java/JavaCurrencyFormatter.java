package cn.gjr.hackerrank.java;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * java-currency-formatter
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/java-currency-formatter">Java Currency Formatter</a>
 */
public class JavaCurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + us.format(payment));
        System.out.println("India: Rs." + us.format(payment).replace("$", ""));
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + china.format(payment));
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + france.format(payment));
    }

}
