package Leetcode.HashTable;

import java.util.HashMap;

public class FractiontoRecurringDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        // Integral
        if (numerator==0)
            return "0";
        StringBuffer str = new StringBuffer();
        if (numerator>0 ^ denominator > 0)
            str.append('-');
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        str.append(num/den);
        num = num % den;
        if (num == 0)
            return str.toString();

        // Decimal
        str.append('.');
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, str.length());
        while (num!=0){
            num*=10;
            str.append(num/den);
            num%=denominator;
            if (map.containsKey(num)){
                str.insert(map.get(num), "(");
                str.append(")");
                return str.toString();
            }
            map.put(num, str.length());
        }
        return str.toString();
    }
}
