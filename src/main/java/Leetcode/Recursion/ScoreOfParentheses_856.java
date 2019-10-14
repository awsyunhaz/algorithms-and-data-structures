package Leetcode.Recursion;

import java.util.Stack;

public class ScoreOfParentheses_856 {
//    public int scoreOfParentheses(String S) {
//        Stack<Integer> stack = new Stack<>();
//        int curr = 0;
//        for (char c: S.toCharArray()) {
//            if (c == '(') {
//                stack.push(curr);
//                curr = 0;
//            } else {
//                if (curr == 0) {
//                    curr = stack.pop() + 1;
//                } else {
//                    curr = stack.pop() + 2*curr;
//                }
//            }
//        }
//        return curr;
//    }

    // Recursion
    public int scoreOfParentheses(String S) {
        return compute(S, 0, S.length() - 1);
    }

    public int compute(String s, int left, int right) {
        if (left + 1 == right) {
            return 1;
        }
        int count = 0;
        for (int i = left; i < right; i ++){
            if (s.charAt(i) == '(')
                count ++;
            else
                count --;
            if (count == 0) {
                return compute(s, left, i) + compute(s, i + 1, right);
            }
        }
        return 2 * compute(s, left + 1, right - 1);
    }
}
