package Leetcode.Random;

public class LinkedListRandomNode_382 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode_382(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        int res = 0;
        double i = 0;
        while (node != null) {
            i += 1;
            double rand = Math.random();
            if (rand < 1/i) {
                res = node.val;
            }
            node = node.next;
        }
        return res;
    }
}
