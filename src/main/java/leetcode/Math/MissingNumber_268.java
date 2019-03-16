package leetcode.Math;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        //Sort - 7ms
//        if (nums[0]!=0)
//            return 0;
//        Arrays.algorithms.sort(nums);
//        for (int i = 0; i < nums.length-1; i++){
//            if (nums[i+1] != nums[i]+1)
//                return nums[i]+1;
//        }
//        return nums[nums.length-1]+1;

        //Hash set - 8ms
//        HashSet<Integer> set = new HashSet<>();
//        for (int num: nums){
//            set.add(num);
//        }
//        for (int i = 0; i < nums.length+1; i++){
//            if (!set.contains(i))
//                return i;
//        }
//        return 0;

        //Math - 0ms
        int sum = nums.length*(nums.length+1)/2;
        int realsum = 0;
        for (int num: nums)
            realsum+=num;
        return sum-realsum;
    }
}
