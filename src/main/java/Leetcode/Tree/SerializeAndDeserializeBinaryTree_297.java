package Leetcode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserializeBinaryTree_297 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append('.');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        traverse(root.left, sb);
        sb.append(',');
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> lis = new ArrayList();
        lis.addAll(Arrays.asList(data.split(",")));
        return buildTree(lis);
    }

    private TreeNode buildTree(List<String> lis) {
        String str = lis.remove(0);
        if (str.equals(".")) {
            return null;
        }
        int val = Integer.parseInt(str);
        TreeNode parent = new TreeNode(val);
        parent.left = buildTree(lis);
        parent.right = buildTree(lis);
        return parent;
    }
}
