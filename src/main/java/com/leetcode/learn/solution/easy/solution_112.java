package com.leetcode.learn.solution.easy;

import com.leetcode.learn.model.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        System.out.println(new solution_112().hasPathSum(root,22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return loop(root,sum,0);
    }

    public boolean loop(TreeNode root, int sum, int num){
        if(root == null){
            return false;
        }
        num += root.val;
        //满足返回true的条件
        if(root.right == null && root.left == null && num == sum){
            return true;
        }else if(root.right == null && root.left == null){
            return false;
        }
        //向下递归
        if(loop(root.left,sum,num) || loop(root.right,sum,num)){
            return true;
        }
        return false;
    }
}
