package Leetcode.BinarySearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance_719 {

    // Heap - O((k+n)logn), TLE
//    public int smallestDistancePair(int[] nums, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length-1; i++) {
//            pq.offer(new int[]{nums[i+1] - nums[i], i, i+1});
//        }
//        while (k > 1 && !pq.isEmpty()) {
//            int[] item = pq.poll();
//            if (item[2] < nums.length - 1) {
//                int dis = nums[item[2]+1] - nums[item[1]];
//                pq.offer(new int[]{dis, item[1], item[2]+1});
//            }
//            k--;
//        }
//        return pq.poll()[0];
//    }

    // Binary search on distance
    // O(nlogn + nlogw), w = nums[nums.length - 1] - nums[0]
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // Binary search on distance
        int lo = 0, hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            // Count pairs with distance <= mid
            for (int i = 0; i < nums.length; i++) {
                int j = i + 1;
                while (j < nums.length && nums[j] - nums[i] <= mid) {
                    j++;
                }
                cnt += j - i - 1;
            }
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
