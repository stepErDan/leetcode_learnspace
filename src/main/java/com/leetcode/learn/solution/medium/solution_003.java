package com.leetcode.learn.solution.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_003 {
    public static void main(String[] args) {
        new solution_003().lengthOfLongestSubstring_3("abcabcbb");
    }


    private int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        //先转字符串数组
        char[] cs = s.toCharArray();
        int maxlen = 1;
        int index = 0;
        Set<Character> res = new HashSet<Character>();

        for(int i = 0;i < cs.length;i++){
            while(index < cs.length && res.add(cs[index])){
                index++;
            }
            maxlen = Math.max(maxlen,index - i);
            res.remove(cs[i]);
        }

        return maxlen;
    }


    /**
     * 官方
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_set(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 大佬法
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring_3(String s) {
        int[] freq = new int[256];

        int l = 0, r = -1;
        int res = 0;

        while (r + 1 < s.length()) {
            if (freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
