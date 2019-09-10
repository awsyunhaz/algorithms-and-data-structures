package Leetcode.Array;

public class ProductofArrayExceptItself_238 {
//    public int[] productExceptSelf(int[] nums) {
//        int product = 1, cntzero = 0, indzero = 0;
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++){
//            if (nums[i] == 0){
//                cntzero += 1;
//                indzero = i;
//            } else
//                product *= nums[i];
//        }
//        if (cntzero >= 2)
//            return res;
//        else if (cntzero == 1){
//            res[indzero] = product;
//            return res;
//        }
//        for (int i = 0; i < nums.length; i++){
//            res[i] = product / nums[i];
//        }
//        return res;
//    }

    // Two pass - O(N), constant extra space
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i ++){
            res[i] = res[i-1] * nums[i-1];
        }
        int rightProduct = 1;
        for (int i = nums.length-1; i >= 0; i--){
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return res;
    }
}
