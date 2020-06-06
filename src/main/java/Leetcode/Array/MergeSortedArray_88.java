package Leetcode.Array;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m --;
        n --;
        for (int i = nums1.length-1; i >= 0; i--) {
            if (m == -1) {
                nums1[i] = nums2[n--];
            } else if (n == -1) {
                nums1[i] = nums1[m--];
            } else {
                if (nums1[m] >= nums2[n]) {
                    nums1[i] = nums1[m--];
                } else {
                    nums1[i] = nums2[n--];
                }
            }
        }
    }
}
