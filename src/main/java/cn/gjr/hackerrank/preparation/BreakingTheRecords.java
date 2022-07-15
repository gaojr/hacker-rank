package cn.gjr.hackerrank.preparation;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * breaking-best-and-worst-records
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/three-month-preparation-kit-breaking-best-and-worst-records">Breaking the Records</a>
 */
public class BreakingTheRecords {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        List<Integer> result = breakingRecords(scores);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static List<Integer> breakingRecords(List<Integer> scores) {
        int max = scores.get(0), min = scores.get(0), maxCount = 0, minCount = 0;
        for (int i = 1; i < scores.size(); i++) {
            Integer score = scores.get(i);
            if (score > max) {
                maxCount++;
                max = score;
            }
            if (score < min) {
                minCount++;
                min = score;
            }
        }
        return Arrays.asList(maxCount, minCount);
    }

}
