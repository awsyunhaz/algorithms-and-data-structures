package leetcode.LinkedList;

import java.util.HashSet;

public class FindDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        // Time - O(n), space - O(n)
//        HashSet<Integer> set = new HashSet<>();
//        for (int num: nums){
//            if (set.contains(num))
//                return num;
//            set.add(num);
//        }
//        return 0;

        // LinkedList Cycle
        // Time - O(n), space - O(1)
        int fast = nums[nums[0]], slow = nums[0];
        while(fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int pointer = 0;
        while(slow != pointer){
            slow = nums[slow];
            pointer = nums[pointer];
        }
        return slow;
    }
}
