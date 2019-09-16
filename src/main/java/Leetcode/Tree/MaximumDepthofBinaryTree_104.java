package Leetcode.Tree;

public class MaximumDepthofBinaryTree_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }
}
