package leetcode.LinkedList;

public class RemoveDuplicatesfromSortedList_83 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        // Straightforward - 0ms
//        ListNode node = head;
//        while (node!=null && node.next!=null){
//            if (node.val == node.next.val)
//                node.next = node.next.next;
//            else
//                node = node.next;
//        }
//        return head;

        // Recursion - 0ms
        if (head==null || head.next==null)
            return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val)
            //skip itself
            return head.next;
        else
            return head;
    }
}
