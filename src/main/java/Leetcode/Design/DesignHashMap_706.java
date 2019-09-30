package Leetcode.Design;

import java.util.ArrayList;

public class DesignHashMap_706 {
//    ArrayList - 73ms
//    class MyHashMap {
//        private ArrayList<ArrayList<int[]>> arr;
//
//        /** Initialize your data structure here. */
//        public MyHashMap() {
//            arr = new ArrayList<>();
//            for (int i = 0; i < 100; i++){
//                arr.add(new ArrayList<>());
//            }
//        }
//
//        /** value will always be non-negative. */
//        public void put(int key, int value) {
//            int hash = key % 100;
//            ArrayList<int[]> bucket = arr.get(hash);
//            if (bucket == null){
//                bucket = new ArrayList<>();
//            }
//            if (get(key) == -1){
//                bucket.add(new int[]{key, value});
//            } else{
//                for (int[] a: bucket){
//                    if (a[0] == key)
//                        a[1] = value;
//                }
//            }
//        }
//
//        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//        public int get(int key) {
//            int hash = key % 100;
//            if (arr.get(hash) != null){
//                for (int[] a: arr.get(hash)){
//                    if (a[0] == key)
//                        return a[1];
//                }
//            }
//            return -1;
//        }
//
//        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//        public void remove(int key) {
//            int hash = key % 100;
//            ArrayList<int[]> bucket = arr.get(hash);
//            if (bucket != null){
//                for (int i = 0; i < bucket.size(); i++){
//                    if (bucket.get(i)[0] == key)
//                        bucket.remove(i);
//                }
//            }
//        }

    // LinkedList - 65ms
    class MyHashMap {
        private ListNode[] arr;

        /** Initialize your data structure here. */
        public MyHashMap() {
            arr = new ListNode[100];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = key % 100;
            if (arr[hash] == null){
                arr[hash] = new ListNode(-1, -1);
            }
            ListNode node = arr[hash];
            while(node.key != key && node.next != null)
                node = node.next;
            if (node.key == key){
                node.val = value;
            } else {
                node.next = new ListNode(key, value);
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = key % 100;
            ListNode node = arr[hash];
            while(node != null && node.key != key)
                node = node.next;
            if (node == null) return -1;
            return node.val;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = key % 100;
            ListNode node = arr[hash];
            while(node != null && node.next != null && node.next.key != key)
                node = node.next;
            if (node != null && node.next != null){
                node.next = node.next.next;
            }
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
    }
}
