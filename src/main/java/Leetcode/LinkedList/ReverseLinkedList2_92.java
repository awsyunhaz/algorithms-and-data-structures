package Leetcode.LinkedList;

public class ReverseLinkedList2_92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m-1; i++) {
            prev = prev.next;
        }
        ListNode slow = prev.next, fast = slow.next;
        for (int i = m; i < n; i ++) {
            ListNode succ = fast.next;
            fast.next = slow;
            slow = fast;
            fast = succ;
        }
        prev.next.next = fast;
        prev.next = slow;
        return dummy.next;
    }
}
