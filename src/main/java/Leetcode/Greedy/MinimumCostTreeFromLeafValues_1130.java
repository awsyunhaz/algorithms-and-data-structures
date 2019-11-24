package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.Stack;

public class MinimumCostTreeFromLeafValues_1130 {

    // Greedy - O(n^2)
    public int mctFromLeafValues(int[] arr) {
        ArrayList<Integer> lis = new ArrayList<>();
        int res = 0;
        for (int num: arr) {
            lis.add(num);
        }
        while (lis.size() > 1) {
            int min = Integer.MAX_VALUE;
            int ind = 0;
            for (int i = 1; i < lis.size(); i++) {
                int left = lis.get(i-1), right = lis.get(i);
                if (left * right < min) {
                    min = left * right;
                    ind = left < right? i-1: i;
                }

            }
            res += min;
            lis.remove(ind);
        }
        return res;
    }

    // Stack - O(n)
//    public int mctFromLeafValues(int[] arr) {
//        int res = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < arr.length; i++) {
//            while (!stack.isEmpty() && arr[i] > stack.peek()) {
//                int drop = stack.pop();
//                int prev = stack.isEmpty()? Integer.MAX_VALUE: stack.peek();
//                res += drop*Math.min(prev, arr[i]);
//            }
//            stack.push(arr[i]);
//        }
//        while (stack.size() > 1) {
//            res += stack.pop() * stack.peek();
//        }
//        return res;
//    }
}
