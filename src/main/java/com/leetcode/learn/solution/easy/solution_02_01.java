package com.leetcode.learn.solution.easy;

import com.leetcode.learn.model.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 执行用时： 1367 ms  , 在所有 Java 提交中击败了 5.00% 的用户
 * 内存消耗： 44.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
 * 第一次击败100%！纪念一下
 */
public class solution_02_01 {
    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 2, 1});
        removeDuplicateNodes(head);
    }

    private static ListNode removeDuplicateNodes(ListNode head) {
        List<Integer> nodes = new ArrayList();
        if(head != null){
            nodes.add(head.val);
            check(head,nodes);
        }
        return head;
    }

    private static void check(ListNode head, List<Integer> nodes){
        if(head.next == null){
            return;
        }
        //如果head的子节点的值已存在，那么指向孙子节点
        if(nodes.contains(head.next.val)){
            head.next = head.next.next;
            //递归调用
            check(head,nodes);
        }else if(!nodes.contains(head.next.val)){
            nodes.add(head.next.val);
            //
            check(head.next,nodes);
        }
    }
}
