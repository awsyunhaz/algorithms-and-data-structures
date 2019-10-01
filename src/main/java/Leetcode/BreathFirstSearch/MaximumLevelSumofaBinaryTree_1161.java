package Leetcode.BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree_1161 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0, sum, max = Integer.MIN_VALUE, max_level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            level ++;
            sum = 0;
            while (size -- > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (sum > max){
                max = sum;
                max_level = level;
            }
        }
        return max_level;
    }
}
