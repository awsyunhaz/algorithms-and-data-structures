package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Sort + 2 pointer - O(N^2)
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++){
            if (i==0 || (i>0 && nums[i-1]!=nums[i])){
                int low=i+1, high=nums.length-1;
                while (low<high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
//                        条件语句如果颠倒顺序会出现越界错误
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++; high--;
                    } else if (sum < 0)
                        low++;
                    else
                        high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        ThreeSum_15 obj = new ThreeSum_15();
        System.out.println(obj.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
