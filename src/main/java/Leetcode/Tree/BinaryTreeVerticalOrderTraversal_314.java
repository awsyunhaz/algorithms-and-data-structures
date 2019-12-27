package Leetcode.Tree;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int minLeft = 0;
    private int maxRight = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(new ArrayList<>());
        Queue<TreeNode> queue = new ArrayDeque<>();
        HashMap<TreeNode, Integer> biasMap = new HashMap<>();
        queue.offer(root);
        biasMap.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int bias = biasMap.get(node);
            if (bias < minLeft) {
                minLeft = bias;
                res.add(0, new ArrayList<>());
            }
            if (bias > maxRight) {
                maxRight = bias;
                res.add(new ArrayList<>());
            }
            res.get(bias - minLeft).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                biasMap.put(node.left, bias-1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                biasMap.put(node.right, bias+1);
            }
        }
        return res;
    }
}
