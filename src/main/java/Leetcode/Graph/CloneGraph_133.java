package Leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            HashMap<Node, Node> nodeMap = new HashMap<>();
            Node newNode = build(node, nodeMap);
            return newNode;
        }

        public Node build(Node node, HashMap<Node, Node> nodeMap) {
            if (node == null)
                return null;
            Node newNode = new Node(node.val, new ArrayList<>());
            nodeMap.put(node, newNode);
            for (Node n : node.neighbors) {
                if (nodeMap.containsKey(n)) {
                    newNode.neighbors.add(nodeMap.get(n));
                } else {
                    Node neighbor = build(n, nodeMap);
                    newNode.neighbors.add(neighbor);
                }
            }
            return newNode;
        }
    }
}
