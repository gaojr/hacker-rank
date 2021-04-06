package cn.gjr.hackerrank.contests_2020_8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * cavity-map
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/cavity-map">有洞的地图</a>
 */
public class CavityMap {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[][] grid = new String[n][n];
        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem.split("");
        }

        String[][] result = cavityMap(n, grid);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bufferedWriter.write(result[i][j]);
            }
            if (i != n - 1) {
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }

    private static String[][] cavityMap(int n, String[][] grid) {
        if (n < 3) {
            return grid;
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                String it = grid[i][j];
                String top = grid[i - 1][j];
                String bottom = grid[i + 1][j];
                String left = grid[i][j - 1];
                String right = grid[i][j + 1];
                if (deeper(it, top) && deeper(it, bottom) && deeper(it, left) && deeper(it, right)) {
                    grid[i][j] = "X";
                }
            }
        }
        return grid;
    }

    private static boolean deeper(String it, String other) {
        return it.compareTo(other) > 0;
    }

}
