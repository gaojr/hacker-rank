package cn.gjr.hackerrank.algorithms;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * lonely-integer
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/lonely-integer">Lonely Integer</a>
 */
public class LonelyInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>(a.size());
        a.forEach(i -> map.compute(i, (k, v) -> v == null ? 1 : v + 1));
        return map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(-1);
    }

}
