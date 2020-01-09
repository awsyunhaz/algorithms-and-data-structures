package Leetcode.Array;

public class RotateArray_189 {
    // time: O(n), space: O(k)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[nums.length-k+i];
        }
        for (int i = nums.length-1; i >= k; i--) {
            nums[i] = nums[i-k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
    }

    // time: O(kn), space: O(1)
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        for (int i = 0; i < k; i++) {
//            int tmp = nums[nums.length-1];
//            for (int j = nums.length-1; j >= 1; j--) {
//                nums[j] = nums[j-1];
//            }
//            nums[0] = tmp;
//        }
//    }
}
