package cn.gjr.hackerrank.algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * cats-and-a-mouse
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/challenges/cats-and-a-mouse">Cats and a Mouse</a>
 */
public class CatsAndAMouse {

    private static final String CAT_A = "Cat A";
    private static final String CAT_B = "Cat B";
    private static final String MOUSE_C = "Mouse C";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < q; i++) {
            String[] xyz = scanner.nextLine().split(" ");
            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[1]);
            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }

    private static String catAndMouse(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        if (a > b) {
            return CAT_B;
        }
        if (a < b) {
            return CAT_A;
        }
        return MOUSE_C;
    }

}
