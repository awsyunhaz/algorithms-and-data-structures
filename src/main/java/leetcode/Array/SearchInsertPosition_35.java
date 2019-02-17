package leetcode.Array;

public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo<hi){
            int mid = (lo+hi)/2;
            if (nums[mid] < target)
                lo = mid+1;
            else
                hi = mid;
        }
        return lo;
    }
}
