package Leetcode.Tree.BinarySearchTree;

public class CloestBinarySearchTreeValue_270 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int closestValue(TreeNode root, double target) {
        double res = root.val;
        while (root != null) {
            if (Math.abs((double) root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return (int) res;
    }
}
