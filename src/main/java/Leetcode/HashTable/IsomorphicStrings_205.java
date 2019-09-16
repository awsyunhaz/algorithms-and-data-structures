package Leetcode.HashTable;

public class IsomorphicStrings_205 {
    // Hashmap - 10ms
//    public boolean isIsomorphic(String s, String t) {
//        HashMap<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++){
//            if (map.containsKey(s.charAt(i))) {
//                if (map.get(s.charAt(i)) != t.charAt(i))
//                    return false;
//            }
//            else{
//                if (map.containsValue(t.charAt(i)))
//                    return false;
//                map.put(s.charAt(i), t.charAt(i));
//            }
//        }
//        return true;

    // Two array - 3ms
//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()){
//            return false;
//        }
//        char[] sarr = new char[128];
//        char[] tarr = new char[128];
//        for (int i = 0; i < s.length(); i++){
//            char si = s.charAt(i);
//            char ti = t.charAt(i);
//            if (sarr[si] == 0 && tarr[ti] == 0){
//                sarr[si] = ti;
//                tarr[ti] = si;
//            }
//            else{
//                if (sarr[si] != ti || tarr[ti] != si){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // Two array - smarter
    public boolean isIsomorphic(String s, String t) {
        int[] sarr = new int[128], tarr = new int[128];
        for (int i = 0; i < s.length(); i++){
            char sind = s.charAt(i), tind = t.charAt(i);
            if (sarr[sind] != tarr[tind])
                return false;
            sarr[sind] = tarr[tind] = i+1;
        }
        return true;
    }
}
