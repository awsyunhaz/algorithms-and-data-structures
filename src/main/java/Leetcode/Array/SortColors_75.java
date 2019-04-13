package Leetcode.Array;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length-1, ind = 0;
        while (ind <= hi){
            if (nums[ind]==0){
                nums[ind] = nums[lo];
                nums[lo++] = 0;
            }
            if (nums[ind]==2){
                nums[ind--] = nums[hi];
                nums[hi--] = 2;
            }
            ind++;
        }
    }
}
