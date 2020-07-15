package com.leetcode.learn.solution.medium;

import com.leetcode.learn.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_096 {
    public static void main(String[] args) {
        new solution_096().numTrees(5);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //先给dp赋值
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= i;j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 事实上我们在方法一中推导出的 G(n)函数的值在数学上被称为卡塔兰数
     * 没听过！不会！再见！
     */
}
