package Leetcode.Google;

import java.util.Arrays;
import java.util.TreeSet;

public class StoresandHouses {

    // Sort + one pass - O(nlgn)
//    public int[] storesandHouses(int[] houses, int[] stores){
//        Arrays.sort(houses);
//        Arrays.sort(stores);
//        int[] res = new int[houses.length];
//        int ind = 0;
//        for (int i = 0; i < houses.length; i++){
//            while (ind < stores.length && stores[ind] < houses[i]){
//                ind ++;
//            }
//            if (ind == stores.length || houses[i] - stores[ind - 1] <= stores[ind] - houses[i])
//                res[i] = stores[ind - 1];
//            else
//                res[i] = stores[ind];
//        }
//        return res;
//    }

    // TreeMap - O(nlgn)
    public int[] storesandHouses(int[] houses, int[] stores){
        TreeSet<Integer> set = new TreeSet<>();
        int[] res = new int[houses.length];
        for (int store: stores){
            set.add(store);
        }
        for (int i = 0; i < houses.length; i++){
            Integer left = set.floor(houses[i]), right = set.ceiling(houses[i]);
            if (left == null) {
                res[i] = right;
            } else if (right == null) {
                res[i] = left;
            }
            else {
                res[i] = houses[i] - left <= right - houses[i]? left: right;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] houses = new int[]{5, 10, 17, 18, 20};
        int[] stores = new int[]{1, 5, 20, 11, 16};
        StoresandHouses obj = new StoresandHouses();
        int[] res = obj.storesandHouses(houses, stores);
        for (int num: res){
            System.out.println(num);
        }
    }
}
