package Leetcode.HashMap;

import java.util.HashMap;

public class ContainsDuplicate2_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (seen.containsKey(nums[i])
                    && (Math.abs(seen.get(nums[i])-i) <= k))
                return true;
            seen.put(nums[i], i);
        }
        return false;
    }
}
