package Leetcode.DivideandConquer;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    // Divide and Conquer - O(nlgn), O(n^2) worst (sorted array)
//    public int largestRectangleArea(int[] heights) {
//        if (heights.length == 0)
//            return 0;
//        return largestArea(heights, 0, heights.length-1);
//    }
//
//    public int largestArea(int[] heights, int lo, int hi) {
//        if (lo > hi)
//            return -1;
//        int minInd = lo;
//        for (int i = lo; i <= hi; i++) {
//            if (heights[i] < heights[minInd])
//                minInd = i;
//        }
//        int areaLeft = largestArea(heights, lo, minInd - 1);
//        int areaRight = largestArea(heights, minInd + 1, hi);
//        int areaMin = heights[minInd] * (hi - lo + 1);
//        return Math.max(Math.max(areaLeft, areaRight), areaMin);
//    }

    // Stack - O(n)
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int ind = stack.peek();
                stack.pop();
                int left = stack.isEmpty()? 0: stack.peek()+1;
                maxArea = Math.max(maxArea, (i-left)*heights[ind]);
            }
        }
        int right = heights.length;
        while (!stack.isEmpty()) {
            int ind = stack.peek();
            stack.pop();
            int left = stack.isEmpty()? 0: stack.peek()+1;
            maxArea = Math.max(maxArea, (i-left)*heights[ind]);
        }
        return maxArea;
    }
}
