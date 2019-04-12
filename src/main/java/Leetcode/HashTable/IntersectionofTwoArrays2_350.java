package Leetcode.HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionofTwoArrays2_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 2ms
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int i = 0;
        for (int num: nums2){
            if (map.containsKey(num) && map.get(num)>0){
                res[i++] = num;
                map.put(num, map.get(num)-1);
            }
        }
        return Arrays.copyOf(res, i);
    }
}
