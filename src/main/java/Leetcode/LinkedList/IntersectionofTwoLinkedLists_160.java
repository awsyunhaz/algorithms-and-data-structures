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

    // Hashset - 7ms
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        HashSet<ListNode> seen = new HashSet<>();
//        while (headA!=null){
//            seen.add(headA);
//            headA = headA.next;
//        }
//        while (headB!=null && !seen.contains(headB)){
//            headB = headB.next;
//        }
//        return headB;
//    }

    // Two pass
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode nodeA = headA, nodeB = headB;
//        while (nodeA != nodeB) {
//            nodeA = nodeA == null? headB: nodeA.next;
//            nodeB = nodeB.next == null? headA: nodeB.next;
//        }
//        return nodeA;
//    }
}
