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
        Node headNextLevel = null;
        Node currNextLevel = null;
        while (node != null) {
            if (node.left != null) {
                if (headNextLevel == null) {
                    headNextLevel = node.left;
                } else {
                    currNextLevel.next = node.left;
                }
                currNextLevel = node.left;
            }

            if (node.right != null) {
                if (headNextLevel == null) {
                    headNextLevel = node.right;
                } else {
                    currNextLevel.next = node.right;
                }
                currNextLevel = node.right;
            }

            // Go to next level
            node = node.next;
            if (node == null) {
                node = headNextLevel;
                headNextLevel = null;
                currNextLevel = null;
            }
        }
        return root;
    }
}
