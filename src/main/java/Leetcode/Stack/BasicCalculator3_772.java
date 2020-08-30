package Leetcode.Stack;

import java.util.Stack;

public class BasicCalculator3_772 {
    public int calculate(String s) {
        // level one operators: +,-
        int num1 = 0, sign = 1;
        // level two operators: *,/
        int num2 = 1, power = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10 + s.charAt(i+1) - '0';
                    i ++;
                }
                num2 *= Math.pow(num, power);
            } else if (c == '(') {
                // push the state to stack
                stack.push(num1); stack.push(sign);
                stack.push(num2); stack.push(power);
                num1 = 0; sign = 1;
                num2 = 1; power = 1;
            } else if (c == ')') {
                int num = num1 + sign*num2;
                // retrieve the previous state from stack
                power = stack.pop(); num2 = stack.pop();
                sign = stack.pop(); num1 = stack.pop();
                num2 *= Math.pow(num, power);
            } else if (c == '+' || c == '-') {
                num1 += sign*num2;
                num2 = 1; power = 1;
                sign = c == '+'? 1: -1;
            } else if (c == '*') {
                power = 1;
            } else if (c == '/') {
                power = -1;
            }
        }
        return num1 + sign*num2;
    }
}
