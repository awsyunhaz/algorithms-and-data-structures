package Leetcode.Tree;

public class MinimumDepthOfBinaryTree_111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findMin(root);
    }

    public int findMin(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = root.left == null? Integer.MAX_VALUE: findMin(root.left);
        int rightDepth = root.right == null? Integer.MAX_VALUE: findMin(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
