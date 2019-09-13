package Leetcode.Design;

import java.util.Stack;

public class maxStack_716 {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public maxStack_716() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.empty())
            maxStack.push(x);
        else
            maxStack.push(Math.max(maxStack.peek(), x));
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> tmpStack = new Stack<>();
        while (stack.peek() != maxStack.peek()){
            tmpStack.push(pop());
        }
        int ret = pop();
        while (!tmpStack.empty()){
            push(tmpStack.pop());
        }
        return ret;
    }
}
