package com.leetcode.learn.solution.medium;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_209 {
    public static void main(String[] args) {
        minSubArrayLen(4,new int[]{10,2,2});
    }

    /**
     *  假定nums为一个队列，定义index为起，end为末
     *  end先进行延伸，直到num大于s，index再向后延伸，直到num小于s
     *  重复直到end = nums.length
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        //定义最小长度
        int num = nums[0],minLen = 0;
        for(int index = 0,end = 0;index < nums.length - 1;){
            if(num >= s){
                do{
                    //如果长度大于最小值，依旧是原最小值
                    minLen = (end - index + 1) >= minLen && minLen != 0 ? minLen : (end - index + 1);
                    //如果长度为1，直接返回
                    if(minLen == 1)
                        return minLen;
                    num = num - nums[index];
                    index++;
                }while (num >= s);
            }
            do {
                ++end;
                if(end >= nums.length)
                    //如果最后一位相加都比s小，必然是此index-end段不存在此数组
                    return minLen;
                num += nums[end];
            }while(num < s);
        }
        return minLen;
    }
}
