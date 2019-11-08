package Leetcode.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums_373 {
    // Min heap - O(klogn), 63ms
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        int len1 = nums1.length, len2 = nums2.length;
//        if (len1 == 0 || len2 == 0)
//            return res;
//        PriorityQueue<Integer[]> heap = new PriorityQueue<Integer[]>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
//        for(int i = 0; i < nums1.length; i++){
//            for (int j = 0; j < nums2.length; j++){
//                heap.offer(new Integer[]{nums1[i], nums2[j]});
//            }
//        }
//        for (int i = 0; i < Math.min(k, len1*len2); i++){
//            res.add(Arrays.asList(heap.poll()));
//        }
//        return res;
//    }

    // Min heap row-wise push - O(klogk), 3ms
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 0 || len2 == 0)
            return res;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for(int i = 0; i < len1; i++){
            heap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k > 0 && heap.size() > 0){
            int[] item = heap.poll();
            k --;
            res.add(Arrays.asList(item[0], item[1]));
            if (item[2] < len2-1)
                heap.offer(new int[]{item[0], nums2[item[2]+1], item[2]+1});
        }
        return res;
    }
}
