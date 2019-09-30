package Leetcode.Tree;

import java.util.Stack;

public class SymmetricTree_101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Recursive method - 1ms
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return isEqual(root.left, root.right);
    }

    private boolean isEqual(TreeNode l, TreeNode r){
        if (l==null && r==null) return true;
        if (l==null || r==null) return false;
        if (l.val != r.val) return false;
        return isEqual(l.left, r.right) && isEqual(l.right, r.left);
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
