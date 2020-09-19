package Leetcode.Graph.UnionFind;

import java.util.HashMap;
import java.util.List;

public class EvaluateDivision_399 {
    // DFS - 1ms
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        HashMap<String, List<String>> pairs = new HashMap<>();
//        HashMap<String, List<Double>> weights = new HashMap<>();
//        double[] res = new double[queries.size()];
//        for (int i = 0; i < equations.size(); i++) {
//            List<String> e = equations.get(i);
//            String e0 = e.get(0), e1 = e.get(1);
//            if (!pairs.containsKey(e0)) {
//                pairs.put(e0, new ArrayList<>());
//                weights.put(e0, new ArrayList<>());
//            }
//            pairs.get(e0).add(e1);
//            weights.get(e0).add(values[i]);
//            if (!pairs.containsKey(e1)) {
//                pairs.put(e1, new ArrayList<>());
//                weights.put(e1, new ArrayList<>());
//            }
//            pairs.get(e1).add(e0);
//            weights.get(e1).add(1/values[i]);
//        }
//
//        for (int i = 0; i < queries.size(); i++) {
//            List<String> e = queries.get(i);
//            String e0 = e.get(0), e1 = e.get(1);
//            if (!pairs.containsKey(e0) || !pairs.containsKey(e1)) {
//                res[i] = -1.0;
//            } else {
//                HashSet<String> visited = new HashSet<>();
//                res[i] = search(pairs, weights, visited, e0, e1, 1);
//            }
//        }
//
//        return res;
//    }
//
//    public double search(HashMap<String, List<String>> pairs, HashMap<String, List<Double>> weights, HashSet<String> visited, String str, String end, double curr) {
//        if (str.equals(end)) {
//            return curr;
//        }
//        if (visited.contains(str)) {
//            return -1.0;
//        }
//        visited.add(str);
//        for (int i = 0; i < pairs.get(str).size(); i++) {
//            String next = pairs.get(str).get(i);
//            double w = weights.get(str).get(i);
//            double product = search(pairs, weights, visited, next, end, curr*w);
//            if (product != -1.0) {
//                return product;
//            }
//        }
//        visited.remove(str);
//        return -1.0;
//    }

    // Union find - 0ms
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, String> rootMap = new HashMap<>();
        HashMap<String, Double> distMap = new HashMap<>();
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            String r1 = find(rootMap, distMap, e.get(0));
            String r2 = find(rootMap, distMap, e.get(1));
            rootMap.put(r2, r1);
            distMap.put(r2, distMap.get(e.get(0)) / distMap.get(e.get(1)) * values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> e = queries.get(i);
            if (!rootMap.containsKey(e.get(0)) || !rootMap.containsKey(e.get(1))) {
                res[i] = -1.0;
            } else {
                String r1 = find(rootMap, distMap, e.get(0));
                String r2 = find(rootMap, distMap, e.get(1));
                if (r1 != r2) {
                    res[i] = -1.0;
                } else {
                    res[i] = distMap.get(e.get(1)) / distMap.get(e.get(0));
                }
            }
        }
        return res;
    }

    public String find(HashMap<String, String> rootMap, HashMap<String, Double> distMap, String str) {
        double dist = 1.0;
        String root = str;
        while (rootMap.containsKey(root) && rootMap.get(root) != root) {
            dist *= distMap.get(root);
            root = rootMap.get(root);
        }
        rootMap.put(str, root);
        distMap.put(str, dist);
        return root;
    }
}
