package com.leetcode.learn.solution.medium;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_139 {
    public static void main(String[] args) {
        String[] wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(wordDict)));
    }

    /**
     * 动态规划：
     * 我们定义dp[i] 表示字符串 s 前 i 个字符组成的字符串s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
     * dp[i]=dp[j] && check(s[j..i−1])
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        //先转为set
        Set<String> wordDictSet = new HashSet(wordDict);
        //创建dp
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 超时解题思路
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak_e(String s, List<String> wordDict) {
        if("".equals(s)){
            return true;
        }
        //处理重复串
        boolean[] memo = new boolean[s.length()];
        System.out.println(memo[0]);
        //循环一层：遍历s，找出wordDict中是否有符合单词的字符串
        for(int i = 0;i < s.length(); i++){

        }
        //遍历完成不满足条件则返回false
        return false;
    }

    public static boolean forWordDict(String s,List<String> wordDict,int start,boolean[] memo){
//        for(int end = start + 1;end < s.length();end++){
//            if(memo[start] !== undefine){
//
//            }
//            //存在此字符串
//            if(wordDict.contains(s.substring(start,end))){
//                forWordDict(s,wordDict,end,memo);
//            }else if(s.indexOf(wordDict.get(i)) > 0){
//                continue;
//            }
//        }
        return false;
    }
}
