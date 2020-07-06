package com.leetcode.learn.solution.medium;

import com.leetcode.learn.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_095 {
    public static void main(String[] args) {
        new solution_095().generateTrees(5);
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList(); // 如果left或right为0，就会出现空指针异常。
        if (n == 0) return dp[0];
        dp[0].add(null);// 如果不加null，那么后面当left或right为0时，就不会执行for循环。而一旦left不执行，right也会被跳过。
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList();
            for (int root = 1; root <= i; root++) {
                int left = root - 1; // root为根节点，left是root左边的节点数。
                int right = i - root;// 同理，right为root右边的节点数。
                /*
                    假设n为5，root是3，那么左边有2个节点，所以去dp[2]里面找，右边也有两个节点4,5。所以还去dp[2]里面找。
                    因为只有dp[2]里面都是2个节点的数。但是dp[2]中的数只有1和2，我们要的是4,5。
                    我们不妨将1,2加上root，你会发现正好是4,5。
                    所以得到结论，左子树的值直接找前面节点数一样的dp索引，右子树的值也找前面一样的dp索引,
                    但是你需要加上root才能保证val是你需要的，所以右子树要重新创建，不然会破坏前面的树。
                */
                // 如果dp[left]里有两种可能，dp[right]里有三种可能，那么总共有6种可能。
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode newRoot = new TreeNode(root); // 这个是每一种可能的root节点。
                        newRoot.left = leftTree; // 左子树直接连接。
                        newRoot.right = clone(root, rightTree); // 右子树创建一个新的树。
                        dp[i].add(newRoot); // 将一种可能加入dp中。
                    }
                }
            }
        }
        return dp[n]; // 这个不用多说，答案在第n个数上。
    }

    public TreeNode clone(int val, TreeNode root) { // 重新创建一个新的子树
        if (root == null) return null; // 如果为null，返回
        TreeNode newTree = new TreeNode(val + root.val); // 创建节点时，不要忘了还要加上那个root。
        newTree.left = clone(val, root.left); // 递归左和右，和先序遍历很像。
        newTree.right = clone(val, root.right);
        return newTree; // 返回回去的这个节点正好跟在你需要的右子树上。
    }
}
