package Leetcode.HashTable;

import java.util.HashMap;

// Hash map - O(n)
public class CopyListwithRandomPointer_138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head==null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node!=null){
            map.put(node, new Node());
            node = node.next;
        }

        node = head;
        while (node!=null){
            map.get(node).val = node.val;
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
