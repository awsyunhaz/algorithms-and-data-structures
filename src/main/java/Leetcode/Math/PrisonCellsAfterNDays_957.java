package Leetcode.Math;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonCellsAfterNDays_957 {
    // Simulation
    // a. The transformations form a cycle (2 ^ 8 = 256 possible cell configurations)
    // b. The original array that is passed in, is not a part of that cycle.
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> map = new HashMap<>();
        int day = 0;
        while (day < N && !map.containsKey(Arrays.toString(cells))) {
            map.put(Arrays.toString(cells), day);
            System.out.println(Arrays.toString(cells));
            cells = nextCells(cells);
            day ++;
        }
        if (day == N) {
            return cells;
        }
        int cycle = day - map.get(Arrays.toString(cells));
        for (int i = 0; i < (N-day) % cycle; i++) {
            cells = nextCells(cells);
        }
        return cells;
    }

    public int[] nextCells(int[] cells) {
        int[] newCells = new int[cells.length];
        for (int j = 1; j < cells.length-1; j++) {
            newCells[j] = (cells[j-1] ^ cells[j+1]) ^ 1;
        }
        return newCells;
    }
}
