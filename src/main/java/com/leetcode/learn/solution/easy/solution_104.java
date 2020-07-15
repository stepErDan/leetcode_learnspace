package com.leetcode.learn.solution.easy;

import com.leetcode.learn.model.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_104 {
    public static void main(String[] args) {
        new solution_104().maxDepth(new TreeNode(new Integer[]{0}));
    }

    /**
     * 官方解答
     * @param root
     * @return
     */
    public int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth_2(root.left);
            int right_height = maxDepth_2(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    private int deep = 1;
    private int index = 1;
    /**
     * 莫名其妙的[0]不给过,测试正常提交就不行了
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if(root == null){
            return index--;
        }
        deep = Math.max(deep,index);
        index++;
        maxDepth(root.left);
        index++;
        maxDepth(root.right);
        index--;
        return deep;
    }
}
