package Leetcode.LinkedList;

/**
 * Definition for singly-linked list.
 * }
 */

public class RemoveNthNodeFromEndofList_19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)
            return null;
        ListNode fast = head, slow = head;
        for (int i=0; i<n; i++)
            fast = fast.next;
        if (fast==null)
            return head.next;
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
