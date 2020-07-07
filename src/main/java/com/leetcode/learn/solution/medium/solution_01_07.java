package com.leetcode.learn.solution.medium;

/**
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_01_07 {
    public static void main(String[] args) {
        new solution_01_07().rotate(new int[][]{{},{}});
    }

    /**
     * 弟弟解法
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return ;
        }
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                res[j][matrix[0].length - 1 - i] = matrix[i][j];
            }
        }
        for(int i = 0;i < matrix.length;i++){
            matrix[i] = res[i];
        }
    }

    /**
     * 先水平翻转，再对角翻转
     * @param matrix
     */
    public void rotate_2(int[][] matrix){
        int n = matrix.length;
        int temp = 0;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 四点循环，奇偶讨论
     * @param matrix
     */
    public void rotate_3(int[][] matrix){
        int size = matrix.length;
        int n = size % 2 == 1?(size / 2) + 1:(size / 2);
        int temp;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (size % 2 == 1?n - 1:n); ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[size - 1 - j][i];
                matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
                matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
                matrix[j][size - 1 - i] = temp;
            }
        }
    }
}
