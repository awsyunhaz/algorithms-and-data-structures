package Leetcode.Tree.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// HashMap + Heap - O(nlogk)
public class TopKFrequentWord_692 {
    public class Element {
        public String word;
        public int cnt;
        public Element(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCnt = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> {
            if (a.cnt == b.cnt) {
                return a.word.compareTo(b.word);
            } else {
                return b.cnt - a.cnt;
            }
        });

        for (String word: words) {
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }
        for (String word: wordCnt.keySet()) {
            pq.offer(new Element(word, wordCnt.get(word)));
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().word);
        }
        return res;
    }
}
