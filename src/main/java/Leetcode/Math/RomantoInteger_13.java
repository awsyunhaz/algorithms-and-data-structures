package Leetcode.Math;

public class RomantoInteger_13 {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c=='I') sum+=1;
            else if (c=='V'){if (i>0 && s.charAt(i-1)=='I') sum+=3; else sum+=5;}
            else if (c=='X'){if (i>0 && s.charAt(i-1)=='I') sum+=8; else sum+=10;}
            else if (c=='L'){if (i>0 && s.charAt(i-1)=='X') sum+=30; else sum+=50;}
            else if (c=='C'){if (i>0 && s.charAt(i-1)=='X') sum+=80; else sum+=100;}
            else if (c=='D'){if (i>0 && s.charAt(i-1)=='C') sum+=300; else sum+=500;}
            else if (c=='M'){if (i>0 && s.charAt(i-1)=='C') sum+=800; else sum+=1000;}
        }
        return sum;
    }
}
