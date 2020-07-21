package com.leetcode.learn.solution.hard;

import java.util.Arrays;

/**
 * 719. 找出第 k 小的距离对
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 *
 * 示例 1:
 *
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * 提示:
 *
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class solution_719 {
    public static void main(String[] args) {
        new solution_719().smallestDistancePair(new int[]{1,2,4,6,2,5,7,2,5,46,4},20);
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len=nums.length;
        int low=0;
        int high=nums[len-1]-nums[0];

        while(low<high){
            int mid=low+(high-low)/2;
            int count=0;
            int left=0;
            for(int right=0; right<len; right++){
                while(nums[right]-nums[left]>mid) left++;
                //排序后，right 每 +1，就多出right - left种可能
                count+=right-left;
            }

            if(count>=k){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
