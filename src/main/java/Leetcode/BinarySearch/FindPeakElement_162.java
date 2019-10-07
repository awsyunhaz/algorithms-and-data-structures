package Leetcode.BinarySearch;

public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi){
            int mid = (lo + hi) >> 1;
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            if (mid - 1 >= 0)
                left = nums[mid - 1];
            if (mid + 1 <= nums.length - 1)
                right = nums[mid + 1];
            if (left < nums[mid] && right < nums[mid])
                return mid;
            else if (nums[mid] < right)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}
