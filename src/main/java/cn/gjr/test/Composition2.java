package cn.gjr.test;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 把一个数分解成任意几个数之和，把一个数的所有和式分解的结果全部输出出来
 *
 * @author gaojr
 */
public class Composition2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //在控制台手动输入值  按enter键 便可得到结果
        while (true) {
            int sum = sc.nextInt();
            if (sum == 0) {
                break;
            }
            int count = sc.nextInt();
            calc(sum);
        }
        System.out.println();
    }

    public static void calc(int n) {
        int z = -1;
        for (int x = 1; x <= n / 2; x++) {
            z++;
            for (int y = 1 + z; y <= n - x; y++) {
                if (x == y) {
                    continue;
                }
                System.out.print(x + "+" + y);
                if (x + y <= n) {
                    for (int t = 1; t <= n - x - y; t++) {
                        System.out.print("+" + 1);
                    }
                    System.out.println();
                }
            }
        }
    }

}
