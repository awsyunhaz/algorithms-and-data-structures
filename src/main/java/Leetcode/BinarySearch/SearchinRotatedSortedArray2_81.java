package Leetcode.BinarySearch;

// O(n)
public class SearchinRotatedSortedArray2_81 {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > nums[lo]) {      // lo ... mid is sorted
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1 ;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]) {      // mid ... hi is sorted
                if (target <= nums[hi] && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {        // had no idea, increment lo because nums[mid] = nums[lo]
                lo ++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        SearchinRotatedSortedArray2_81 obj = new SearchinRotatedSortedArray2_81();
        System.out.println(obj.search(new int[]{2,5,6,0,0,1,2}, 3));
    }
}
