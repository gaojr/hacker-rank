package cn.gjr.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * simple-array-sum
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/simple-array-sum">Simple Array Sum</a>
 */
public class SimpleArraySum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = simpleArraySum(arCount, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int simpleArraySum(int arCount, List<Integer> ar) {
        int sum = 0;
        for (Integer i : ar) {
            sum += i;
        }
        return sum;
    }

}
