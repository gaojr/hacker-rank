package cn.gjr.hackerrank.contests_2020_8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * sparse-arrays
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/sparse-arrays">Sparse Arrays</a>
 */
public class SparseArrays {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] strings = new String[stringsCount];
        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }
        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] queries = new String[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(stringsCount, strings, queriesCount, queries);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));
            if (i != res.length - 1) {
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }

    static int[] matchingStrings(int stringsCount, String[] strings, int queriesCount, String[] queries) {
        int[] result = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            String query = queries[i];
            for (int j = 0; j < stringsCount; j++) {
                String string = strings[j];
                if (query.equals(string)) {
                    result[i]++;
                }
            }
        }
        return result;
    }

}
