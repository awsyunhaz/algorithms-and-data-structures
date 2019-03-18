package leetcode.LinkedList;

public class SwapNodesinPairs_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        // Recursion - 2ms
        if (head==null || head.next==null)
            return head;
        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        node.next = head;
        return node;
    }
}
