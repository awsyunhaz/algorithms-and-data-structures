package Leetcode.BinarySearch;

public class ValidPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        if (num==0) return true;
        int lo = 1, hi = num;
        while (lo <= hi){
            int mid = (lo+hi)/2;
            if (mid == num/mid && num%mid == 0)
                return true;
            if (mid > num/mid){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return false;
    }
}
