package Leetcode.Design;

import java.util.HashMap;

public class LFUCache_460 {
    public class DLinkedNode {
        public int key, value, cnt;
        public DLinkedNode prev, next;

        public DLinkedNode() { }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
            cnt = 0;
        }
    }

    public class DLinkedList {
        public DLinkedNode head, tail;

        public DLinkedList() {
            head = new DLinkedNode();
            tail = new DLinkedNode();
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
            node.next = tail;
            tail.prev = node;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }

    HashMap<Integer, DLinkedNode> nodeMap; // key -> value
    HashMap<Integer, DLinkedList> cntMap; // frequency -> doubly linked list
    int cap, minCnt;

    public LFUCache_460(int capacity) {
        nodeMap = new HashMap<>();
        cntMap = new HashMap<>();
        cntMap.put(0, new DLinkedList());
        cap = capacity;
        minCnt = 0;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = nodeMap.get(key);
        updateCntMap(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (nodeMap.containsKey(key)) {
            DLinkedNode node = nodeMap.get(key);
            node.value = value;
            updateCntMap(node);
        } else {
            // Reach max capacity: remove first node in the minCnt list
            if (nodeMap.size() == cap) {
                DLinkedList list = cntMap.get(minCnt);
                DLinkedNode node = list.head.next;
                list.remove(node);
                nodeMap.remove(node.key);
            }
            // Add a new node to the list with 0 frequency
            DLinkedNode node = new DLinkedNode(key, value);
            nodeMap.put(key, node);
            cntMap.get(0).addToTail(node);
            minCnt = 0;
        }
    }

    // increment node frequency and add it to the tail of corresponding list in cntMap
    public void updateCntMap(DLinkedNode node) {
        DLinkedList list = cntMap.get(node.cnt);
        list.remove(node);
        // increment minCnt if minCnt list become empty
        if (node.cnt == minCnt && list.isEmpty()) {
            minCnt++;
        }
        node.cnt ++;
        if (!cntMap.containsKey(node.cnt)) {
            cntMap.put(node.cnt, new DLinkedList());
        }
        cntMap.get(node.cnt).addToTail(node);
    }
}
