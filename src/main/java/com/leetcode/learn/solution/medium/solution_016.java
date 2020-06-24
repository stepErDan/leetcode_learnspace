package com.leetcode.learn.solution.medium;

import com.leetcode.learn.model.ListNode;

import java.util.Arrays;
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
    public static void main(String[] args) {
        threeSumClosest(new int[]{1,2,4,8,16,32,64,128},82);
    }



    /**
     * 最菜的暴力法完成打卡，今日耗时：4小时。。。。
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        //定义存放绝对值的数组
        int abs = Math.abs(nums[0] + nums[1] + nums[2] - target),num = nums[0] + nums[1] + nums[2],newAbs;
        //遍历处理
        for(int i = 0;i < nums.length - 2;i++){ //最外层循环
            for(int j = i + 1;j < nums.length - 1;j++){
                for(int k = j + 1;k < nums.length;k++){
                    newAbs = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if(newAbs < abs){
                        abs = newAbs;
                        num = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return num;
    }

    /**
     * 官方解法
     * 1、先对nums进行排序
     * 2、枚举第一个数，第二个数从第一个数后开始，第三个数从最后一个开始，
     *     求和，看和大了，第三个数退一，和小了第二个数进一，直到全部遍历
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest_2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    /**
     *错误解题思路，实际上适合两数求和，因为0和1绑定了。。。。。。。。。当然两数用不了这么复杂。。。。
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest_e_2(int[] nums, int target) {
        //定义存放绝对值的数组
        int abs = Math.abs(nums[0] + nums[1] + nums[2] - target),num = 0,newAbs;
        //定义结果集
        int[] result = {nums[0],nums[1],nums[2]},absResult = new int[3],temp = new int[2];
        //
        boolean flag = false;
        //遍历处理
        //1、判断绝对值是否小于最大的那个值
        //2、交换绝对值更小的那个值到abs中
        for(int i = 3;i < nums.length;i++){
            for(int j = 0;j < 3;j++){
                switch(j){
                    case 0:
                        newAbs = Math.abs(result[1] + result[2] + nums[i] - target);
                        break;
                    case 1:
                        newAbs = Math.abs(result[0] + result[2] + nums[i] - target);
                        break;
                    case 2:
                        newAbs = Math.abs(result[0] + result[1] + nums[i] - target);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + j);
                }
                //取绝对值最小的那一对儿
                if(newAbs < abs){
                    abs = newAbs;
                    temp = new int[]{j,nums[i]};
                    flag = true;
                }
            }
            if(flag && temp[1] == nums[i]){
                result[temp[0]] = nums[i];
                flag = false;
            }
            if(abs == 0){
                for(int item : result){
                    num += item;
                }
                return num;
            }
        }
        for(int item : result){
            num += item;
        }

        return num;
    }

    /**
     * 审题错误，还以为是要绝对值最接近target的三个数的和
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest_e(int[] nums, int target) {//定义存放绝对值的数组
        int[] abs = new int[3];
        //定义存放证书的Map
        int[][] result = new int[3][2];
        //定义绝对值、最后结果数对象
        int numAbs,resultNum = 0;
        //遍历处理
        //1、判断绝对值是否小于最大的那个值
        //2、交换绝对值更小的那个值到abs中
        for(int i = 0;i < nums.length;i++){
            numAbs = Math.abs(nums[i] - target);
            if(i < 3){
                abs[i] = numAbs;
                result[i] = new int[]{numAbs,nums[i]};
            }else{
                //先对abs进行排序
                Arrays.sort(abs);
                //取出最后一个与当前的数的绝对值比较
                if(abs[2] > numAbs){
                    //替换此数
                    for(int j = 0;j < result.length;j++){
                        if(result[j][0] == abs[2]){
                            result[j] = new int[]{numAbs,nums[i]};
                            break;
                        }
                    }
                    abs[2] = numAbs;
                }
            }
        }

        for(int[] item : result){
            resultNum += item[1];
        }

        return resultNum;
    }
}
