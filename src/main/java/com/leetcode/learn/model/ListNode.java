package com.leetcode.learn.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 仿节点类
 * netx : 指向下一节点
 * val : 节点值
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) { val = x; }
     public ListNode(int[] ints) {
          Map<Integer,ListNode> map = new HashMap();
          if(ints.length > 0){
               val = ints[0];
               //判断是否存在子节点
               if(ints.length > 1){
                    //i > 0 使循环创建到head的子节点
                    for(int i = ints.length - 1;i > 0;i--){
                         ListNode node = new ListNode(ints[i]);
                         if(i != ints.length - 1){
                              node.next = map.get(i + 1);
                         }
                         map.put(i,node);
                    }
                    //指向子节点
                    next = map.get(1);
               }
          }
     }
}
