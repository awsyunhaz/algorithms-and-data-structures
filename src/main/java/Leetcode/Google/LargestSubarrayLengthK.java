package Leetcode.Google;

import java.util.Arrays;

public class LargestSubarrayLengthK {
    public int[] subarray(int[] A, int K){
        int ind = 0;
        for (int i = 0; i < A.length - K + 1; i++){
            if (A[i] < A[ind]){
                ind = i;
            }
        }
        return Arrays.copyOfRange(A, ind, ind + K);
    }

    public static void main(String[] args){
        LargestSubarrayLengthK obj = new LargestSubarrayLengthK();
        int[] res = obj.subarray(new int[]{1, 4, 3, 2, 5}, 4);
        for (int num: res){
            System.out.println(num);
        }
    }
}
