package Leetcode.String;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        s = s.toLowerCase();
        while (lo < hi){
            while (lo<hi && !(s.charAt(lo)>='a' && s.charAt(lo)<='z' || s.charAt(lo)>='0' && s.charAt(lo)<='9')) lo++;
            while (lo<hi && !(s.charAt(hi)>='a' && s.charAt(hi)<='z' || s.charAt(hi)>='0' && s.charAt(hi)<='9')) hi--;
            if (lo<hi && s.charAt(lo)!=s.charAt(hi))
                return false;
            lo++; hi--;
        }
        return true;
    }
}
