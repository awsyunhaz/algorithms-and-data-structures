package Leetcode.Design;

import java.util.HashMap;

// Double linked list + Hash map  - O(1)
public class LRUCache_146 {
    private class DLinkedNode {
        int key, value;
        DLinkedNode prev, next;

        public DLinkedNode() { }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private DLinkedNode head;
    private DLinkedNode tail;
    private HashMap<Integer, DLinkedNode> map;
    private int cap;

    public LRUCache_146(int capacity) {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = map.get(key);
        remove(node);
        addToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.value = value;
            remove(node);
            addToTail(node);
        } else {
            DLinkedNode node = new DLinkedNode(key, value);
            if (map.size() == cap) {
                map.remove(head.next.key);
                remove(head.next);
            }
            addToTail(node);
            map.put(node.key, node);
        }
    }

    public void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToTail(DLinkedNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}
