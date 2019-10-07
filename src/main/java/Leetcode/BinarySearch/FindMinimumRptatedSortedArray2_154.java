package Leetcode.BinarySearch;

public class FindMinimumRptatedSortedArray2_154 {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi){
            int mid = (lo + hi) >> 1;
            if (nums[mid] > nums[hi])
                lo = mid + 1;   // (mid, hi] is not sorted
            else if (nums[mid] < nums[lo])
                hi = mid;   // (lo, mid] is not sorted
            else    // nums[lo] <= nums[mid] <= nums[hi]
                hi --;  // shift the index of the largest value
        }
        return nums[lo];
    }
}
