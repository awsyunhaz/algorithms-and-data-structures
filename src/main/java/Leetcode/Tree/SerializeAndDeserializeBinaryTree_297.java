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
//        // ArrayDeque cannot add null element
//        Queue<TreeNode> queue = new LinkedList<>();
//        String[] arr = data.split(",");
//        if (arr[0].equals(".")) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
//        queue.offer(root);
//        int i = 1;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (!arr[i].equals(".")) {
//                node.left = new TreeNode(Integer.parseInt(arr[i]));
//                queue.offer(node.left);
//            }
//            if (!arr[i+1].equals(".")) {
//                node.right = new TreeNode(Integer.parseInt(arr[i+1]));
//                queue.offer(node.right);
//            }
//            i += 2;
//        }
//        return root;
//    }
}
