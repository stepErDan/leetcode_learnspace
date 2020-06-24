package com.leetcode.learn.solution.medium;

import com.leetcode.learn.model.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class solution_024 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapPairs(head);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode swapPairs(ListNode head) {
        //交换双方的地址
        return swap(head);
    }

    /**
     * @Author : own
     * @param head
     * @return
     */
    public static ListNode swap(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //获取1的对象
        ListNode FirstNode = head;
        //获取2的对象
        ListNode SecondNode = head.next;
        //1的下一级指向3
        FirstNode.next = swap(SecondNode.next);
        //2的下一级指向1
        SecondNode.next = FirstNode;
        //递归调用
        return SecondNode;
    }

    /**
     * 解法2：迭代
     * @param head
     * @return
     */
    public ListNode swapPairs_2(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
