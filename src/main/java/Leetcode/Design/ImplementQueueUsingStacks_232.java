package Leetcode.Design;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {
    class MyQueue {
        private Stack<Integer> stack;
        private Stack<Integer> assistStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            assistStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!stack.isEmpty()){
                assistStack.push(stack.pop());
            }
            int res = assistStack.pop();
            while (!assistStack.isEmpty()){
                stack.push(assistStack.pop());
            }
            return res;
        }

        /** Get the front element. */
        public int peek() {
            while (!stack.isEmpty()){
                assistStack.push(stack.pop());
            }
            int res = assistStack.peek();
            while (!assistStack.isEmpty()){
                stack.push(assistStack.pop());
            }
            return res;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
