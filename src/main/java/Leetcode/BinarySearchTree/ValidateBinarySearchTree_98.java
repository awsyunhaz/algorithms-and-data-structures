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
        return valid(root, null, null);
    }

    public boolean valid(TreeNode root, Integer lowerbound, Integer upperbound){
        if (root == null) return true;
        if ((lowerbound != null && root.val <= lowerbound) ||
                (upperbound != null && root.val >= upperbound) ||
                !valid(root.left, lowerbound, root.val) || !valid (root.right, root.val, upperbound))
            return false;
        return true;
    }
}
