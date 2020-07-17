package com.leetcode.learn.solution.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *  
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 *  
 *
 * 说明:
 *
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *  
 *
 * 更新(2017/9/19):
 * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_658 {
    public static void main(String[] args) {
        new solution_658().findClosestElements(new int[]{1,1,1,10,10,10},2,9);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int mid = 0,l = 0,r = arr.length - 1;
        if(x >= arr[r]){
            mid = r;
        }else if(x <= arr[l]){
            mid = l;
        }else{
            //二分查找x的索引
            while(l < r){
                mid = l + ((r - l) >> 1);
                if(arr[mid] == x){
                    break;
                }else if(arr[mid] < x){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
        }
        if(mid > 0){
            mid = (Math.abs(arr[mid] - x) >= Math.abs(arr[mid - 1] - x))?mid - 1 : mid;
        }
        l = mid;
        r = mid;
        List<Integer> res = new ArrayList();
        for(int i = 1;i < k;i++){
            if(l == 0){
                ++r;
            }else if(r == arr.length - 1){
                --l;
            }else{
                mid = (Math.abs(arr[l - 1] - x) > Math.abs(arr[r + 1] -x))?++r:--l;
            }
        }
        for(int i = l;i < k + l;i++){
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * 官方解法：使用 Collection.sort()
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements_1(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a,b) -> a.equals(b) ? a - b : Math.abs(a-x) - Math.abs(b-x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }

    /**
     * 官方解法2：二叉查找和双指针
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements_2(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = ret.size();
        if (x <= ret.get(0)) {
            return ret.subList(0, k);
        } else if (ret.get(n - 1) <= x) {
            return ret.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(ret, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(ret.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x))
                    high--;
                else if ((x - ret.get(low)) > (ret.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return ret.subList(low, high + 1);
        }
    }
}
