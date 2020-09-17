package Leetcode.Design;

import java.util.ArrayList;

public class Flatten2DVector_251 {

    // convert to arraylist
//    private ArrayList<Integer> list;
//    private int ind;
//
//    public Vector2D(int[][] v) {
//        list = new ArrayList<>();
//        for (int i = 0; i < v.length; i++) {
//            for (int j = 0; j < v[i].length; j++) {
//                list.add(v[i][j]);
//            }
//        }
//        ind = 0;
//    }
//
//    public int next() {
//        return list.get(ind++);
//    }
//
//    public boolean hasNext() {
//        return ind < list.size();
//    }

    private int[][] v;
    private int row, col;

    public Flatten2DVector_251(int[][] v) {
        this.v = v;
        row = 0;
        col = 0;
    }

    public int next() {
        hasNext();
        return v[row][col++];
    }

    public boolean hasNext() {
        while (row < v.length && col == v[row].length) {
            row ++;
            col = 0;
        }
        if (row == v.length) {
            return false;
        }
        return true;
    }
}
