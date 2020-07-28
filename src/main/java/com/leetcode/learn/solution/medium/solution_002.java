package com.leetcode.learn.solution.medium;

import com.leetcode.learn.model.ListNode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class solution_002 {
    public static void main(String[] args) {
        new solution_002().addTwoNumbers(new ListNode(new int[]{2,8}),new ListNode(new int[]{0}));
    }

    /**
     * 时间复杂度按理说也是O(Max(x,y))的，咋这么慢呢
     * 借鉴官方解法，可：
     *  1、将结果集带入到递归中，避免多一次循环
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num = ret(l1,l2,0,"");
        int n = num.length();
        ListNode next = new ListNode(Integer.parseInt(num.substring(n - 1,n)));
        ListNode curr = null;
        ListNode root = next;
        for(int i = 0;i < n;i++){
            if(curr != null) {
                next = new ListNode(Integer.parseInt(num.substring(n - 1 - i,n - i)));
                curr.next = next;
            }
            curr = next;
        }
        return root;
    }

    private String ret(ListNode l1, ListNode l2,int add,String num){
        if(l1 == null && l2 == null)
            return add == 0 ? num : "1" + num;
        else if(l1 == null || l2 == null){
            //num = add与非空的值相加模10取余数，最后加上num
            num = ((add + (l1 == null?l2.val:l1.val)) % 10) + num;
            add = (add + (l1 == null?l2.val:l1.val)) >= 10 ? 1 : 0 ;
            if(l1 == null)
                return ret(null,l2.next,add,num);
            else
                return ret(l1.next,null,add,num);
        }else{
            num = ((add + l1.val + l2.val) % 10) + num;
            add = (add + l1.val + l2.val) >= 10 ? 1 : 0;
        }
        return ret(l1.next,l2.next,add,num);
    }

    /**
     * 官方解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
