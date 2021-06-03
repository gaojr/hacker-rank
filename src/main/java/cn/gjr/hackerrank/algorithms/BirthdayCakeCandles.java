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
 * birthday-cake-candles
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/birthday-cake-candles">Birthday Cake Candles</a>
 */
public class BirthdayCakeCandles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        candles.sort((e1, e2) -> e2 - e1);
        int tallest = candles.get(0);
        int count = 1;
        for (int i = 1; i < candles.size(); i++) {
            if (tallest != candles.get(i)) {
                break;
            }
            count++;
        }
        return count;
    }

}
