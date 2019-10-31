package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        search(root, "", res);
        return res;
    }

    public void search(TreeNode root, String curr, List<String> res) {
        if (root == null) {
            return;
        }
        if (curr.length() > 0) {
            curr += "->";
        }
        curr += Integer.toString(root.val);
        if (root.left == null && root.right == null) {
            res.add(curr);
        }
        search(root.left, curr, res);
        search(root.right, curr, res);
    }
}
