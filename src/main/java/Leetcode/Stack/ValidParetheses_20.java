package Leetcode.Stack;

import java.util.Stack;

public class ValidParetheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c=='(' || c=='[' || c=='{')
                stack.push(c);
            else{
                if (stack.isEmpty())
                    return false;
                char par = stack.pop();
                switch (c){
                    case ')':
                        if (par!='(')
                            return false;
                        break;
                    case ']':
                        if (par!='[')
                            return false;
                        break;
                    case '}':
                        if (par!='{')
                            return false;
                        break;
                }
            }
        }
        return stack.isEmpty()? true: false;
    }
}
