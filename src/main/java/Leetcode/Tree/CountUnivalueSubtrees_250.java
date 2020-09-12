package Leetcode.Tree;

public class CountUnivalueSubtrees_250 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        isUnival(root);
        return res;
    }

    public boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftUnival = isUnival(root.left), rightUnival = isUnival(root.right);
        boolean leftEqual = root.left == null || root.val == root.left.val;
        boolean rightEqual = root.right == null || root.val == root.right.val;
        if (leftUnival && rightUnival && leftEqual && rightEqual) {
            res ++;
            return true;
        }
        return false;
    }
}
