package cn.gjr.hackerrank.contests_2020_8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * jim-and-the-orders
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/jim-and-the-orders">Jim和订单</a>
 */
public class JimAndTheOrders {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] orders = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        List<Integer> result = jimOrders(n, orders);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        for (int i = 0; i < n; i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != n - 1) {
                bufferedWriter.write(" ");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }

    static List<Integer> jimOrders(int n, int[][] orders) {
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int time = orders[i][0];
            int cost = orders[i][1];
            int total = time + cost;
            map.put(i + 1, total);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            int compare = o1.getValue() - o2.getValue();
            if (compare == 0) {
                return o1.getKey() - o2.getKey();
            }
            return compare;
        });
        return list.stream().map(Map.Entry::getKey).collect(Collectors.toList());

    }

}
