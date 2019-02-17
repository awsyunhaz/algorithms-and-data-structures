package leetcode.Array;

// binary search - O(logn)
public class FindFirstandLastElementinSortedArray_34 {

    // Return the first index of element >= target.
    private int getFirstIndexGreaterorEqual(int[] nums, int target){
        // `hi` is set to nums.length instead of nums.length-1.
        // Return nums.length if target is greater than every
        // element in the array
        int lo = 0, hi = nums.length;
        while (lo<hi){
            int mid = (lo + hi)/2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = getFirstIndexGreaterorEqual(nums, target);
        if (start==nums.length || nums[start]!=target)
            return new int[]{-1, -1};
        return new int[]{start, getFirstIndexGreaterorEqual(nums, target+1)-1};
    }

    public static void main(String[] args){
        FindFirstandLastElementinSortedArray_34 obj = new FindFirstandLastElementinSortedArray_34();
        System.out.println(obj.searchRange(new int[]{1}, 1)[1]);
    }
}
