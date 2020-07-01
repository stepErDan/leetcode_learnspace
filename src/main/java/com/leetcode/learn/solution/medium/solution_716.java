package com.leetcode.learn.solution.medium;

import java.util.*;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_716 {
    public static void main(String[] args) {
        findLength_3(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7});
    }

    private static final long MOD = 1000000007;
    private static final long M = 100;

    /**
     * 大佬解法
     * @param A
     * @param B
     * @return
     */
    public static int findLength_3(int[] A, int[] B) {
        int l = 0;
        int r = A.length + 1;
        while (r - l > 1) {
            int mid = l + (r - l) / 2;
            if (find(A, B, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private static boolean find(int[] A, int[] B, int k) {
        if (k > A.length || k > B.length) {
            return false;
        }
        Map<Long, List<Integer>> map = new HashMap<>();
        long h = 1;
        for (int j = 0; j < k - 1; ++j) {
            h = h * M % MOD;
        }
        long val = 0;
        for (int i = 0; i < k; ++i) {
            val = (val * M + A[i]) % MOD;
        }
        map.put(val, new ArrayList<Integer>());
        map.get(val).add(0);
        for (int i = k; i < A.length; ++i) {
            val = val - h * A[i - k];
            val *= M;
            val = (val + A[i]) % MOD;
            if (val < 0) {
                val += MOD;
            }
            if (!map.containsKey(val)) {
                map.put(val, new ArrayList<Integer>());
            }
            map.get(val).add(i - k + 1);
        }

        val = 0;
        for (int i = 0; i < k; ++i) {
            val = (val * M + B[i]) % MOD;
        }
        if (map.containsKey(val) && check(A, B, map.get(val), 0, k)) {
            return true;
        }
        for (int i = k; i < B.length; ++i) {
            val = val - h * B[i - k];
            val *= M;
            val = (val + B[i]) % MOD;
            if (val < 0) {
                val += MOD;
            }
            if (map.containsKey(val) && check(A, B, map.get(val), i - k + 1, k)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(int[] A, int[] B, List<Integer> list, int startB, int k) {
        for (int startA : list) {
            if (checkHelper(A, B, startA, startB, k)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkHelper(int[] A, int[] B, int startA, int startB, int k) {
        for (int i = 0; i < k; ++i) {
            if (startA + i >= A.length || startB + i >= B.length
                    || A[startA + i] != B[startB + i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划一下。
     * @param A
     * @param B
     * @return
     */
    private static int findLength_2(int[] A, int[] B) {
        int max = 0;
        int[] dp = new int[B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = B.length; j >= 1; j--) {
                if (A[i - 1] == B[j - 1])
                    dp[j] = dp[j - 1] + 1;
                else
                    dp[j] = 0;
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    /**
     * 超时解答，抬走下一个
     * @param A
     * @param B
     * @return
     */
    private static int findLength(int[] A, int[] B) {
        for(int i = 0;i < A.length;i++){
            for(int j = 0; j <= i;j++){
                if(check(Arrays.copyOfRange(A,j,j + (A.length - i)),B)){
                    return (A.length - i);
                }
            }
        }
        return 1;
    }

    //比较数组B中是否包含A
    //A：比较数组
    //B：目标数组
    private static boolean check(int[] A, int[] B){
        //遍历B
        for(int i = 0;i <= B.length - A.length;i++){
            //比较第一个值相等，继续
            if(B[i] == A[0] && A.length != 1){
                //略过0
                for(int j = 1;j < A.length;j++){
                    if(A[j] != B[i + j]){
                        break;
                    }
                    //如果执行到最后一步，表示相同
                    if(j == (A.length - 1)){
                        return true;
                    }
                }
            }else if(B[i] == A[0]){
                return true;
            }
        }
        return false;
    }
}
