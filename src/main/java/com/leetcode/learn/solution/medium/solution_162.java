package com.leetcode.learn.solution.medium;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_162 {
    public static void main(String[] args) {
        new solution_162().findPeakElement(new int[]{1,2,3,1});
    }

    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        else if(nums[0] > nums[1]){
            return 0;
        }else if(nums[nums.length - 1] > nums[nums.length - 2]){
            return nums.length - 1;
        }
        return search(1,nums.length - 2,nums);
    }

    public int search(int l,int r,int[] nums){
        if(l > r || l <= 0 || r >= nums.length - 1)
            return -1;
        int mid = l + ((r - l) >> 1);
        if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
            return mid;
        }
        int res = search(l,mid - 1,nums);
        if(res != - 1)
            return res;
        res = search(mid + 1,r,nums);
        if(res != - 1)
            return res;
        return -1;
    }
}
