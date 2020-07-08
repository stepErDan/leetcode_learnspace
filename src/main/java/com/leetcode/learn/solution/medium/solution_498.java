package com.leetcode.learn.solution.medium;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *  
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 解释:
 *
 *  
 *
 * 说明:
 *
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_498 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}
        };
        new solution_498().findDiagonalOrder(matrix);
    }

    /**
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N*M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }

    /**
     * 仅适用于矩阵的错误解答
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder_e(int[][] matrix) {
        int[] res = new int[matrix.length * matrix[0].length];
        int i = 0,j = 0,index = 0,sum = 0;
        boolean isJs,imax,jmax;
        while(index < res.length){
            imax = j >= (matrix.length - 1);
            jmax = i >= (matrix[0].length - 1);
            isJs = (i + j) % 2 == 1;
            sum = Math.abs(i - j) + 1;
            for(int p = 1;p <= sum;p++){
                res[index++] = matrix[i][j];
                if(p == sum){
                    if(imax){
                        j++;
                    }else if(jmax){
                        i++;
                    }else{
                        if (i == 0) {
                            j++;
                        } else {
                            i++;
                        }
                    }
                }else if(isJs){
                    i++;
                    j--;
                }else{
                    i--;
                    j++;
                }
            }
        }
        return res;
    }
}
