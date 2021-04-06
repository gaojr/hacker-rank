package cn.gjr.hackerrank.contests_2020_8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * pairs
 * TODO 提升效率
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/pairs">Pairs</a>
 */
public class Pairs {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        List<Integer> arr = new ArrayList<>(n);
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(arrItems[i]));
        }

        int result = pairs(k, arr);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }

    private static int pairs(int k, List<Integer> arr) {
        arr.sort(Comparator.reverseOrder());
        int count = 0;
        for (Integer i : arr) {
            if (i < k) {
                break;
            }
            if (arr.contains(i - k)) {
                count++;
            }
        }
        return count;
    }

}
