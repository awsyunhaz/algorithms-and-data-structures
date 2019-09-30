package Leetcode.HashMap;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {

    // Brute force - O(n^2)
//    public int subarraySum(int[] nums, int k) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++){
//            int sum = 0;
//            for (int j = i; j < nums.length; j++){
//                sum += nums[j];
//                if (sum == k)
//                    res += 1;
//            }
//        }
//        return res;
//    }

    // HashMap - O(n)
    public int subarraySum(int[] nums, int k) {
        // sum[0, i-1] + sum[i,j] = sum[0,j]
        //      key         k         sum
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // the first time to reach k should be counted
        int sum = 0, res = 0;
        for (int num: nums){
            sum += num;
            if (map.containsKey(sum-k)){
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
