package com.leetcode.learn.solution.medium;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_287 {
    public static void main(String[] args) {
        new solution_287().findDuplicate(new int[]{1,3,4,2,2});
    }

    private int mid,res;

    /**
     * 超时解答，应该是O(n^2)级别的呀。。咋超时了呢
     * @param nums
     * @return
     */
    public int findDuplicate_e(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            res = search(0,nums.length - 1,i,nums);
            if(res != 0)
                return res;
        }
        return 0;
    }

    public int search(int l,int r,int i,int[] nums){
        if(l > r){
            return 0;
        }
        mid = l + ((r - l) >> 1);
        if(i == mid || nums[mid] != nums[i]){
            res = search(l,mid - 1,i,nums);
            if(res != 0)
                return res;
            res = search(mid + 1,r,i,nums);
            if(res != 0)
                return res;
        } else {
            return nums[mid];
        }
        return 0;
    }

    /**
     * 官方解答：
     * 其他两个解答没看懂先不挂了，
     * 这个假设，总长为n，ans记录当前数，cnt记录ans的左边若不重复会有多少个数，
     * 根据题意，cnt应为ans - 1，若cnt > ans - 1，则表示，重复数小于cnt，二分查找向下，否则向上查找
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
