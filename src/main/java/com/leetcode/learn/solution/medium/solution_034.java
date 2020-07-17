package com.leetcode.learn.solution.medium;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_034 {
    public static void main(String[] args) {
        new solution_034().searchRange(new int[]{5,7,7,8,8,10},8);
    }

    public int[] searchRange(int[] nums, int target) {
        int mid,l = 0,r = nums.length - 1;
        while(l <= r){
            mid = l + ((r - l) >> 1);
            if(nums[mid] == target){
                l = mid;
                r = mid;
                while(--l > -1 && nums[l] == target){ }
                while(++r < nums.length && nums[r] == target){ }
                return new int[]{l + 1,r - 1};
            } else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return new int[]{-1 , -1};
    }
}
