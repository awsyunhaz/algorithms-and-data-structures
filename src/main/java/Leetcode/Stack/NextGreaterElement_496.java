package Leetcode.Stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_496 {

    // Brute force - O(mn)
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int len1 = nums1.length, len2 = nums2.length;
//        int[] res = new int[len1];
//        for (int i = 0; i < len1; i++) {
//            int j = 0;
//            while (j < len2 && nums1[i] != nums2[j]) {
//                j++;
//            }
//            while (j < len2 && nums2[j] <= nums1[i]) {
//                j++;
//            }
//            if (j == len2) {
//                res[i] = -1;
//            } else {
//                res[i] = nums2[j];
//            }
//        }
//        return res;
//    }

    // Stack - O(m+n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
