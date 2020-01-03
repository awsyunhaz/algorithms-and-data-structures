package Leetcode.LinkedList;

public class ReorderList_143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // O(n) - reverse half
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, prev = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        ListNode last = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = last;
            last = slow;
            slow = next;
        }
        prev.next = last;

        slow = head;
        fast = last;
        while (slow != prev) {
            ListNode slowNext = slow.next;
            ListNode fastNext = fast.next;
            prev.next = fastNext;
            slow.next = fast;
            fast.next = slowNext;
            slow = slowNext;
            fast = fastNext;
        }
    }
}
