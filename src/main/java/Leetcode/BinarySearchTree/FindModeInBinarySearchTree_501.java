package Leetcode.BinarySearchTree;

import java.util.ArrayList;

// Inorder traversal gives ascending order!
public class FindModeInBinarySearchTree_501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private ArrayList<Integer> modes = new ArrayList<>();
    private TreeNode prev;
    private int max_mode, curr;

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++){
            res[i] = modes.get(i);
        }
        return res;
    }

    public void traverse(TreeNode root){
        if (root == null)
            return;
        traverse(root.left);
        if (prev != null && prev.val == root.val){
            curr ++;
        }
        else {
            curr = 1;
        }
        if (curr > max_mode){
            modes.clear();
            modes.add(root.val);
            max_mode = curr;
        } else if (curr == max_mode){
            modes.add(root.val);
        }
        prev = root;
        traverse(root.right);
    }
}
