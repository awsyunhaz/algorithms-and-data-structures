package Leetcode.Stack;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {

    // Brute force - O(n^2)
//    public int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int minH = heights[i];
//            for (int j = i; j < heights.length; j++) {
//                minH = Math.min(minH, heights[j]);
//                maxArea = Math.max(maxArea, (j-i+1)*minH);
//            }
//        }
//        return maxArea;
//    }

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
        Stack<Integer> stack = new Stack<>();
        int i = 0, maxArea = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int bar = stack.pop();
                // Consider index as the left edge of rectangle
                int left = stack.isEmpty()? 0: stack.peek()+1;
                maxArea = Math.max(maxArea, heights[bar]*(i-left));
            }
        }
        while (!stack.isEmpty()) {
            int bar = stack.pop();
            int left = stack.isEmpty()? 0: stack.peek()+1;
            maxArea = Math.max(maxArea, heights[bar]*(i-left));
        }
        return maxArea;
    }
}
