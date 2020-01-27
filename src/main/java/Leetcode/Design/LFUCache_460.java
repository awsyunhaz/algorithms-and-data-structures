package Leetcode.Design;

import java.util.HashMap;

public class LFUCache_460 {

    public class DLinkedNode {
        DLinkedNode prev, next;
        int key, value, freq;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }

    public class DLinkedList {
        DLinkedNode head, tail;

        public DLinkedList() {
            head = new DLinkedNode(0, 0);
            tail = new DLinkedNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void remove(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addToTail(DLinkedNode node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            node.next = tail;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }

    private HashMap<Integer, DLinkedNode> nodeMap; // key -> node
    private HashMap<Integer, DLinkedList> listMap; // frequency -> doubly linked list
    private int capacity, minFreq;

    public LFUCache_460(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        listMap = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            DLinkedNode node = nodeMap.get(key);
            updateList(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (nodeMap.containsKey(key)) {
            DLinkedNode node = nodeMap.get(key);
            node.value = value;
            updateList(node);
        } else {
            // Reach max capacity: remove first node in the minFreq list
            if (nodeMap.size() == capacity) {
                DLinkedList minList = listMap.get(minFreq);
                nodeMap.remove(minList.head.next.key);
                minList.remove(minList.head.next);
                if (minList.isEmpty()) {
                    listMap.remove(minFreq);
                }
            }
            minFreq = 1;
            if (!listMap.containsKey(1)) {
                listMap.put(1, new DLinkedList());
            }
            DLinkedNode node = new DLinkedNode(key, value);
            nodeMap.put(key, node);
            listMap.get(1).addToTail(node);
        }
    }

    // Increment node frequency and add it to the tail of corresponding list in cntMap
    public void updateList(DLinkedNode node) {
        DLinkedList list = listMap.get(node.freq);
        list.remove(node);
        if (list.isEmpty()) {
            listMap.remove(node.freq);
            // increment minFreq if minFreq list become empty
            if (node.freq == minFreq) {
                minFreq ++;
            }
        }
        node.freq++;
        if (!listMap.containsKey(node.freq)) {
            listMap.put(node.freq, new DLinkedList());
        }
        listMap.get(node.freq).addToTail(node);
    }
}
