package Leetcode.Math;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber_136 {
    // Sort - 3ms
//    public int singleNumber(int[] nums) {
//        Arrays.algorithms.sort(nums);
//        for (int i = 0; i < nums.length - 1; i += 2) {
//            if (nums[i] != nums[i + 1])
//                return nums[i];
//        }
//        return nums[nums.length - 1];
//    }

    //Hash set - 6ms
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        Iterator<Integer> iter = set.iterator();
        return iter.next();
    }
}
