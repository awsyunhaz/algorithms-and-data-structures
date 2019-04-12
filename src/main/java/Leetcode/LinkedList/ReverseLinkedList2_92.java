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
        ListNode curr = dummy;
        for (int i=0; i<m-1; i++)
            curr = curr.next;
        ListNode before = curr;
        curr = curr.next;
        ListNode succ = curr.next;
        ListNode prev = curr;
        for (int i=m; i<n; i++){
            curr = succ;
            succ = succ.next;
            curr.next = prev;
            prev = curr;
        }
        before.next.next = succ;
        before.next = curr;
        return dummy.next;
    }
}
