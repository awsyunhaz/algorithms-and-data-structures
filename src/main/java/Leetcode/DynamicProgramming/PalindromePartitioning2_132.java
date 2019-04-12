package Leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning2_132 {
    public int minCut(String s) {
        List<String> list = new ArrayList<>();
        return search(s, list, 0, Integer.MAX_VALUE,0)-1;
    }

    private int search(String s, List<String> list,
                       int start, int minCut, int cut){
        if (cut > minCut)
            return minCut;
        if (start==s.length() && cut<minCut){
            minCut = cut;
//            System.out.println(list);
        }
        for (int i = start; i < s.length(); i++){
            if (isPalindrome(s.substring(start, i+1))) {
                list.add(s.substring(start, i + 1));
                minCut = search(s, list, i+1, minCut, cut+1);
                list.remove(list.size() - 1);
            }
        }
        return minCut;
    }

    private boolean isPalindrome(String s){
        int lo = 0, hi = s.length()-1;
        while (lo < hi){
            if (s.charAt(lo) != s.charAt(hi))
                return false;
            lo++; hi--;
        }
        return true;
    }

    public static void main(String[] args){
        PalindromePartitioning2_132 obj = new PalindromePartitioning2_132();
        System.out.println(obj.minCut("\"apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }
}
