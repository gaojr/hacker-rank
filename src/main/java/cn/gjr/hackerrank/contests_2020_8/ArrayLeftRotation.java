package cn.gjr.hackerrank.contests_2020_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * array-left-rotation
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/array-left-rotation">Left Rotation</a>
 */
public class ArrayLeftRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = getInputArray(bufferedReader);
        int n = Integer.parseInt(firstMultipleInput[0]);
        int d = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> arr = Stream.of(getInputArray(bufferedReader)).map(Integer::parseInt).collect(toList());

        List<Integer> result = rotateLeft(n, d, arr);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String[] getInputArray(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    }

    public static List<Integer> rotateLeft(int n, int d, List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> left = arr.subList(0, d);
        List<Integer> right = arr.subList(d, n);
        right.addAll(left);
        return right;
    }

}
