package Leetcode.HashMap;

import java.util.HashSet;

public class IntersectionofTwoArrays_349 {

    // Two pointer - O(nlogn)
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        List<Integer> lis = new ArrayList<>();
//        int i = 0, j = 0;
//        while (i < nums1.length && j < nums2.length){
//            if (i > 0 && nums1[i] == nums1[i-1]){
//                i++;
//                continue;
//            }
//            if (j > 0 && nums2[j] == nums2[j-1]){
//                j++;
//                continue;
//            }
//            if (nums1[i] == nums2[j]){
//                lis.add(nums1[i]);
//                i++; j++;
//            }
//            else if (nums1[i] < nums2[j])
//                i++;
//            else
//                j++;
//
//        }
//        int[] res = new int[lis.size()];
//        for (i = 0; i < res.length; i++){
//            res[i] = lis.get(i);
//        }
//        return res;
//    }

    // Hash set - O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>(), res = new HashSet<>();
        for (int num: nums1){
            set.add(num);
        }
        for (int num: nums2){
            if (set.contains(num))
                res.add(num);
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (int num: res){
            arr[i++] = num;
        }
        return arr;
    }
}
