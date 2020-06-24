package com.leetcode.learn.solution.medium;

import com.leetcode.learn.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_016 {
    public void main(String[] args) {
        threeSumClosest(new int[]{-1,2,1,-4},1);
    }

    public int threeSumClosest(int[] nums, int target) {
        //定义存放绝对值的数组
        int[] abs = new int[4];
        //定义存放证书的Map
        Map result = new HashMap();
        //遍历处理
        for(int i = 0;i < nums.length;i++){
            if(i < 3){

            }
        }
        
        return 1;
    }
}
