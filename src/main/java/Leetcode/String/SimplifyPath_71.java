package Leetcode.String;

import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        String[] lis = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s: lis) {
            if (s.length() == 0) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".")) {
                stack.push(s);
            }
        }
        StringBuffer sb = new StringBuffer();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }
        return sb.toString();
    }
}
