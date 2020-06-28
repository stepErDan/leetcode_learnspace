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
        minSubArrayLen_2(7,new int[]{2,3,1,2,4,3});
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

    /**
     * 官方解法：前缀和 + 二分查找
     * 看了大半天，实际跑过才明白思路，这个二分查找妙啊，未找到取返回索引相反数-1，找到直接定位，与i相减取长度。
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen_2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
