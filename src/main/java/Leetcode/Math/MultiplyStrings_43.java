package Leetcode.Math;

public class MultiplyStrings_43 {
    // 5ms
    public String multiply(String num1, String num2) {
        String str = new String();
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1+len2];
        for (int i=0; i<len1; i++){
            for (int j=0; j<len2; j++){
                res[i+j] += (int)(num1.charAt(len1-i-1)-'0') *
                        (int)(num2.charAt(len2-j-1)-'0');
                res[i+j+1] += res[i+j]/10;
                res[i+j] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        // int ind = len1+len2-1;
        // while (ind>=0 && res[ind]==0) ind--;
        // for (int i=ind; i>=0; i--)
        //     sb.append(Integer.toString(res[i]));
        for (int i=res.length-1; i>=0; i--){
            if (sb.length()!=0 || res[i]!=0)
                sb.append(Integer.toString(res[i]));
        }
        if (sb.length()==0)
            return "0";
        return sb.toString();
    }
}
