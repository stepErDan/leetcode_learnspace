package com.leetcode.learn.solution.easy;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class solution_415 {
    public static void main(String[] args) {
        new solution_415().addStrings("12312323","321312");
    }

    public String addStrings(String num1, String num2) {
        int n1 = num1.length(),n2 = num2.length();
        StringBuffer sb = new StringBuffer();
        int add = 0,temp;
        char s1,s2;
        for(int i = 0;i < (n2 > n1?n2:n1);i++){
            s1 = (n1 - i - 1) >= 0?num1.charAt(n1 - i - 1):'0';
            s2 = (n2 - i - 1) >= 0?num2.charAt(n2 - i - 1):'0';
            temp = s1 + s2 - '0' * 2 + add;
            add = temp >= 10 ? 1 : 0;
            sb.append((temp % 10) + "");
        }
        if(add == 1)
            sb.append(add);
        return sb.reverse().toString();
    }
}
