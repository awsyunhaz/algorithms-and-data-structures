package leetcode;

//O(n)
//本解针对于next permutation为不同排列的情况。如：115的下一个为151
//第一次交换后lo后已经是倒序，直接reverse就可以
public class NextPermutation_31 {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
//        for (int head=nums.length-1; head>=0; head--){
//            for (int tail=nums.length-1; tail>head; tail--){
//                if (nums[tail]>nums[head]){
//                    System.out.println(head);
//                    int temp = nums[tail];
//                    nums[tail] = nums[head];
//                    nums[head] = temp;
//                    for (int i=head+1; i<nums.length-1; i++){
//                        for (int j=i+1; j<nums.length; j++){
//                            if (nums[j]<nums[i]){
//                                int temp2 = nums[j];
//                                nums[j] = nums[i];
//                                nums[i] = temp2;
//                            }
//                        }
//                    }
//                    return;
//                }
//            }
//        }
//        Arrays.sort(nums);
        int lo=nums.length-1, hi=nums.length-1;
        while (lo>0 && nums[lo-1]>=nums[lo]) lo--;
        lo--;
        if (lo>=0) {
            while (hi > 0 && nums[hi] <= nums[lo]) hi--;
            swap(nums, lo, hi);
        }
        int head=lo+1, tail=nums.length-1;
        while(head<tail){
            swap(nums, head, tail);
            head++; tail--;
        }
        for (int num: nums)
            System.out.print(num);
    }

    public static void main(String[] args){
        NextPermutation_31 obj = new NextPermutation_31();
        obj.nextPermutation(new int[]{4,2,0,2,3,2,0});
    }
}
