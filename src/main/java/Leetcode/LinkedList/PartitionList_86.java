package Leetcode.LinkedList;

public class PartitionList_86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // one pass
    public ListNode partition(ListNode head, int x) {
        ListNode smallNode = new ListNode(0);
        ListNode bigNode = new ListNode(0);
        ListNode smallHead = smallNode;
        ListNode bigHead = bigNode;
        while (head != null) {
            if (head.val < x) {
                smallNode.next = new ListNode(head.val);
                smallNode = smallNode.next;
            } else {
                bigNode.next = new ListNode(head.val);
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        smallNode.next = bigHead.next;
        return smallHead.next;
    }
}
