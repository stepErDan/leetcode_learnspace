package com.leetcode.learn.solution.hard;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_041 {
    public static void main(String[] args) {
        firstMissingPositive(new int[]{1,2,0});
    }

    public static int firstMissingPositive(int[] nums) {
        int index = 0;
        Arrays.sort(nums);
        boolean flag = false;
        for(int i = 1;i > 0;i++){
            for(int item : nums){
                if(item == i){
                    flag = true;
                    break;
                }
            }
            if(flag){
                flag = false;
                continue;
            }else{
                index = i;
                break;
            }
        }
        return index;
    }
}
