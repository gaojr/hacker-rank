package cn.gjr.hackerrank.contests_2020_8;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * equal-stacks
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/equal-stacks">Equal Stacks</a>
 */
public class EqualStacks {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> h1 = Stream.of(getStringArray(bufferedReader)).map(Integer::parseInt).collect(toList());
        List<Integer> h2 = Stream.of(getStringArray(bufferedReader)).map(Integer::parseInt).collect(toList());
        List<Integer> h3 = Stream.of(getStringArray(bufferedReader)).map(Integer::parseInt).collect(toList());

        int result = equalStacks(h1, h2, h3);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String[] getStringArray(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    }

    public static int equalStacks(List<Integer> a1, List<Integer> a2, List<Integer> a3) {
        int h1 = count(a1);
        int h2 = count(a2);
        int h3 = count(a3);
        int h = min(h1, h2, h3);
        while (h > 0) {
            if (h1 == h2 && h1 == h3) {
                return h1;
            }
            if (h1 > h) {
                a1.remove(0);
                h1 -= a1.remove(0);
            }
            if (h2 > h) {
                h2 -= a2.remove(0);
            }
            if (h3 > h) {
                h3 -= a3.remove(0);
            }
            h = min(h1, h2, h3);
        }
        return h;
    }

    private static int count(List<Integer> arr) {
        return arr.stream().mapToInt(a -> a).sum();
    }

    private static int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

}
