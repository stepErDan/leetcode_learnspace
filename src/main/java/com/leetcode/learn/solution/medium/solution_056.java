package com.leetcode.learn.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_056 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,4},
                {0,5}
        };
        System.out.println(new solution_056().merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> res = new ArrayList<>();
        int[] merges = new int[2];
        for(int i = 0;i < intervals.length;i++){
            if(i == intervals.length - 1){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
                break;
            }
            merges = new int[]{intervals[i][0],intervals[i][1]};
            if(intervals[i][1] >= intervals[i + 1][0]){
                while(i < intervals.length - 1 && merges[1] >= intervals[i + 1][0]){
                    merges[1] = merges[1] > intervals[i + 1][1]?merges[1]:intervals[i + 1][1];
                    i++;
                }
            }
            res.add(merges);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
