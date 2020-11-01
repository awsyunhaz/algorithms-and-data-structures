package Leetcode.Stack;

import java.util.Stack;

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        // a stack of stable asteroids
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() > -asteroid) {
                    asteroid = 0;
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                    asteroid = 0;
                } else {
                    stack.pop();
                }
            }
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
