package com.leetcode.learn.solution.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class solution_200 {
    public static void main(String[] args) {
        char[][] c = new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        new solution_200().numIslands(c);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        Queue<int[]> queue = new LinkedList<>();
        int i,j,count = 0;
        int[] temp;
        //找第一个岛屿的起点
        for(int x = 0;x < grid.length;x++){
            for (int y = 0;y < grid[0].length;y++){
                if(grid[x][y] == '1') {
                    count++;
                    queue.add(new int[]{x, y});
                    grid[x][y] = '0';
                    //遍历当前岛屿
                    while(!queue.isEmpty()){
                        temp = queue.poll();
                        i = temp[0];
                        j = temp[1];
                        //右
                        if (j != grid[0].length - 1 && grid[i][j + 1] == '1') {
                            grid[i][j + 1] = '0';
                            queue.add(new int[]{i,j + 1});
                        }
                        //下
                        if (i != grid.length - 1 && grid[i + 1][j] == '1') {
                            grid[i + 1][j] = '0';
                            queue.add(new int[]{i + 1,j});
                        }
                        //左
                        if (j > 0 && grid[i][j - 1] == '1') {
                            grid[i][j - 1] = '0';
                            queue.add(new int[]{i,j - 1});
                        }
                        //上
                        if (i > 0 && grid[i - 1][j] == '1') {
                            grid[i - 1][j] = '0';
                            queue.add(new int[]{i - 1,j});
                        }
                    }
                }
            }
        }
        return count;
    }
}
