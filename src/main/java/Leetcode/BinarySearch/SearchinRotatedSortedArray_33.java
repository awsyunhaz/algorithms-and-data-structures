package Leetcode.BinarySearch;

public class SearchinRotatedSortedArray_33 {
    // Solution #1
    // corner case: arr[3, 1], target = 1
//    public int search(int[] nums, int target) {
//        int lo = 0, hi = nums.length - 1;
//        while (lo <= hi){
//            int mid = lo + (hi - lo) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] >= nums[lo]) {   // lo ... mid is sorted
//                if (nums[lo] <= target && nums[mid] > target) {
//                    hi = mid - 1;
//                } else {
//                    lo = mid + 1;
//                }
//            } else {      // mid ... hi is sorted
//                if (nums[hi] >= target && nums[mid] < target) {
//                    lo = mid + 1;
//                } else {
//                    hi = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }

    // Solution #2 - binary search, shift back
    // O(logn)
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int shift = lo;
        lo = 0;
        hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            int mid_shift = (mid + shift) % nums.length;
            if (nums[mid_shift] == target) {
                return mid_shift;
            } else if (nums[mid_shift] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        SearchinRotatedSortedArray_33 obj = new SearchinRotatedSortedArray_33();
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
