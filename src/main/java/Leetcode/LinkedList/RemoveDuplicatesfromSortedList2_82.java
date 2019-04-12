package Leetcode.LinkedList;

public class RemoveDuplicatesfromSortedList2_82 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head){
        // Straightforward - 0ms
//        if (head==null)
//            return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode fast = dummy, slow = dummy;
//        ListNode resNode = slow;
//        while (fast.next!=null){
//            fast = fast.next;
//            while (fast.next!=null && fast.val==fast.next.val)
//                fast = fast.next;
//            if (slow.next==fast)
//                slow = slow.next;
//            else
//                slow.next = fast.next;
//        }
//        return resNode.next;

        // Recursion
        if (head==null)
            return head;
        if (head.next!=null && head.val==head.next.val) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            // Skip duplicate numbers
            return deleteDuplicates(head.next);
        }
        else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
