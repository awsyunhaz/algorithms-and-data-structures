package Leetcode.DepthFirstSearch;

import java.util.HashSet;
import java.util.List;

public class KeysAndRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        return search(rooms, 0, visited);
    }

    public boolean search(List<List<Integer>> rooms, int room, HashSet<Integer> visited) {
        visited.add(room);
        if (visited.size() == rooms.size())
            return true;
        for (int key: rooms.get(room)) {
            if (!visited.contains(key) && search(rooms, key, visited))
                return true;
        }
        return false;
    }
}
