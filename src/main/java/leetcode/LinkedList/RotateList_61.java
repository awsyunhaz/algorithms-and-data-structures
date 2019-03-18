package leetcode.LinkedList;

public class RotateList_61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        // 6ms
//        if (head==null)
//            return head;
//        ListNode fast = head, slow = head;
//        int size = 0;
//        while (fast!=null){
//            size++;
//            fast = fast.next;
//        }
//        fast = head;
//        for (int i=0; i<k%size; i++)
//            fast = fast.next;
//        while (fast.next!=null){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        fast.next = head;
//        head = slow.next;
//        slow.next = null;
//        return head;

        //Dummy head - 6ms
        if (head==null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int size = 0;
        while (fast.next!=null){
            size++;
            fast = fast.next;
        }
        for (int i = 0; i < size-k%size; i++)
            slow = slow.next;
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
