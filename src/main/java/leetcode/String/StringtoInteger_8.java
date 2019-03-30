package leetcode.String;

public class StringtoInteger_8 {
    public int myAtoi(String str) {
        if (str.length()==0)
            return 0;
        long res = 0; int i = 0, sign = 1;
        while (i<str.length() && str.charAt(i) == ' ') i++;
        if (i<str.length()){
            if (str.charAt(i) == '+') i++;
            else if (str.charAt(i) == '-') {sign = -1; i++;}
        }
        while (i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
            res = res*10 + Character.getNumericValue(str.charAt(i));
            if (res > Integer.MAX_VALUE){
                if (sign==1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            i++;
        }
        return sign*(int)res;
    }
}
