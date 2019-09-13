package Leetcode.Greedy;

public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++){
            if (flowerbed[i] == 1)
                continue;
            int prev = i==0? 0: flowerbed[i-1];
            int next = i+1==flowerbed.length? 0: flowerbed[i+1];
            if (prev==0 && next==0){
                flowerbed[i] = 1;
                n--;
            }
        }
        return n==0;
    }
}
