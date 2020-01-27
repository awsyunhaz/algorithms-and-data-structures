package Leetcode.Tree;

import java.util.Stack;

public class SymmetricTree_101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Recursive method - 0ms
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricSubtree(root.left, root.right);
    }

    public boolean isSymmetricSubtree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && isSymmetricSubtree(left.left, right.right) && isSymmetricSubtree(left.right, right.left);
        }
        return false;
    }

    // Iterative method - 2ms
    // Stack can hold null!
//    public boolean isSymmetric(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        if (root == null)
//            return true;
//        stack.push(root.left);
//        stack.push(root.right);
//        while (!stack.isEmpty()){
//            TreeNode right = stack.pop();
//            TreeNode left = stack.pop();
//            if (left == null && right == null) continue;
//            if (left == null || right == null || left.val != right.val)
//                return false;
//            stack.push(left.left);
//            stack.push(right.right);
//            stack.push(left.right);
//            stack.push(right.left);
//        }
//        return true;
//    }
}
