package com.leetcode.learn.model;

/**
 * 完全二叉树对象
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(Integer[] ints){
        this.ints = ints;
        TreeNode curr = graw(1);
        val = curr.val;
        left = curr.left;
        right = curr.right;
    }

    //抽离为常量
    private Integer[] ints;

    /**
     *
     * @param index 节点序号
     * @return
     */
    private TreeNode graw(int index){
        //防止越界
        if(index > ints.length){
            return null;
        }
        if(ints[index - 1] == null){
            return null;
        }
        TreeNode curr = new TreeNode(ints[index - 1]);
        //创建左子树
        curr.left = graw(index << 1);
        //创建右子树
        curr.right = graw((index << 1) + 1);
        return curr;
    }
}
