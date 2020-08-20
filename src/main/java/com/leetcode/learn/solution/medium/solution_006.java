package com.leetcode.learn.solution.medium;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class solution_006 {
    public static void main(String[] args) {
        System.out.println(new solution_006().convert("babad",2));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        int num = 0,n = s.length();
        for(int i = 0;i < numRows;i++){
            num = i;
            while(num < n){
                if(i != numRows - 1){
                    sb.append(s.charAt(num));
                    num = (numRows - i - 1) * 2 + num;
                }
                if(num < n && i != 0){
                    sb.append(s.charAt(num));
                    num = i * 2 + num;
                }
            }
        }
        return sb.toString();
    }
}
