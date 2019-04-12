package Leetcode.HashTable;

import java.util.HashSet;

public class SetMismatch_645 {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int realsum = 0;
        for (int num: nums){
            realsum+=num;
            if (set.contains(num))
                res[0] = num;
            else
                set.add(num);
        }
        int sum = (1+nums.length)*nums.length/2;
        res[1] = sum-(realsum-res[0]);
        return res;
    }
}
