package Leetcode.Tree;

public class PopulateNextRightPointersInEachNode2_117 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Node node = root;
        Node nextHead = null;
        Node lastNode = null;
        while (node != null) {
            if (node.left != null) {
                if (nextHead == null) {
                    nextHead = node.left;
                }
                if (lastNode != null) {
                    lastNode.next = node.left;
                }
                lastNode = node.left;
            }
            if (node.right != null) {
                if (nextHead == null) {
                    nextHead = node.right;
                }
                if (lastNode != null) {
                    lastNode.next = node.right;
                }
                lastNode = node.right;
            }
            node = node.next;

            // Go to next level
            if (node == null) {
                node = nextHead;
                nextHead = null;
                lastNode = null;
            }
        }
        return root;
    }
}
