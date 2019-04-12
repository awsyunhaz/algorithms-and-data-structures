package Leetcode.LinkedList;

public class PartitionList_86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        // Two pointer - 0ms
        ListNode before = new ListNode(0);
        ListNode before_head = before;
        ListNode after = new ListNode(0);
        ListNode after_head = after;
        while (head!=null){
            if (head.val<x){
                before.next = head;
                before = before.next;
            }
            else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        before.next = after_head.next;
        after.next = null;
        return before_head.next;
    }
}
