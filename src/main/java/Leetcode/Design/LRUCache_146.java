package Leetcode.Design;

import java.util.HashMap;

// Double linked list + Hash map (for O() look up) - O(1)
public class LRUCache_146 {
    private DLinkedNode head;
    private DLinkedNode tail;
    private int cap;
    private int size;
    private HashMap<Integer, DLinkedNode> map;

    public LRUCache_146(int capacity) {
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        DLinkedNode node = map.get(key);
        deleteNode(node);
        addToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            DLinkedNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToTail(node);
        } else {
            if (size == cap){
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
            else
                size++;
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.value = value;
            addToTail(node);
            map.put(key, node);
        }
    }

    // private DLinkedNode find(int key){
    //     DLinkedNode node = head.next;
    //     while (node != tail && node.key != key) {
    //         node = node.next;
    //     }
    //     return node;
    // }

    private void deleteNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(DLinkedNode node){
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    private class DLinkedNode{
        int key, value;
        DLinkedNode prev, next;
    }
}
