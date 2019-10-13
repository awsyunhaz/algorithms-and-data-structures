package Leetcode.TwoPointers;

//2 pointer - O(N)
public class ContainerWithMostWater_11 {
    private int area(int[] height, int left, int right){
        return Math.min(height[left], height[right])*(right-left);
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = area(height, left, right);
        while(left<right) {
            if (height[left] <= height[right])
                left++;
            else
                right--;
            max = Math.max(max, area(height, left, right));
        }
        return max;
    }

    public static void main(String[] args){
        ContainerWithMostWater_11 obj = new ContainerWithMostWater_11();
        System.out.println(obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
