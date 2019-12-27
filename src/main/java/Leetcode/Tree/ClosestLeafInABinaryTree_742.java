package Leetcode.Tree;

import java.util.*;

public class ClosestLeafInABinaryTree_742 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode target = null;

    public int findClosestLeaf(TreeNode root, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        traverse(root, parentMap, k);
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.val;
            }
            if (node.left != null && !visited.contains(node.left)) {
                queue.offer(node.left);
                visited.add(node.left);
            }
            if (node.right != null && !visited.contains(node.right)) {
                queue.offer(node.right);
                visited.add(node.right);
            }
            if (parentMap.containsKey(node)) {
                TreeNode parentNode = parentMap.get(node);
                if (!visited.contains(parentNode)) {
                    queue.offer(parentNode);
                    visited.add(parentNode);
                }
            }
        }
        return 0;
    }

    public void traverse(TreeNode node, HashMap<TreeNode, TreeNode> parentMap, int k) {
        if (node.val == k) {
            target = node;
        }
        if (node.left != null) {
            parentMap.put(node.left, node);
            traverse(node.left, parentMap, k);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            traverse(node.right, parentMap, k);
        }
    }
}
