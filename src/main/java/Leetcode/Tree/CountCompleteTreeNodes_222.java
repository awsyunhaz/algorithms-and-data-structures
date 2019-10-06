package Leetcode.Tree;

public class CountCompleteTreeNodes_222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        int lDepth = leftDepth(root), rDepth = rightDepth(root);
        if (lDepth == rDepth){
            return (1 << lDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int leftDepth(TreeNode root){
        if (root == null)
            return 0;
        return leftDepth(root.left) + 1;
    }

    public int rightDepth(TreeNode root){
        if (root == null)
            return 0;
        return rightDepth(root.right) + 1;
    }
}
