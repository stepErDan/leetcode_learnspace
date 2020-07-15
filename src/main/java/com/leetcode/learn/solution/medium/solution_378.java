package com.leetcode.learn.solution.medium;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_378 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  11,  111},
                {11, 22, 222},
                {12, 33, 333}
        };
        new solution_378().kthSmallest(matrix,8);
    }

    /**
     * 二分查找法，收束left与right，最后left = right即为所求
     * @param matrix
     * @param k
     * @return
     */
    private int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len - 1][len - 1];
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(check(k,mid,matrix,len)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int k,int mid,int[][] matrix,int len){
        int i = len - 1;
        int j = 0;
        int num = 0;
        while(i >= 0 && j < len){
            if(matrix[i][j] <= mid){
                num += i + 1;
                j++;
            }else{
                i--;
            }
        }
        return k > num;
    }
}
