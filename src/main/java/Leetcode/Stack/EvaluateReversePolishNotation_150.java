package Leetcode.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {
            if (str.equals("+")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(a+b);
            } else if (str.equals("-")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b-a);
            } else if (str.equals("*")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(a*b);
            } else if (str.equals("/")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
