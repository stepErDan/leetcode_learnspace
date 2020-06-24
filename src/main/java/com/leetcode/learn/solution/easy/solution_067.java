package com.leetcode.learn.solution.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_067 {
    public static void main(String[] args) {
        addBinary("11","1");
    }

    /**
     * @Author : own
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuffer num = new StringBuffer();
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        boolean addflag = false;
        int maxLength = (as.length > bs.length)?as.length:bs.length;
        int minLength = (as.length <= bs.length)?as.length:bs.length;
        for(int i = maxLength;i >= 1;i--){
            int index = maxLength - i;
            int type = 0;
            if(addflag){
                type++;
            }
            if((as.length - index) > 0 && '1' == as[as.length - index - 1])
                type++;
            if((bs.length - index) > 0 && '1' == bs[bs.length - index - 1])
                type++;
            switch(type){
                case 0:
                    addflag = false;
                    num.append("0");
                    break;
                case 1:
                    addflag = false;
                    num.append("1");
                    break;
                case 2:
                    addflag = true;
                    num.append("0");
                    break;
                case 3:
                    addflag = true;
                    num.append("1");
                    break;
            }
        }

        if(addflag){
            num.append("1");
        }

        return num.reverse().toString();
    }
}
