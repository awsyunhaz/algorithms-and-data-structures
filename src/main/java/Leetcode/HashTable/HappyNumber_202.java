package Leetcode.HashTable;

import java.util.HashSet;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(true){
            int sumSquare = 0;
            while (n!=0) {
                sumSquare += (n%10)*(n%10);
                n /= 10;
            }
            if (sumSquare==1)
                return true;
            if (!seen.add(sumSquare))
                return false;
            n = sumSquare;
        }
    }
}
