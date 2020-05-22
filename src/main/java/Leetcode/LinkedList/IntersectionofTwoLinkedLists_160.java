package Leetcode.LinkedList;

public class IntersectionofTwoLinkedLists_160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Get length difference
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null) {
            nodeA = nodeA.next;
            sizeA++;
        }
        while (nodeB != null) {
            nodeB = nodeB.next;
            sizeB++;
        }
        nodeA = headA;
        nodeB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++)
                nodeA = nodeA.next;
        } else {
            for (int i = 0; i < sizeB - sizeA; i++)
                nodeB = nodeB.next;
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    // Two pass, go to another list when hit the tail
    // do not have to know diff in length
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode nodeA = headA, nodeB = headB;
//        while (nodeA != nodeB) {
//            nodeA = nodeA == null? headB: nodeA.next;
//            nodeB = nodeB == null? headA: nodeB.next;
//        }
//        return nodeA;
//    }
}
