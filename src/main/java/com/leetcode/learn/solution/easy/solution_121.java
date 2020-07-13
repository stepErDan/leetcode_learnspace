package com.leetcode.learn.solution.easy;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_121 {
    public static void main(String[] args) {
        new solution_121().maxProfit(new int[]{1,2});
    }

    /**
     * 这算暴力法？搞不清
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int num = 0,buy;
        for(int i = 0,j;i < prices.length - 1;i++){
            while(i < prices.length - 1 && prices[i] > prices[i + 1]){
                i++;
            }
            //确定买入
            buy = prices[i];
            //循环卖出找最大值
            j = i + 1;
            while(j < prices.length){
                if(buy < prices[j])
                    num = Math.max(num,prices[j] - buy);
                j++;
            }
        }
        return num;
    }

    /**
     * 官方，移动卖出点，记录最小值，比较卖出点(i)与最小值(0_i-1)的差是否是利润最大值
     * @param prices
     * @return
     */
    public int maxProfit_1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
