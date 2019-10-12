package Leetcode.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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


    // Queue + HashSet: only keep the most recent messages within 10s
    private Queue<Log> messageQueue;
    private HashSet<String> recentMessage;
    /** Initialize your data structure here. */
    public LoggerRateLimiter_359() {
        messageQueue = new LinkedList<>();
        recentMessage = new HashSet<>();
    }

    class Log {
        int timestamp;
        String message;
        public Log(int t, String m){
            timestamp = t;
            message = m;
        }
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!messageQueue.isEmpty() && timestamp - messageQueue.peek().timestamp >= 10) {
            Log log = messageQueue.poll();
            recentMessage.remove(log.message);
        }
        if (!recentMessage.contains(message)){
            recentMessage.add(message);
            messageQueue.offer(new Log(timestamp, message));
            return true;
        }
        return false;
    }
}
