package Leetcode.Google;

public class LicenseKeyFormatting_482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer res = new StringBuffer();
        int cnt = 0;
        char[] arr = S.toUpperCase().toCharArray();
        for (int i = arr.length-1; i >= 0; i--){
            char c = arr[i];
            if (c != '-'){
                if (cnt > 0 && cnt % K == 0){
                    res.insert(0, '-');
                }
                res.insert(0, c);
                cnt++;
            }
        }
        return res.toString();
    }
}
