package Leetcode.Tree;

import java.util.*;

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

    // Recursive DFS, preorder traversal
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverse(sb, root);
        return sb.toString();
    }

    public void traverse(StringBuffer sb, TreeNode root) {
        if (root == null) {
            sb.append('.');
        } else {
            sb.append(root.val);
        }
        sb.append(',');
        if (root != null) {
            traverse(sb, root.left);
            traverse(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(arr));
        return buildTree(queue);
    }

    public TreeNode buildTree(ArrayDeque<String> queue) {
        if (queue.peek().equals(".")) {
            queue.poll();
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(queue.peek()));
            queue.poll();
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }

    // Iterative BFS, level-order traversal
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        StringBuffer sb = new StringBuffer();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null) {
//                sb.append('.');
//            } else {
//                sb.append(node.val);
//            }
//            sb.append(',');
//            if (node != null) {
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }
//        }
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String[] strs = data.split(",");
//        if (strs[0].equals("*")) {
//            return null;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
//        queue.add(root);
//        for (int i = 1; i < strs.length; i+=2) {
//            TreeNode node = queue.poll();
//            if (!strs[i].equals("*")) {
//                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
//                node.left = left;
//                queue.add(left);
//            }
//            if (!strs[i+1].equals("*")) {
//                TreeNode right = new TreeNode(Integer.parseInt(strs[i+1]));
//                node.right = right;
//                queue.add(right);
//            }
//        }
//        return root;
//    }
}
