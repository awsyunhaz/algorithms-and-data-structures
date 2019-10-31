package Leetcode.LinkedList;

public class FlattenAMultilevelDoublyLinkedList_430 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }

    }

    // Recursive
//    public Node flatten(Node head) {
//        getFlatten(head);
//        return head;
//    }
//
//    public Node getFlatten(Node node) {
//        while (node != null) {
//            if (node.child == null) {
//                if (node.next == null) {
//                    return node;
//                } else {
//                    node = node.next;
//                }
//            } else {
//                Node tail = getFlatten(node.child);
//                tail.next = node.next;
//                if (node.next != null) {
//                    node.next.prev = tail;
//                }
//                node.next = node.child;
//                node.child.prev = node;
//                node.child = null;
//            }
//        }
//        return node;
//    }

    // Iterative
    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child == null) {
                node = node.next;
            } else {
                Node tail = node.child;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = node.next;
                if (node.next != null) {
                    node.next.prev = tail;
                }
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
            }
        }
        return head;
    }
}
