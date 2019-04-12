package Leetcode.LinkedList;

public class reverseList_206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        // Iterative
        // if (head==null)
        //     return head;
        // ListNode fast = head.next, slow = head;
        // head.next = null;
        // while (fast!=null){
        //     head = fast;
        //     fast = fast.next;
        //     head.next = slow;
        //     slow = head;
        // }
        // return head;

        // Recursive
        if (head==null || head.next==null)
            return head;
        // new head after reversion
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
