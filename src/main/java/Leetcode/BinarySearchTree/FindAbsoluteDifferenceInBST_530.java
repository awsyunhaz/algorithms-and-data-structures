package Leetcode.BinarySearchTree;

public class FindAbsoluteDifferenceInBST_530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Integer prev;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    public void traverse(TreeNode root){
        if (root == null)
            return;
        traverse(root.left);
        if (prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        traverse(root.right);
    }
}
