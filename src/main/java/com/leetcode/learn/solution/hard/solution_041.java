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

    /**
     * 解二：符合复杂度要求
     * @param nums
     * @return
     */
    public int firstMissingPositive_2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int index = 0;
        //存放顺序数组
        int[] copy = new int[nums.length];
        Arrays.sort(nums);
        //索引定位到第一个正整数
        for(int i = 0,j = nums.length - 1,k = 0;i < nums.length;i++){
            if(nums[i] > 0){
                //与前一个一致的放到copy后方
                if(i > 0 && nums[i] == nums[i - 1]){
                    copy[j] = nums[i];
                    j--;
                }else{
                    //copy顺序存放顺序整数
                    copy[k] = nums[i];
                    k++;
                }
            }
        }
        for(int i = 1;i > 0;i++){
            //查看index是否与i一致
            if(copy.length >= i && copy[i - 1] != i){
                return i;
            }else if(copy.length < i){
                return i;
            }
        }
        return index;
    }

    /**
     * 解一：算法时间复杂度O(n^2)
     * @param nums
     * @return
     */
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
