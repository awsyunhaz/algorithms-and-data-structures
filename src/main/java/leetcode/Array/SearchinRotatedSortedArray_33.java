package leetcode.Array;

public class SearchinRotatedSortedArray_33 {
    //solution #1
//    public int search(int[] nums, int target) {
//        int lo=0, hi=nums.length-1;
//        while (lo<=hi){
//            int mid=(lo+hi)/2;
//            System.out.println(mid);
//            if (nums[mid]==target)
//                return mid;
//            if (nums[mid]>=nums[lo]){
//                if (target>=nums[lo] && target<nums[mid])
//                    hi = mid-1;
//                else
//                    lo = mid+1;
//            }
//            if (nums[mid]<=nums[hi]){
//                if (target<=nums[hi] && target>nums[mid])
//                    lo = mid+1;
//                else
//                    hi = mid-1;
//
//            }
//
//        }
//        return -1;

    //Solution #2 - binary search (realmid)
    //O(logn)
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo<hi){
            int mid = (lo+hi)/2;
            if (nums[mid]>nums[hi])
                lo = mid+1;
            else
                hi = mid;
        }
        int shift = lo, n = nums.length;
        lo = 0; hi = nums.length-1;
        while (lo<=hi){
            int mid = (lo+hi)/2;
            int realmid = (mid+shift)%n;
            if (nums[realmid]==target)
                return realmid;
            if (nums[realmid]<target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return -1;
    }

    public static void main(String[] args){
        SearchinRotatedSortedArray_33 obj = new SearchinRotatedSortedArray_33();
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
