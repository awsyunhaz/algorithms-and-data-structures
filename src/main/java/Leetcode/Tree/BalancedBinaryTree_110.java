package Leetcode.Tree;

public class BalancedBinaryTree_110 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right));
    }

    public int depth(TreeNode root){
        if (root == null)
            return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
