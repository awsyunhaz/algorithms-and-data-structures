package leetcode.Tree;

import java.util.*;

public class TopKFrequentElements_347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		// BucketSort - 10ms
		List<Integer>[] bucket = new ArrayList[nums.length+1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num: nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if (bucket[entry.getValue()]==null)
				bucket[entry.getValue()] = new ArrayList<>();
			bucket[entry.getValue()].add(entry.getKey());
		}
		List<Integer> res = new ArrayList<>();
		for (int i = nums.length; i > 0 && k > 0; i--){
			if (bucket[i]!=null){
				res.addAll(bucket[i]);
				k-=bucket[i].size();
			}
		}
		return res;

		// Hashmap, sort by value - 14ms
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int num: nums)
//			map.put(num, map.getOrDefault(num, 0) + 1);
//		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
//			public int compare(Map.Entry<Integer, Integer> entry1,
//							   Map.Entry<Integer, Integer> entry2){
//				return entry2.getValue().compareTo(entry1.getValue());
//			}
//		});
//		list = list.subList(0, k);
//		List<Integer> res = new ArrayList<>();
//		for (Map.Entry<Integer, Integer> entry: list){
//			res.add(entry.getKey());
//		}
//		return res;

		// Heap - O(nlogn) 42ms
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int num: nums)
//			map.put(num, map.getOrDefault(num, 0) + 1);
//		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
//				(n1, n2) -> (map.get(n2) - map.get(n1)));
//		// O(nlogn)
//		for (Map.Entry<Integer, Integer> entry: map.entrySet()){
//			maxHeap.add(entry.getKey());
//		}
//		List<Integer> res = new ArrayList<>();
//		// O(klogn)
//		for (int i = 0; i < k; i++)
//			res.add(maxHeap.poll());
//		return res;

		// Treemap - 12ms
//		HashMap<Integer, Integer> hashmap = new HashMap<>();
//		TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
//		for (int num: nums)
//			hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
//		for (int num: hashmap.keySet()){
//			int value = hashmap.get(num);
//			if (!treemap.containsKey(value))
//				treemap.put(value, new ArrayList<>());
//			treemap.get(value).add(num);
//		}
//		List<Integer> res = new ArrayList<>();
//		while (k>0){
//			List<Integer> entry = treemap.pollLastEntry().getValue();
//			res.addAll(entry);
//			k -= entry.size();
//		}
//		return res;
	}
}
