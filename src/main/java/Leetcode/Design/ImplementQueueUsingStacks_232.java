package Leetcode.Design;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {
//    class MyQueue {
//        private Stack<Integer> stack;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public MyQueue() {
//            stack = new Stack<>();
//        }
//
//        /**
//         * Push element x to the back of queue.
//         */
//        public void push(int x) {
//            stack.push(x);
//        }
//
//        /**
//         * Removes the element from in front of queue and returns that element.
//         */
//        public int pop() {
//            Stack<Integer> tmpStack = new Stack<>();
//            while (!stack.isEmpty()) {
//                tmpStack.push(stack.pop());
//            }
//            int res = tmpStack.pop();
//            while (!tmpStack.isEmpty()) {
//                stack.push(tmpStack.pop());
//            }
//            return res;
//        }
//
//        /**
//         * Get the front element.
//         */
//        public int peek() {
//            Stack<Integer> tmpStack = new Stack<>();
//            while (!stack.isEmpty()) {
//                tmpStack.push(stack.pop());
//            }
//            int res = tmpStack.peek();
//            while (!tmpStack.isEmpty()) {
//                stack.push(tmpStack.pop());
//            }
//            return res;
//        }
//
//        /**
//         * Returns whether the queue is empty.
//         */
//        public boolean empty() {
//            return stack.isEmpty();
//        }
//    }

    // O(1) pop, peek
    class MyQueue {
        private Stack<Integer> inputStack;
        private Stack<Integer> outputStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inputStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return outputStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
    }
}
