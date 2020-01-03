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
        return findMin(root, 1);
    }

    public int findMin(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            return level;
        }
        int leftDepth = root.left == null? Integer.MAX_VALUE: findMin(root.left, level+1);
        int rightDepth = root.right == null? Integer.MAX_VALUE: findMin(root.right, level+1);
        return Math.min(leftDepth, rightDepth);
    }
}
