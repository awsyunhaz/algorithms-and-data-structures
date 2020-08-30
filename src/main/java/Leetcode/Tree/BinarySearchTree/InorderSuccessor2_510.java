package Leetcode.Tree.BinarySearchTree;

public class InorderSuccessor2_510 {
    public class Node {
        int val;
        Node left;
        Node right;
        Node parent;
        Node(int x) { val = x; }
    }

    public Node inorderSuccessor(Node node) {
        // find in parent
        if (node.right == null) {
            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }
            return node.parent;
        }
        // find in right subtree
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
