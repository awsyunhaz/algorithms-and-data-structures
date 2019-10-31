package Leetcode.HashMap;

import java.util.*;

public class LoggerRateLimiter_359 {

    // HashMap - store all messages
//    private HashMap<String, Integer> rec;
//    /** Initialize your data structure here. */
//    public LoggerRateLimiter_359() {
//        rec = new HashMap<>();
//    }
//
//    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
//     If this method returns false, the message will not be printed.
//     The timestamp is in seconds granularity. */
//    public boolean shouldPrintMessage(int timestamp, String message) {
//        if (!rec.containsKey(message) || timestamp - rec.get(message) >= 10){
//            rec.put(message, timestamp);
//            return true;
//        }
//        return false;
//    }


    // Queue + HashMap: only keep the most recent messages within 10s
    HashMap<String, Integer> map;
    Queue<String> logs;

    /** Initialize your data structure here. */
    public LoggerRateLimiter_359() {
        map = new HashMap<>();
        logs = new ArrayDeque<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (logs.size() > 0 && timestamp - map.get(logs.peek()) >= 10) {
            map.remove(logs.poll());
        }
        if (map.containsKey(message)){
            return false;
        } else {
            map.put(message, timestamp);
            logs.offer(message);
            return true;
        }
    }
}
