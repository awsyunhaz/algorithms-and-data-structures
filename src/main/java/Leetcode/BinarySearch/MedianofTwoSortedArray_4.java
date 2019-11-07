package Leetcode.BinarySearch;

public class MedianofTwoSortedArray_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Corner case: nums1 = [2,3,4,5], nums2 = [1]
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int lo = 0, hi = m;
        while (lo <= hi) {
            int mid1 = lo + (hi - lo) / 2;
            int mid2 = (m + n)/2 - mid1;
            int left1 = mid1 == 0? Integer.MIN_VALUE: nums1[mid1 - 1];
            int right1 = mid1 >= m? Integer.MAX_VALUE: nums1[mid1];
            int left2 = mid2 == 0? Integer.MIN_VALUE: nums2[mid2 - 1];
            int right2 = mid2 >= n? Integer.MAX_VALUE: nums2[mid2];
            if (left1 > right2) {
                hi = mid1 - 1;
            } else if (left2 > right1) {
                lo = mid1 + 1;
            } else {
                if ((m + n) % 2 == 0) {
                    double maxLeft = Math.max(left1, left2);
                    double minRight = Math.min(right1, right2);
                    return (maxLeft + minRight)/2;
                } else {
                    return Math.min((double)right1, (double)right2);
                }
            }
        }
        return 0.0;
    }
}
