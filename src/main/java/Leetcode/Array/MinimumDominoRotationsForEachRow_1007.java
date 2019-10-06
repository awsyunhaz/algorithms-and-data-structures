package Leetcode.Array;

public class MinimumDominoRotationsForEachRow_1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int[] val = new int[]{A[0], B[0]};
        int swapA = minSwap(A, B), swapB = minSwap(B, A);
        if (!(swapA == -1 ^ swapB == -1))
            return Math.min(swapA, swapB);
        else if (swapA == -1)
            return swapB;
        else
            return swapA;
    }

    public int minSwap(int[] A, int[] B){
        int count = 0, same = 0;
        for (int i = 1; i < A.length; i++){
            if (A[i] == A[0]){
                if (A[i] == B[i])
                    same ++;
            }
            else if (B[i] == A[0])
                count ++;
            else
                return -1;
        }
        return Math.min(count, A.length-count-same);
    }
}
