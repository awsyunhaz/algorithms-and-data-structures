package Leetcode.Stack;

import java.util.Stack;

public class ValidateStackSequence_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popInd = 0;
        for (int num: pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[popInd]) {
                stack.pop();
                popInd ++;
            }
        }
        return stack.isEmpty();
    }
}
