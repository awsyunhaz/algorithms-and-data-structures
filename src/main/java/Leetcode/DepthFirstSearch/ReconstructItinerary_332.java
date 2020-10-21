package Leetcode.DepthFirstSearch;

import java.util.*;

public class ReconstructItinerary_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> destMap = new HashMap<>();
        for (List<String> ticket: tickets) {
            destMap.computeIfAbsent(ticket.get(0), v -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK", destMap, res);
        return res;
    }

    public void visit(String airport, Map<String, PriorityQueue<String>> destMap, List<String> res) {
        while (destMap.containsKey(airport) && !destMap.get(airport).isEmpty()) {
            visit(destMap.get(airport).poll(), destMap, res);
        }
        res.add(0, airport);
    }
}
