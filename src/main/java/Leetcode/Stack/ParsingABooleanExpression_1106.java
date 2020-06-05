package Leetcode.Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ParsingABooleanExpression_1106 {
    public boolean parseBoolExpr (String expression){
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                Set<Character> buf = new HashSet<>();
                while (stack.peek() != '(') {
                    buf.add(stack.pop());
                }
                stack.pop();
                char op = stack.pop();
                if (op == '!') {
                    stack.push(buf.contains('t') ? 'f' : 't');
                } else if (op == '&') {
                    stack.push(buf.contains('f') ? 'f' : 't');
                } else if (op == '|') {
                    stack.push(buf.contains('t') ? 't' : 'f');
                }
            }
        }
        return stack.peek() == 't';
    }
}
