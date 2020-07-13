package com.leetcode.learn.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_350 {
    public static void main(String[] args) {
        new solution_350().intersect(new int[]{9,4,9,8,4},new int[]{4,9,5});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res;
        //排序，长的为1，短的为2
        if(nums1.length < nums2.length){
            res = nums1;
            nums1 = nums2;
            nums2 = res;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums2.length,l = 0;
        ArrayList temp = new ArrayList();
        for(int i = 0;i < m;i++){
            while(l < m && nums1[l] <= nums2[i]){
                if(nums1[l] == nums2[i]){
                    temp.add(nums2[i]);
                    l++;
                    break;
                }
                l++;
            }
        }
        res = new int[temp.size()];
        for(int i = 0;i < temp.size();i++){
            res[i] = (int)temp.get(i);
        }
        return res;
    }
}
