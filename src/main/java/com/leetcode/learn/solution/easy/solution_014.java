package com.leetcode.learn.solution.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_014 {
    public static void main(String[] args) {
        System.out.println(new solution_014().longestCommonPrefix(new String[]{"flweq","flweqq","flow"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int index = 0;
        char c;
        for(;index >=0;index++){
            c = index < strs[0].length()?strs[0].charAt(index):'1';
            for(String s:strs){
                if(index == s.length() || c != s.charAt(index)){
                    return index == 0?"":strs[0].substring(0,index);
                }
            }
        }
        return "";
    }
}
