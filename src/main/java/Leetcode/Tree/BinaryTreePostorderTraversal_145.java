package Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null)
                traverse(root.left, result);
            if (root.right != null)
                traverse(root.right, result);
            result.add(root.val);
        }
    }

    // Iterative solution
//    public List<Integer> postorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node.left == null && node.right == null) {
//                res.add(node.val);
//            } else {
//                stack.push(node);
//                if (node.right != null) {
//                    stack.push(node.right);
//                    node.right = null;
//                }
//                if (node.left != null) {
//                    stack.push(node.left);
//                    node.left = null;
//                }
//            }
//        }
//        return res;
//    }

    // Iteration solution, easier with linked list
//    public List<Integer> postorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        LinkedList<Integer> res = new LinkedList<>();
//        if (root == null) {
//            return res;
//        }
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            res.addFirst(node.val);
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//        }
//        return res;
//    }
}
