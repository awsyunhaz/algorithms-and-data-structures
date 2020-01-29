package Leetcode.LinkedList;

public class RemoveLinkedListElements_203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Iteration
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    // Recursion
//    public ListNode removeElements(ListNode head, int val) {
//        if (head==null)
//            return head;
//        if (head.val==val)
//            return removeElements(head.next, val);
//        else{
//            head.next = removeElements(head.next, val);
//            return head;
//        }
//    }
}
