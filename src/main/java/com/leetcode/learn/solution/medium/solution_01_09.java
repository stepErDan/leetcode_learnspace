package com.leetcode.learn.solution.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_01_09 {
    public static void main(String[] args) {
        new solution_01_09().setZeroes(new int[][]{{},{}});
    }


    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet();
        Set<Integer> cols = new HashSet();

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(Integer row : rows){
            for(int col = 0; col < matrix[0].length; col++){
                matrix[row][col] = 0;
            }
        }

        for(Integer col : cols){
            for(int row = 0; row < matrix.length; row++){
                matrix[row][col] = 0;
            }
        }
    }
}
