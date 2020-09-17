package Leetcode.DivideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses_241 {
    // Add memory to cache result
    private Map<String, List<Integer>> memory = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (memory.containsKey(input)) {
            return memory.get(input);
        }
        int num = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i+1));
                for (int num1: list1) {
                    for (int num2: list2) {
                        res.add(compute(num1, num2, c));
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(num);
        }
        return res;
    }

    public int compute(int num1, int num2, char c) {
        if (c == '+') {
            return num1 + num2;
        } else if (c == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}
