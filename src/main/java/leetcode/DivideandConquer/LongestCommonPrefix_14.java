package leetcode.DivideandConquer;

public class LongestCommonPrefix_14 {
    // O(mn) 1ms
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length==0)
//            return "";
//        int max = 0;
//        for (int i = 0; i < strs[0].length(); i++){
//            char c = strs[0].charAt(i);
//            for (String str: strs){
//                if (str.length()==i || str.charAt(i) != c)
//                    return strs[0].substring(0, max);
//            }
//            max++;
//        }
//        return strs[0];
//    }

    // Divide and conquer
    // O(mlogn) 1ms
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        return findLongest(strs, 0, strs.length-1);
    }

    private String findLongest(String[] strs, int left, int right){
        if (left==right)
            return strs[left];
        int mid = (left+right)/2;
        String s1 = findLongest(strs, left, mid);
        String s2 = findLongest(strs, mid+1, right);
        return longestBetweenTwoStrings(s1, s2);
    }

    private String longestBetweenTwoStrings(String s1, String s2){
        int i = 0;
        while (i<s1.length() && i<s2.length() && s1.charAt(i)==s2.charAt(i)) i++;
        return s1.substring(0, i);
    }
}
