package com.leetcode.learn.solution.medium;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_064 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}
        };
        new solution_064().minPathSum(matrix);
    }

    /**
     * 优化后dp
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid.length <= 0){
            return 0;
        }
        //dp法
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];
        //第一列，稳定
        for(int i = 1;i < grid.length;i++){
            dp[i] = dp[i - 1] + grid[i][0];
        }
        for(int j = 1;j < grid[0].length;j++){
            for(int i = 0;i < grid.length;i++){
                dp[i] = (i == 0?dp[i]:Math.min(dp[i - 1],dp[i])) + grid[i][j];
            }
        }
        return dp[grid.length - 1];
    }
}
