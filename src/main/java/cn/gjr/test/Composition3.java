package cn.gjr.test;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 把一个数分解成任意几个数之和，把一个数的所有和式分解的结果全部输出出来
 *
 * @author gaojr
 */
public class Composition3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //在控制台手动输入值  按enter键 便可得到结果
        while (true) {
            int sum = sc.nextInt();
            if (sum == 0) {
                break;
            }
            int count = sc.nextInt();
            Set<Result3> results;
            if (count == 1) {
                Result3 itself = new Result3();
                itself.add(sum);
                results = Collections.singleton(itself);
            } else {
                results = calc(sum);
            }
            List<String> strings = results.stream().map(Result3::toString).sorted().collect(Collectors.toList());
            System.out.println("总共 " + strings.size() + " 种情况");
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("------");
        }
    }

    public static Set<Result3> calc(int n) {
        Set<Result3> devideSet = new HashSet<>();
        Result3 result = new Result3();
        switch (n) {
            case 2:// 如果是2返回1+1
                result.add(1);
            case 1:// 如果是1直接返回1
                result.add(1);
                devideSet.add(result);
                break;
            default:
                for (int i = 1; i <= n / 2; i++) {
                    result = new Result3();
                    result.add(i);
                    result.add(n - i);
                    devideSet.add(result);
                    if (i <= n - i) {
                        Set<Result3> partial_pos = calc(n - i);//递归调用
                        for (Result3 pos : partial_pos) {
                            pos.add(i);
                            devideSet.add(pos);
                        }
                    }
                }
        }
        return devideSet;
    }

}

class Result3 extends ArrayList<Integer> {

    /**
     * 重写equals方法方便去重,排除掉重复的数据
     *
     * @param other 另一个对象
     * @return {@code true} 相等
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Result3)) {
            return false;
        }
        Result3 o = (Result3) other;
        if (this.isEmpty() || o.isEmpty() || this.size() != o.size()) {
            return false;
        }
        Collections.sort(this);
        Collections.sort(o);
        for (int i = 0; i < this.size(); i++) {
            if (!Objects.equals(this.get(i), o.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return this.stream().sorted().map(Object::toString).collect(Collectors.joining(" + "));
    }

}
