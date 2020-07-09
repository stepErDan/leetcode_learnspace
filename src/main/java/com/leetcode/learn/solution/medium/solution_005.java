package com.leetcode.learn.solution.medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_005 {
    public static void main(String[] args) {
        System.out.println(new solution_005().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int slen = s.length();
        if(slen <= 1){
            return s;
        }
        //初始化
        String res = s.substring(0,1);
        int left,right;
        for(int i = 1;i < slen;i++){
            //存在aa与aba两种情况，分类讨论
            for(int j = 0;j < 2;j++){
                left = i - 1 - j;
                right = i;
                while(right < slen && left >= 0 && s.charAt(left) == s.charAt(right)){
                    res = res.length() < (right - left + 1)?s.substring(left,right + 1):res;
                    left--;
                    right++;
                }
            }
        }
        return res;
    }
}
