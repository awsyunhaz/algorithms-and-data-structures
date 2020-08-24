package Leetcode.Stack;

import java.util.Stack;

public class BasicCalculator_224 {
    public int calculate(String s) {
        int i = 0, res = 0;
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                // number
                int num = (int) (c - '0');
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num*10 + (int) (s.charAt(i++) - '0');
                }
                if (ops.isEmpty()) {
                    // heading num
                    nums.push(num);
                } else {
                    // number after (
                    if (ops.peek() == '(') {
                        nums.push(num);
                    } else {
                        // number after +/-
                        int numTop = ops.pop() == '+'? nums.pop() + num: nums.pop() - num;
                        nums.push(numTop);
                    }
                }
            } else if (c == ')') {
                // pop '('
                ops.pop();
                // op before '(' if exists
                char op = ops.isEmpty()? '+': ops.pop();

                int num = nums.pop();
                // number before op if exists
                int numBefore = nums.isEmpty()? 0: nums.pop();
                nums.push(op == '+'? numBefore + num: numBefore - num);
            } else {
                // (,),+,-
                ops.add(c);
            }
        }
        return nums.pop();
    }
}
