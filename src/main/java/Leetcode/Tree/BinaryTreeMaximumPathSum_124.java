package Leetcode.Tree;

public class BinaryTreeMaximumPathSum_124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxSum;
    }

    // max path sum from root to leaf
    public int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(pathSum(root.left), 0);
        int rightSum = Math.max(pathSum(root.right), 0);
        int sum = leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum, sum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
