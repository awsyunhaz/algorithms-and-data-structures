package Leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents_817 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int val: G){
            set.add(val);
        }
        int res = 0;
        ListNode last = null;
        while (head != null) {
            if (set.contains(head.val)) {
                if (last == null || last.next != head) {
                    res ++;
                }
                last = head;
            }
            head = head.next;
        }
        return res;
    }
}
