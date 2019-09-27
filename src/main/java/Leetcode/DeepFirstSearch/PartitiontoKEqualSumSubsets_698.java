package Leetcode.DeepFirstSearch;

public class PartitiontoKEqualSumSubsets_698 {

    // DFS
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % k != 0)
            return false;
        return search(nums, visited, 0, k, 0, sum/k);
    }

    public boolean search(int[] nums, boolean[] visited, int start, int k, int sum, int target){
        if (k == 1) return true;
        for (int i = start; i < nums.length; i++){
            if (visited[i] || sum + nums[i] > target) continue;
            visited[i] = true;
            // sum+nums[i] == target
            if (sum + nums[i] == target && search(nums, visited, 0, k-1, 0, target)){
                return true;
                // sum+nums[i] < target
            } else if (search(nums, visited, i+1, k, sum+nums[i], target))
                return true;
            visited[i] = false;
        }
        return false;
    }
}
