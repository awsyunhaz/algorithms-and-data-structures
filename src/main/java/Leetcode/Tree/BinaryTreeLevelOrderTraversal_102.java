package Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(res, root, 0);
        return res;
    }

    private void traverse(List<List<Integer>> res, TreeNode root, int level){
        if (root==null) return;
        if (level==res.size())
            res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        traverse(res, root.left, level+1);
        traverse(res, root.right, level+1);
    }

    // BFS
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        List<List<Integer>> res = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> lis = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                lis.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(lis);
//        }
//        return res;
//    }
}
