package leetcode.String;

public class CountandSay_38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i=2; i<=n; i++){
            StringBuffer sb = new StringBuffer();
            while (s.length()>0){
                int ind = 1;
                while (ind<s.length() && s.charAt(ind)==s.charAt(0))
                    ind++;
                sb.append(Integer.toString(ind) + s.charAt(0));
                s = s.substring(ind);
            }
            s = sb.toString();
        }
        return s;
    }
}
