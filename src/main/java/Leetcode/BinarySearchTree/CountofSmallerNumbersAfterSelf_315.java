package Leetcode.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf_315 {
    // BST - O(nlgn)
    // Store number of nodes in the left subtree in the current node
//    public List<Integer> countSmaller(int[] nums) {
//        Integer[] counts = new Integer[nums.length];
//        Node root = null;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            root = insert(root, nums[i], 0, counts, i);
//        }
//        return Arrays.asList(counts);
//    }
//
//    public Node insert(Node root, int val, int cnt, Integer[] counts, int i) {
//        if (root == null) {
//            counts[i] = cnt;
//            return new Node(val, 0);
//        }
//        if (val == root.val) {
//            root.dup ++;
//            counts[i] = cnt + root.cnt;
//        } else if (val < root.val) {
//            root.cnt ++;
//            root.left = insert(root.left, val, cnt, counts, i);
//        } else {
//            root.right = insert(root.right, val, cnt+root.cnt+root.dup, counts, i);
//        }
//        return root;
//    }
//
//    class Node {
//        int cnt, dup, val;
//        Node left, right;
//        public Node (int v, int c){
//            cnt = c;
//            dup = 1;
//            val = v;
//        }
//    }


    // merge sort O(nlgn)
    // Count smaller numbers on the right during merge sort
    private Integer[] count;

    class Num {
        int val, index;
        public Num(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new Integer[n];
        Num[] arr = new Num[n];
        List<Integer> res = new ArrayList<>();
        if (n == 0)
            return res;

        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = new Num(nums[i], i);
        }
        partition(arr, 0, n-1);
        return Arrays.asList(count);
    }

    public void partition(Num[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = (lo + hi) >> 1;
        partition(arr, lo, mid);
        partition(arr, mid+1, hi);
        merge(arr, lo, mid, hi);
    }

    public void merge(Num[] arr, int lo, int mid, int hi) {
        Num[] newArr = new Num[arr.length];
        int i = lo, j = mid+1, ind = lo;
        int rightCnt = 0;
        while (i <= mid || j <= hi) {
            if (j > hi) {
                newArr[ind] = arr[i++];
                count[newArr[ind].index] += rightCnt;
            }
            else if (i > mid) {
                newArr[ind] = arr[j++];
            }
            else {
                if (arr[i].val <= arr[j].val) {
                    newArr[ind] = arr[i++];
                    count[newArr[ind].index] += rightCnt;
                } else {
                    newArr[ind] = arr[j++];
                    rightCnt += 1;
                }
            }
            ind ++;
        }
        for (i = lo; i <= hi; i ++) {
            arr[i] = newArr[i];
        }
    }
}
