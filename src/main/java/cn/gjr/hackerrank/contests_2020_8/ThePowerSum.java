package cn.gjr.hackerrank.contests_2020_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the-power-sum
 * TODO 提升效率
 *
 * @author gaojr
 * @see <a href="https://www.hackerrank.com/contests/2020-8/challenges/the-power-sum">The Power Sum</a>
 */
public class ThePowerSum {

    public static void main(String[] args) {
        int X = 100;
        int N = 2;

        int result = powerSum(X, N);

        System.out.println(result);
    }

    static int powerSum(int target, int power) {
        int max = (int) Math.floor(Math.pow(target, 1.0 / power));
        int[] all = new int[max];
        for (int i = 1; i <= max; i++) {
            all[i - 1] = (int) Math.pow(i, power);
        }
        Map<Integer, List<int[]>> combination = getCombination(all);
        int count = 0;
        for (Map.Entry<Integer, List<int[]>> entry : combination.entrySet()) {
            for (int[] arr : entry.getValue()) {
                System.out.println(Arrays.toString(arr));
                int sum = 0;
                for (int i = arr.length - 1; i >= 0; i--) {
                    sum += arr[i];
                    if (sum > target) {
                        break;
                    }
                }
                if (sum == target) {
                    count++;
                }
            }
        }
        return count;
    }

    private static Map<Integer, List<int[]>> getCombination(int[] arr) {
        Map<Integer, List<int[]>> result = new HashMap<>(arr.length);
        for (int i = arr.length; i > 0; i--) {
            List<int[]> list = new ArrayList<>();
            dfs(list, arr, new int[i], 0, 0);
            result.put(i, list);
        }
        return result;
    }

    public static void dfs(List<int[]> list, int[] input, int[] output, int index, int start) {
        if (index == output.length) {
            list.add(Arrays.copyOf(output, index));
            return;
        }
        for (int j = start; j < input.length; j++) {
            output[index] = input[j];
            dfs(list, input, output, index + 1, j + 1);
        }
    }

}
