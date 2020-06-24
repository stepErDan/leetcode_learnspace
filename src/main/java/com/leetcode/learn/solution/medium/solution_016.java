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
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
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
