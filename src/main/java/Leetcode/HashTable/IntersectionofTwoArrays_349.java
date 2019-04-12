package Leetcode.HashTable;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionofTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 2ms
        HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        // List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int num: nums1)
            set1.add(num);
        for (int num: nums2)
            set2.add(num);
        int[] res = new int[Math.min(set1.size(), set2.size())];
        for (int num: set2){
            if (set1.contains(num))
                // list.add(num);
                res[cnt++] = num;
        }
        // int[] res = new int[list.size()];
        // for (int i=0; i<list.size(); i++){
        //     res[i] = list.get(i);
        // }
        // return res;
        return Arrays.copyOf(res, cnt);
    }
}
