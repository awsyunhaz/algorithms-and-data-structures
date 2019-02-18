package leetcode.Array;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m + n - 1;
        while (k>=0 && i>=0 && j>=0){
            nums1[k--] = nums1[i] > nums2[j]? nums1[i--]: nums2[j--];
        }
        if (i<0){
            for (i = 0; i <= j; i++)
                nums1[i] = nums2[i];
        }
    }
}
