package Leetcode.Stack;

public class BasicCalculator2_227 {
    public int calculate(String s) {
        int res = 0, sign = 1;
        int tmpRes = 1, power = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                int num = (int) (c - '0');
                while (i + 1  < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10 + (int) (s.charAt(i+1) - '0');
                    i ++;
                }
                tmpRes *= Math.pow(num, power);
            } else if (c == '+' || c == '-') {
                res += sign * tmpRes;
                tmpRes = 1;
                power = 1;
                sign = c == '+'? 1: -1;
            } else {
                power = c == '*'? 1: -1;
            }
        }
        return res + sign * tmpRes;
    }
}
