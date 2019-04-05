package leetcode.Math;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int carry = 1, ind = digits.length-1;
        while (ind>=0 && carry==1){
            int sum = digits[ind] + carry;
            digits[ind] = sum % 10;
            carry = sum / 10;
            ind--;
        }
        if (carry==0)
            return digits;
        int[] res = new int[digits.length+1];
        res[0] = 1;
        for (int i=1; i<res.length; i++){
            res[i] = digits[i-1];
        }
        return res;
    }
}
