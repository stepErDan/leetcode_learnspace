package com.leetcode.learn.solution.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_028 {
    public static void main(String[] args) {
        new solution_028().strStr("11","1");
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length() - needle.length() + 1,j;
        char[] a = haystack.toCharArray(),b = needle.toCharArray();
        for(int i = 0;i < n;i++){
            if(a[i] == b[0]){
                j = 1;
                while(j < b.length){
                    if(a[i + j] != b[j])
                        break;
                    j++;
                }
                if(j == b.length){
                    return i;
                }
            }
        }
        return -1;

    }
}
