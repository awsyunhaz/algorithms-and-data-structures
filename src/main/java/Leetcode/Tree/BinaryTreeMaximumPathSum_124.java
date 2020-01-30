package Leetcode.Tree;

public class BinaryTreeMaximumPathSum_124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return res;
    }

    public int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(pathSum(root.left), 0);
        int rightSum = Math.max(pathSum(root.right), 0);
        int sum = leftSum + rightSum + root.val;
        res = Math.max(res, sum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
