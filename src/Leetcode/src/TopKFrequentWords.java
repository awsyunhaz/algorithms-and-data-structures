
import java.util.*;

public class TopKFrequentWords {
    
	public List<String> topKFrequent(String[] words, int k) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (String word:words){
			map.put(word,map.getOrDefault(word, 0)+1);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
		Comparator comparatorSort = new comparator(); 
		Collections.sort(list, comparatorSort);
		
		list = list.subList(0, k);
		List<String> output = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry:list){
			output.add(entry.getKey());
		}
		
		return output;
    }
	
	private class comparator implements Comparator<Map.Entry<String, Integer>>{
		public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2){
			if (m1.getValue().compareTo(m2.getValue())==0)
				return m1.getKey().compareTo(m2.getKey());
			else
				return m2.getValue().compareTo(m1.getValue());
		}
	}
}
