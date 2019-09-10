package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum_339 {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0, weight = 1;
        while (!nestedList.isEmpty()){
            List<NestedInteger> lis = new ArrayList<>();
            for (NestedInteger ni: nestedList){
                if (ni.isInteger())
                    sum += ni.getInteger()*weight;
                else{
                    lis.addAll(ni.getList());
                }
            }
            weight++;
            nestedList = lis;
        }
        return sum;
    }
}
