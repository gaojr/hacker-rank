package cn.gjr.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 把一个数分解成任意几个数之和，把一个数的所有和式分解的结果全部输出出来（数独用）
 *
 * @author gaojr
 */
public class Composition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //在控制台手动输入值  按enter键 便可得到结果
        while (true) {
            int sum = sc.nextInt();
            if (sum == 0) {
                break;
            }
            int count = sc.nextInt();
            Set<Result> results;
            if (count == 0) {
                results = Collections.emptySet();
            } else if (count == 1) {
                Result itself = new Result();
                itself.add(sum);
                results = Collections.singleton(itself);
            } else {
                results = calc(sum, count);
            }
            // List<String> strings = results.stream().filter(c -> c.stream().allMatch(i -> i <= 9) && c.size() == count && c.stream().distinct().count() == count)
            List<String> strings = results.stream().map(Result::toString).sorted().collect(Collectors.toList());
            System.out.println("总共 " + strings.size() + " 种情况");
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("------");
        }
    }

    public static Set<Result> calc(int n, int count) {
        Set<Result> devideSet = new HashSet<>();
        if (count < 0) {
            return devideSet;
        }
        Result result = new Result();
        if (count == 1) {
            if (n <= 9) {
                result.add(n);
                devideSet.add(result);
            }
            return devideSet;
        }
        switch (n) {
            case 2:
            case 1:
                break;
            default:
                for (int i = 1; i <= n / 2 && i <= 9; i++) {
                    result = new Result();
                    if (i != n - i && n - i <= 9 && count == 2) {
                        result.add(i);
                        result.add(n - i);
                        devideSet.add(result);
                    }
                    if (i <= n - i) {
                        Set<Result> partial_pos = calc(n - i, count - 1);//递归调用
                        for (Result pos : partial_pos) {
                            if (pos.size() >= count || pos.contains(i)) {
                                continue;
                            }
                            pos.add(i);
                            devideSet.add(pos);
                        }
                    }
                }
        }
        return devideSet;
    }

}

class Result extends ArrayList<Integer> {

    /**
     * 重写equals方法方便去重,排除掉重复的数据
     *
     * @param other 另一个对象
     * @return {@code true} 相等
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Result)) {
            return false;
        }
        Result o = (Result) other;
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
