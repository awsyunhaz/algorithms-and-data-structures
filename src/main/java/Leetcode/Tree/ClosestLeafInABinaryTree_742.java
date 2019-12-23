package Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ClosestLeafInABinaryTree_742 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class GraphNode {
        Set<GraphNode> neighbors;
        int val;

        public GraphNode(int val) {
            neighbors = new HashSet();
            this.val = val;
        }

        public void connect(GraphNode node) {
            neighbors.add(node);
            node.neighbors.add(this);
        }
    }

    GraphNode target = null;

    public int findClosestLeaf(TreeNode root, int k) {
        if (root.left == null && root.right == null) {
            return k;
        }
        toGraph(root, k);
        Queue<GraphNode> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target.val);
        while (!queue.isEmpty()) {
            GraphNode gnode = queue.poll();
            if (gnode.neighbors.size() == 1 && gnode.val != root.val) {
                return gnode.val;
            }
            for (GraphNode neigh: gnode.neighbors) {
                if (!visited.contains(neigh.val)) {
                    queue.offer(neigh);
                    visited.add(neigh.val);
                }
            }
        }
        return 0;
    }

    public GraphNode toGraph(TreeNode tnode, int k) {
        GraphNode gnode = new GraphNode(tnode.val);
        if (tnode.val == k) {
            target = gnode;
        }
        if (tnode.left != null) {
            gnode.connect(toGraph(tnode.left, k));
        }
        if (tnode.right != null) {
            gnode.connect(toGraph(tnode.right, k));
        }
        return gnode;
    }
}
