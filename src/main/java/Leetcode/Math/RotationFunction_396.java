package Leetcode.Math;

public class RotationFunction_396 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int maxRotateFunction(int[] A) {
        int sum = 0, f = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            f += A[i] * i;
        }
        int max = f;
        for (int i = 1; i < len; i++) {
            f = f + sum - A.length*A[len-i];
            max = Math.max(max, f);
        }
        return max;
    }
}
