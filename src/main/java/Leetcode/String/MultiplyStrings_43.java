package Leetcode.String;

public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1+len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int pos = i + j + 1;
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res[pos] + prod;
                res[pos] = sum % 10;
                res[pos - 1] += sum / 10;
            }
        }
        // skip leading zero
        int ind = 0;
        while (ind < res.length && res[ind] == 0) {
            ind ++;
        }
        StringBuilder sb = new StringBuilder();
        for (; ind < res.length; ind++) {
            sb.append(res[ind]);
        }
        return sb.toString();
    }
}
