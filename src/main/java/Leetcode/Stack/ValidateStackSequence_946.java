package Leetcode.Stack;

import java.util.Stack;

public class ValidateStackSequence_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (popped.length != len) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushInd = 0, popInd = 0;
        while (pushInd < len) {
            if (stack.isEmpty() || stack.peek() != popped[popInd]) {
                stack.push(pushed[pushInd++]);
            } else {
                stack.pop();
                popInd ++;
            }
        }
        while (popInd < len) {
            if (stack.peek() != popped[popInd]) {
                return false;
            } else {
                stack.pop();
                popInd ++;
            }
        }
        return true;
    }
}
