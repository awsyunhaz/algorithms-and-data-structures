package Leetcode.Array;

import java.util.HashMap;

public class MajorityElement_169 {
    // HashMap - O(n) 10ms
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num: nums){
//            int cnt = map.getOrDefault(num, 0);
//            if (cnt + 1 > nums.length / 2)
//                return num;
//            map.put(num, cnt+1);
//        }
//        return -1;
//    }

    // Boyer-Moore Voting Algorithm - O(n) 1ms
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 0;
        for (int num: nums){
            if (cnt == 0){
                candidate = num;
            }
            if (num == candidate) cnt ++;
            else cnt --;
        }
        return candidate;
    }
}
