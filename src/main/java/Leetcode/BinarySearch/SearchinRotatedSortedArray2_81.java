package Leetcode.BinarySearch;

// O(n)
public class SearchinRotatedSortedArray2_81 {
    public boolean search(int[] nums, int target) {
        int p = 0;
        while (p < nums.length-1 && nums[p] <= nums[++p]);
        if (p > 0 && nums[p] >= nums[p-1])
            p = 0;
        int lo = 0, hi = nums.length-1, n = nums.length;
        while (lo <= hi){
            int mid = (lo + hi)/2;
            int realmid = (mid + p) % n;
            if (nums[realmid] == target)
                return true;
            else if (nums[realmid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }

    public static void main(String[] args){
        SearchinRotatedSortedArray2_81 obj = new SearchinRotatedSortedArray2_81();
        System.out.println(obj.search(new int[]{1,3}, 3));
    }
}
