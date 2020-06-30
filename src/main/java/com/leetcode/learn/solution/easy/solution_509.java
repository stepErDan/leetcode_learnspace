package com.leetcode.learn.solution.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * 提示：
 *
 * 0 ≤ N ≤ 30
 */
public class solution_509 {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    private static HashMap<Integer,Integer> map = new HashMap();

    /**
     * 递归法
     * @param N
     * @return
     */
    private static int fib(int N) {
        if(map.containsKey(N)){
            return map.get(N);
        }
        if(N > 2){
            map.put(N,fib(N - 1) + fib(N - 1 - 1));
            return map.get(N);
        }else if(N <= 0){
            map.put(0,0);
            return 0;
        }else{
            map.put(1,1);
            return 1;
        }
    }

    /**
     * 动态规划法
     * @param N
     * @return
     */
    private static int fib_2(int N) {
        if(N < 2){
            return N;
        }
        int a = 0, b = 1,temp = 0;
        for(int i = 2;i <= N;i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
