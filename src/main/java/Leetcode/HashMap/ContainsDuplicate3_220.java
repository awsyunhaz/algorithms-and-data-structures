package Leetcode.HashMap;

import java.util.HashMap;

public class ContainsDuplicate3_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // TreeSet - O(nlogn) 15ms
//        TreeSet<Long> tree = new TreeSet<>();
//        for (int i = 0; i < nums.length; i++){
//            Long num = (long)nums[i];
//            Long floor = tree.floor(num + t);
//            if (floor!=null && floor>=num-t){
//                return true;
//            }
//            tree.add(num);
//            if (i>=k)
//                tree.remove((long)nums[i-k]);
//        }
//        return false;

        // Bucket - O(n) 9ms
        if (k<0 || t<0)
            return false;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long batch = num / ((long)t+1);
            if (map.containsKey(batch) ||
                    map.containsKey(batch-1) && num-map.get(batch-1)<=t ||
                    map.containsKey(batch+1) && map.get(batch+1)-num<=t)
                return true;
            map.put(batch, num);
            if (map.size()>k)
                map.remove(((long)nums[i-k] - Integer.MIN_VALUE) / (t+1));
        }
        return false;
    }

    public static void main(String[] args){
        ContainsDuplicate3_220 obj = new ContainsDuplicate3_220();
        obj.containsNearbyAlmostDuplicate(new int[]{2,1},1,1);
    }
}
