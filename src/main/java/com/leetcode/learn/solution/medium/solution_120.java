package com.leetcode.learn.solution.medium;

import java.util.*;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *  
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_120 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(Arrays.asList(new int[]{2}));
        list.add(Arrays.asList(new int[]{3,4}));
        list.add(Arrays.asList(new int[]{6,5,7}));
        list.add(Arrays.asList(new int[]{4,1,8,3}));
        new solution_120().minimumTotal(list);
    }

    /**
     * 惊了，空间复杂度O(n)不是很加分么？？？
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(0 >= n)
            return 0;
        Integer[] dp = triangle.get(n - 1).toArray(new Integer[n]);
        //倒排，从倒数第二层开始
        for(int i = n - 2;i >= 0;i--){
            for(int j = 0;j <= i;j++){
                dp[j] = Math.min(dp[j],dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 官方解答：自顶向下的dp
     * @param triangle
     * @return
     */
    public int minimumTotal_1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
