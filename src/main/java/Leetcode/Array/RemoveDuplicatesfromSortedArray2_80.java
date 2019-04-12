package Leetcode.Array;

public class RemoveDuplicatesfromSortedArray2_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int total_count = 1, num_count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]){
                if (num_count++ == 1)
                    nums[total_count++] = nums[i + 1];
            }
            else {
                num_count = 1;
                nums[total_count++] = nums[i + 1];
            }

        }
        return total_count;
    }
}
