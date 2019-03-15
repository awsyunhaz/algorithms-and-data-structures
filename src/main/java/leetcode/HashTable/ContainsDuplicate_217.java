package leetcode.HashTable;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> seen = new HashSet<>();
//        for (int num: nums){
//            if (!seen.add(num))
//                return true;
//        }
//        return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}
