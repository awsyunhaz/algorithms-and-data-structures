package Leetcode.Graph;

import java.util.HashMap;

public class CopyListWithRandomPointer_138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        return copy(head, map);
    }

    public Node copy(Node node, HashMap<Node, Node> map) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        Node newNode = new Node();
        map.put(node, newNode);
        newNode.val = node.val;
        newNode.next = copy(node.next, map);
        newNode.random = copy(node.random, map);
        return newNode;
    }
}
