package Leetcode.BinarySearchTree;

public class ValidateBinarySearchTree_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public boolean isValidBST(TreeNode root) {
//        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean helper(TreeNode node, long min, long max){
//        if (node==null) return true;
//        if (node.val<=min || node.val>=max) return false;
//        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
//    }

    // Use Integer object
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }

    public boolean traverse(TreeNode root, Integer lowBound, Integer highBound) {
        if (root == null) {
            return true;
        }
        if (lowBound != null && root.val <= lowBound) {
            return false;
        }
        if (highBound != null && root.val >= highBound) {
            return false;
        }
        return traverse(root.left, lowBound, root.val) && traverse(root.right, root.val, highBound);
    }
}
