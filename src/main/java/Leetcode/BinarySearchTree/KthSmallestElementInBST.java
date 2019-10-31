package Leetcode.BinarySearchTree;

import java.util.ArrayList;

// Inorder traversal gives ascending order
// Follow up: add a count field to store the number of nodes in the left subtree
public class KthSmallestElementInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> lis = new ArrayList<>();
//        traverse(root, lis, k);
//        return lis.get(k-1);
//    }
//
//    public void traverse(TreeNode root, List<Integer> lis, int k) {
//        if (lis.size() == k || root == null)
//            return;
//        traverse(root.left, lis, k);
//        lis.add(root.val);
//        traverse(root.right, lis, k);
//    }

    private int rank = 0, res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k){
        if (root == null)
            return;
        traverse(root.left, k);
        rank ++;
        if (rank == k)
            res = root.val;
        traverse(root.right, k);
    }
}
