package cn.gjr.hackerrank.algorithms;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * mini-max-sum
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/mini-max-sum">Mini-Max Sum</a>
 */
public class MiniMaxSum {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        BigInteger[] arr = new BigInteger[5];
        for (int i = 0; i < 5; i++) {
            BigInteger arrItem = new BigInteger(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }

    private static void miniMaxSum(BigInteger[] arr) {
        Arrays.sort(arr);
        BigInteger minSum = arr[0].add(arr[1]).add(arr[2]).add(arr[3]);
        BigInteger maxSum = arr[4].add(arr[1]).add(arr[2]).add(arr[3]);
        System.out.print(minSum + " " + maxSum);
    }

}
