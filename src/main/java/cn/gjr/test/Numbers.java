package cn.gjr.test;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 数字相关
 *
 * @author gaojr
 */
public class Numbers {

    private static final String 异常 = "异常";

    public static void main(String[] args) {
        List<Object> l = Lists.newArrayList(null, "null", "", "  ", "१२३", "१२ ३", "ab2c", "abc", "000", "012", "123", "123 ", "12 3",
                "12-3", "12.3", "-123", "+123", "０００", "０１２", "１２３", "１２３ ", "１２ ３", "１２-３", "１２.３", "-１２３", "+１２３",
                "-2147483649", "2147483648", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE - 1, Integer.MAX_VALUE + 1);
        l.forEach(Numbers::dose);
    }

    private static void dose(Object o) {
        List<Object> l = Lists.newArrayList();
        String s = o == null ? null : o.toString();
        if (s == null) {
            l.add("null");
        } else {
            l.add("\"" + s + "\"");
        }
        toInt(l, s);
        judge(l, s);
        System.out.println(org.apache.commons.lang.StringUtils.join(l, " | "));
    }

    private static void judge(List<Object> l, String s) {
        // commons-lang
        try {
            l.add(Boolean.toString(org.apache.commons.lang.StringUtils.isNumeric(s)));
            // 坑: ""会返回true
        } catch (Exception e) {
            l.add(异常);
        }
        try {
            l.add(Boolean.toString(org.apache.commons.lang.math.NumberUtils.isDigits(s)));
            // @see org.apache.commons.lang3.StringUtils#isNumeric
        } catch (Exception e) {
            l.add(异常);
        }
        // commons-lang3
        try {
            l.add(Boolean.toString(org.apache.commons.lang3.StringUtils.isNumeric(s)));
        } catch (Exception e) {
            l.add(异常);
        }
        try {
            l.add(Boolean.toString(org.apache.commons.lang3.math.NumberUtils.isDigits(s)));
            // @see org.apache.commons.lang3.StringUtils#isNumeric
        } catch (Exception e) {
            l.add(异常);
        }
        // JAVA自带的函数
        try {
            boolean flag = true;
            if (s == null || s.length() == 0) {
                flag = false;
            } else {
                for (int i = s.length(); --i >= 0; ) {
                    if (!Character.isDigit(s.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
            }
            l.add(Boolean.toString(flag));
        } catch (Exception e) {
            l.add(异常);
        }
        // ascii码
        try {
            boolean flag = true;
            if (s == null || s.length() == 0) {
                flag = false;
            } else {
                for (int i = s.length(); --i >= 0; ) {
                    char ch = s.charAt(i);
                    if (ch < 48 || ch > 57) {
                        flag = false;
                        break;
                    }
                }
            }
            l.add(Boolean.toString(flag));
        } catch (Exception e) {
            l.add(异常);
        }
        // 正则
        try {
            Pattern pattern = Pattern.compile("^[-+]?\\d*$");
            l.add(Boolean.toString(pattern.matcher(s).matches()));
        } catch (Exception e) {
            l.add(异常);
        }
    }


    private static void toInt(List<Object> l, String s) {
        try {
            l.add(Integer.parseInt(s));
        } catch (Exception e) {
            l.add(异常);
        }
        try {
            l.add(org.apache.commons.lang3.math.NumberUtils.toInt(s));
            // @see NumberUtils.toInt(s, 0)
        } catch (Exception e) {
            l.add(异常);
        }
        try {
            l.add(org.apache.commons.lang3.math.NumberUtils.toInt(s, -1));
        } catch (Exception e) {
            l.add(异常);
        }
    }

}
