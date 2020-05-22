package Leetcode.Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DinnerPlateStacks_1172 {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private int pushInd;
    private int popInd;

    public DinnerPlateStacks_1172(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
        pushInd = 0;
        popInd = 0;
    }

    public void push(int val) {
        if (pushInd == stacks.size()) {
            stacks.add(new Stack<>());
        }
        Stack<Integer> stackToPush = stacks.get(pushInd);
        stackToPush.push(val);
        popInd = Math.max(popInd, pushInd); // pushInd can not pass popInd
        updatePushInd(pushInd);
        // System.out.print(pushInd);
        // System.out.print(val);
        // System.out.println(popInd);
    }

    public int pop() {
        return popAtStack(popInd);
    }

    public int popAtStack(int index) {
        // all stacks are empty
        if (index < 0 || index >= stacks.size()) {
            return -1;
        }
        Stack<Integer> stackToPop = stacks.get(index);
        // stack index is empty
        if (stackToPop.isEmpty()) {
            return -1;
        }
        int res = stackToPop.pop();
        updatePopInd(popInd);
        pushInd = Math.min(pushInd, index);

        return res;
    }

    private void updatePushInd(int start) {
        for (int i = start; i < stacks.size(); i++) {
            Stack<Integer> stackToPush = stacks.get(i);
            if (stackToPush.size() < this.capacity) {
                pushInd = i;
                return;
            }
        }
        pushInd = stacks.size();
    }

    private void updatePopInd(int end) {
        for (int i = end; i >= 0; i--) {
            Stack<Integer> stackToPop = stacks.get(i);
            if (!stackToPop.isEmpty()) {
                popInd = i;
                return;
            }
        }
        popInd = 0;
    }
}
