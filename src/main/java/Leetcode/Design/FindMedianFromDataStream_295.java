package Leetcode.Design;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Binary search - O(logn)
//public class FindMedianFromDataStream_295 {
//    List<Integer> arr;
//
//    /** initialize your data structure here. */
//    public FindMedianFromDataStream_295() {
//        arr = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        int p = binarySearch(num, 0, arr.size());
//        arr.add(p, num);
//    }
//
//    public int binarySearch(int num, int lo, int hi) {
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if (arr.get(mid) <= num) {
//                lo = mid+1;
//            } else {
//                hi = mid;
//            }
//        }
//        return lo;
//    }
//
//    public double findMedian() {
//        if (arr.size() % 2 == 0) {
//            double m1 = arr.get(arr.size()/2-1);
//            double m2 = arr.get(arr.size()/2);
//            return (m1 + m2) / 2;
//        } else {
//            return arr.get(arr.size()/2);
//        }
//    }
//}

// Two heap - O(lgn)
class MedianFinder {

    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;

    /** initialize your data structure here. */
    public MedianFinder() {
        lower = new PriorityQueue<>((a,b) -> (b-a));
        higher = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lower.add(num);
        higher.add(lower.poll());
        if (lower.size() < higher.size()) {
            lower.add(higher.poll());
        }
    }

    public double findMedian() {
        if (lower.size() == higher.size()) {
            return (lower.peek() + higher.peek()) / 2.0;
        } else {
            return lower.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
