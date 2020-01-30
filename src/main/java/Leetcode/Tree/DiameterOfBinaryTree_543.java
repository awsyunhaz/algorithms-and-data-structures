package Leetcode.Tree;

public class DiameterOfBinaryTree_543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int diameterLeft = diameterOfBinaryTree(root.left);
//        int diameterRight = diameterOfBinaryTree(root.right);
//        int maxDiameter = Math.max(diameterLeft, diameterRight);
//        return Math.max(maxDepth(root.left) + maxDepth(root.right), maxDiameter);
//    }
//
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

    // Use global variable
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        maxDepth(root);
        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        res = Math.max(res, left+right);
        return Math.max(left, right) + 1;
    }
}
