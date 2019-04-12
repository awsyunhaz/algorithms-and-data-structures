package Leetcode.BinarySearch;

public class Sqrt_69 {
    public int mySqrt(int x) {
        if (x==0)
            return 0;
        return search(1, x, x);
    }

    private int search(int lo, int hi, int x){
        int mid = (lo + hi)/2;
        if (mid <= x/mid && mid+1 > x/(mid+1))
            return mid;
        if (mid < x/mid)
            return search(mid+1, hi, x);
        else
            return search(lo, mid-1, x);
    }
}
