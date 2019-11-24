package Leetcode.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles_937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        String[] res = new String[logs.length];
        for (String log: logs) {
            int i = log.indexOf(" ");
            String strWithoutIdf = log.substring(i+1);
            char c = strWithoutIdf.charAt(0);
            if (c >= '0' && c <= '9') {
                digitLogs.add(log);
            } else {
                letterLogs.add(new String[]{log, strWithoutIdf});
            }
        }
        Collections.sort(letterLogs, (a, b) -> {
            if (a[1].compareTo(b[1]) == 0) {
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });

        for (int i = 0; i < letterLogs.size(); i++) {
            res[i] = letterLogs.get(i)[0];
        }
        for (int i = 0; i < digitLogs.size(); i++) {
            res[i + letterLogs.size()] = digitLogs.get(i);
        }
        return res;
    }
}
