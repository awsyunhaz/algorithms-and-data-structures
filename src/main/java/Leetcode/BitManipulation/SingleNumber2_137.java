package Leetcode.BitManipulation;

public class SingleNumber2_137 {
    public int singleNumber(int[] nums) {
        int once = 0, twice = 0;
        for (int num: nums) {
            // remove num in once if exist
            // add to once only if not exist in twice
            once = ~twice & (once ^ num);
            // remove num in twice if exist
            // add to twice only if not exist in once
            twice = ~once & (twice ^ num);
        }
        return once;
    }
}
