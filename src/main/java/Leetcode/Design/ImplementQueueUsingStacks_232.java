package Leetcode.Design;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {
    class MyQueue {
        private Stack<Integer> stack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            Stack<Integer> tmpStack = new Stack<>();
            while (!stack.isEmpty()) {
                tmpStack.push(stack.pop());
            }
            int res = tmpStack.pop();
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
            return res;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            Stack<Integer> tmpStack = new Stack<>();
            while (!stack.isEmpty()) {
                tmpStack.push(stack.pop());
            }
            int res = tmpStack.peek();
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
            return res;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
