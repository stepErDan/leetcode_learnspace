package com.leetcode.learn.solution.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_215 {
    public static void main(String[] args) {
        findKthLargest_1(new int[]{2,2,1,3,4,3},2);
    }

    /**
     * 讲真，就是提交玩玩的。。就真的成功了。。
     * 这题应该是考察排序的，，，？Arrays.sort不香吗
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 官方解答：最大堆
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest_1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for(int n : nums){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}
