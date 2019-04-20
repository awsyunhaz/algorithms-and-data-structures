package Leetcode.Math;

public class AddBinary_67 {
    // 2ms
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int p1 = a.length()-1, p2 = b.length()-1, carry = 0;
        while (p1>=0 || p2>=0 || carry>0){
            int num1 = 0, num2 = 0;
            if (p1>=0) {num1 = (int) a.charAt(p1)-'0'; p1--;}
            if (p2>=0) {num2 = (int) b.charAt(p2)-'0'; p2--;}
            int sum = num1 + num2 + carry;
            sb.insert(0, sum%2);
            carry = sum/2;
        }
        return sb.toString();
    }
}
