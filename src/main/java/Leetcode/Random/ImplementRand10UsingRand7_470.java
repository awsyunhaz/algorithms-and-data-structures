package Leetcode.Random;

public class ImplementRand10UsingRand7_470 {
    // Rejection Sampling - 4ms
    public int rand10() {
        while(true){
            int num = (rand7()-1)*7+rand7();
            if (num<=40)
                return num%10+1;
        }
    }
}
