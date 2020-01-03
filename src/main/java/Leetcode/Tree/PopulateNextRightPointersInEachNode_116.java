package Leetcode.Tree;

public class PopulateNextRightPointersInEachNode_116 {
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
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            connect(root.left);
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.right);
        }
        return root;
    }

    // Iterative - O(1) space
//    public Node connect(Node root) {
//        Node leftmost = root;
//        Node node = root;
//        while (node != null) {
//            if (node.left != null) {
//                node.left.next = node.right;
//            }
//            if (node.next != null) {
//                if (node.right != null) {
//                    node.right.next = node.next.left;
//                }
//                node = node.next;
//            } else {
//                node = leftmost.left;
//                leftmost = node;
//            }
//        }
//        return root;
//    }
}
