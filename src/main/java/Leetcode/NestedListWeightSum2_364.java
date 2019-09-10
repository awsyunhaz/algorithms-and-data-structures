package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum2_364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sumPrevious = 0, res = 0;
        while (!nestedList.isEmpty()){
            List<NestedInteger> lis = new ArrayList<>();
            for (NestedInteger ni: nestedList){
                if (ni.isInteger()){
                    sumPrevious += ni.getInteger();
                }
                else {
                    lis.addAll(ni.getList());
                }
            }
            res += sumPrevious;
            nestedList = lis;
        }
        return res;
    }
}
