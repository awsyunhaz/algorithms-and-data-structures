package Leetcode.Math;

public class IntegertoRoman_12 {
    public String intToRoman(int num) {
        String s = new String();
        while (num>0){
            if (num/1000>0) {
                s = s.concat("M"); num-=1000;
            }
            else if (num/500>0) {
                if (num/900>0){s = s.concat("CM"); num-=900;}
                else {s = s.concat("D"); num-=500;}
            }
            else if (num/100>0) {
                if (num/400>0){s = s.concat("CD"); num-=400;}
                else{s = s.concat("C"); num-=100;}
            }
            else if (num/50>0) {
                if (num/90>0){s = s.concat("XC"); num-=90;}
                else{s = s.concat("L"); num-=50;}
            }
            else if (num/10>0) {
                if (num/40>0){s = s.concat("XL"); num-=40;}
                else{s = s.concat("X"); num-=10;}
            }
            else if (num/5>0) {
                if (num/9>0){s = s.concat("IX"); num-=9;}
                else{s = s.concat("V"); num-=5;}
            }
            else if (num/4>0){s = s.concat("IV"); num-=4;}
            else {s = s.concat("I"); num-=1;}

        }
        return s;
    }
}
