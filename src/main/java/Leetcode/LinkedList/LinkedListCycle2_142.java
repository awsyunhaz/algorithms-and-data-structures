package Leetcode.LinkedList;

/**
 * Definition for singly-linked list.
 */

public class LinkedListCycle2_142 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head==null)
            return null;
        ListNode fast = head, slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                ListNode node = head;
                while (slow!=node){
                    slow = slow.next;
                    node = node.next;
                }
                return slow;
            }
        }
        return null;
    }
}
