package Leetcode.Stack;

import java.util.Stack;

public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] ++;
                } else {
                    heights[j] = 0;
                }

                while (!stack.isEmpty() && heights[stack.peek()] > heights[j]) {
                    int h = heights[stack.pop()];
                    int w = j - (stack.isEmpty()? 0: stack.peek()+1);
                    maxArea = Math.max(maxArea, h*w);
                }
                stack.push(j);
            }

            while (!stack.isEmpty()) {
                int h = heights[stack.pop()];
                int w = n - (stack.isEmpty()? 0: stack.peek()+1);
                maxArea = Math.max(maxArea, h*w);
            }
        }
        return maxArea;
    }
}
