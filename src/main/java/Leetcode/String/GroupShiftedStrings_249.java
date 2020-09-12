package Leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_249 {
    public List<List<String>> groupStrings(String[] strings) {
        String[] groups = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            if (str.length() == 1) {
                groups[i] = "1";
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < str.length(); j++) {
                int diff = (str.charAt(j) - str.charAt(j-1) + 26) % 26;
                sb.append(diff);
            }
            groups[i] = sb.toString();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(groups[i])) {
                map.put(groups[i], new ArrayList<>());
            }
            map.get(groups[i]).add(strings[i]);
        }
        return new ArrayList<>(map.values());
    }
}
