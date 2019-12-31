package Leetcode.Tree;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList_426 {
    /*
    Definition for a Node.
    */
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node first, last;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        first = new Node(0);
        last = first;
        inorderTraverse(root);

        first = first.right;
        first.left = last;
        last.right = first;
        return first;
    }

    public void inorderTraverse(Node root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        last.right = root;
        root.left = last;
        last = last.right;
        inorderTraverse(root.right);
    }
}
