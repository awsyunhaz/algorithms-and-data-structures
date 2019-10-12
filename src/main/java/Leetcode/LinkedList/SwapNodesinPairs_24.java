package Leetcode.LinkedList;

public class SwapNodesinPairs_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Iteration
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode last = dummy;
//        while (head != null && head.next != null){
//            ListNode tmp = head.next.next;
//            last.next = head.next;
//            last.next.next = head;
//            head.next = tmp;
//            last = head;
//            head = tmp;
//        }
//        return dummy.next;
//    }

    // Recursion
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        node.next = head;
        return node;
    }
}
