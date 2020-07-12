package com.leetcode.learn.solution.hard;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 *  
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *  
 *
 * 说明:
 *
 * 骑士的健康点数没有上限。
 *
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_174 {
    public static void main(String[] args) {
        int[][] dungeon = new int[][]{
            {1,-3,3},
            {0,-2,0},
            {-3,-3,-3}
        };
        new solution_174().calculateMinimumHP(dungeon);
    }

    /**
     *  官方dp
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    /**
     * 看了官方解答心态崩了，出发点就错了，应从终点开始反推，否则dp[无后效性]
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP_e(int[][] dungeon) {
        if(dungeon.length == 0){
            return 1;
        }
        //m为列长，n为行宽
        int m = dungeon.length,n = dungeon[0].length;
        //存放动态规划对象
        int[][] dp = new int[m][n];
        //这个存放路径最小历史值
        int[][] history = new int[m][n];
        //
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(j == 0){
                    //若j为0，只存在上一级向下或者原点的情况
                    dp[i][j] = i > 0?(dp[i - 1][j] + dungeon[i][j]):dungeon[i][j];
                    //记录历史最小值
                    history[i][j] = i > 0?Math.min(dp[i][j],history[i - 1][j]):Math.min(dp[i][j],history[i][j]);
                }else{
                    //思路错误，应根据历史最小值取较大的一条路
//                    //若i > 0，j > 0，则有从上向下，或从左向右，取其中较大值
//                    dp[i][j] = (i > 0?Math.max(dp[i - 1][j],dp[i][j - 1]):dp[i][j - 1]) + dungeon[i][j];
//                    //记录历史最小值
//                    history[i][j] = i > 0?(dp[i - 1][j] > dp[i][j - 1]?Math.min(dp[i][j],history[i - 1][j]):Math.min(dp[i][j],history[i][j - 1])):Math.min(dp[i][j],history[i][j - 1]);

                    //若i > 0，j > 0，则有从上向下，或从左向右，取其中历史最小值较大值
                    dp[i][j] = (i > 0?(history[i - 1][j] > history[i][j - 1]?dp[i - 1][j]:dp[i][j - 1]):dp[i][j - 1]) + dungeon[i][j];
                    //记录历史最小值
                    history[i][j] = i > 0?(history[i - 1][j] > history[i][j - 1]?Math.min(dp[i][j],history[i - 1][j]):Math.min(dp[i][j],history[i][j - 1])):Math.min(dp[i][j],history[i][j - 1]);
                }
            }
        }

        return 1 - history[m - 1][n - 1];
    }
}
