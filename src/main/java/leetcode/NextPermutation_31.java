package leetcode;

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        for (int head=nums.length-1; head>=0; head--){
            for (int tail=nums.length-1; tail>head; tail--){
                if (nums[tail]>nums[head]){
                    System.out.println(head);
                    int temp = nums[tail];
                    nums[tail] = nums[head];
                    nums[head] = temp;
                    for (int i=head+1; i<nums.length-1; i++){
                        for (int j=i+1; j<nums.length; j++){
                            if (nums[j]<nums[i]){
                                int temp2 = nums[j];
                                nums[j] = nums[i];
                                nums[i] = temp2;
                            }
                        }
                    }
//                    for (int num: nums)
//                        System.out.println(num);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args){
        NextPermutation_31 obj = new NextPermutation_31();
        obj.nextPermutation(new int[]{4,2,0,2,3,2,0});
    }
}
