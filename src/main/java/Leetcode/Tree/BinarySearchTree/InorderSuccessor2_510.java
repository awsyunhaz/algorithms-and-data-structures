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
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            // find leftmost
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // find the first larger parent
            while (node.parent != null) {
                if (node.parent.left == node) {
                    return node.parent;
                }
                node = node.parent;
            }
            return null;
        }
    }
}
