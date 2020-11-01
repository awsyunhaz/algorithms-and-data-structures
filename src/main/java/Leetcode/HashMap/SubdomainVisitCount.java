package Leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCounter = new HashMap<>();
        for (String cpd: cpdomains) {
            String[] domains = cpd.split("\\s")[1].split("\\.");
            int visits = Integer.valueOf(cpd.split(" ")[0]);
            StringBuffer sb = new StringBuffer();
            for (int i = domains.length-1; i >= 0; i--) {
                sb.insert(0, domains[i]);
                domainCounter.put(sb.toString(), domainCounter.getOrDefault(sb.toString(), 0) + visits);
                sb.insert(0, '.');
            }
        }
        List<String> res = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry: domainCounter.entrySet()) {
            res.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        }
        return res;
    }
}
