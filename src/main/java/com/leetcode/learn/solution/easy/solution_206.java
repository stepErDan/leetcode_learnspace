package com.leetcode.learn.solution.easy;

import com.leetcode.learn.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        reverseList(head);
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    private static ListNode reverseList_1(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    /**
     * 执行用时：0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 5.06% 的用户
     * 没有新建对象为啥内存消耗这么高……？？？
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        return swap(head,head.next);
    }

    private static ListNode swap(ListNode node,ListNode next){
        if(next == null){
            return node;
        }
        ListNode tmp = swap(node.next,next.next);
        node.next = null;
        next.next = node;
        return tmp;
    }
}
