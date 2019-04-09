package leetcode.Random;

import java.util.ArrayList;

public class RandomPickIndex_398 {

    private int[] nums;
    public RandomPickIndex_398(int[] nums) {
        this.nums = nums;
    }

    //Random - 125ms
//    public int pick(int target) {
//        ArrayList<Integer> lis = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++){
//            if (arr[i]==target)
//                lis.add(i);
//        }
//        System.out.println(lis);
//        int ind = (int)(Math.random() * lis.size());
//        return lis.get(ind);
//    }

    //Reservoir sampling - 105ms
    public int pick(int target) {
        int size = 0, res = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]==target){
                double sample = Math.random();
                if (sample < 1.0/(size+1))
                    res = i;
                size++;
            }
        }
        return res;
    }
}
