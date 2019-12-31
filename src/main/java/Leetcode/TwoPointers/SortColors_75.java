package Leetcode.TwoPointers;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int lo = 0, curr = 0, hi = nums.length - 1;
        while (curr <= hi) {
            if (nums[curr] == 0) {
                nums[curr++] = nums[lo];
                nums[lo++] = 0;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[hi];
                nums[hi--] = 2;
            } else {
                curr++;
            }
        }
    }
}
