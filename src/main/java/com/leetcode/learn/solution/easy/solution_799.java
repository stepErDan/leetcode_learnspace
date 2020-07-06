package com.leetcode.learn.solution.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 *
 * 例子:
 *
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 *
 * 注意：
 *
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_799 {
    public static void main(String[] args) {
        System.out.println(kthGrammar_e(4,3));
        System.out.println(kthGrammar(4,3));
    }

    /**
     * 看不懂的官方解法
     * @param N
     * @param K
     * @return
     */
    private static int kthGrammar_2(int N,int K){
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N-1, (K+1)/2);
    }

    /**
     * 解法：反转递归
     * @param N
     * @param K
     * @return
     */
    private static int kthGrammar(int N, int K) {
        int len = 1 << (N - 1 - 1);
        return loop_2(K,len);
    }

    private static int loop_2(int k,int len){
        if(k == 2){
            return 1;
        }else if(k == 1){
            return 0;
        }
        if(k > len){
            k = k - len;
            return loop_2(k,len >> 1) == 1?0:1;
        }else{
            return loop_2(k,len >> 1);
        }
    }

    /**
     * 超时解法，暴力法
     * @param N
     * @param K
     * @return
     */
    private static int kthGrammar_e(int N, int K) {
        List c = new ArrayList();
        loop(N,c);
        return (int) c.get(K - 1);
    }

    private static int loop(int n, List c){
        if(n == 1){
            c.add(0);
            return 1;
        }
        int len = loop(n - 1,c);
        int half = len;
        while(len < half * 2){
            if(0 == (int)c.get(len++ - half)){
                c.add(1);
            }else{
                c.add(0);
            }
        }
        System.out.println(c.toString());
        return len;
    }
}
