package com.interview.leetcode.amazon.easy;

import java.util.HashMap;

/*
https://leetcode.com/problems/logger-rate-limiter/

Design a logger system that receive stream of messages along with its timestamps,
each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp,
otherwise returns false.

It is possible that several messages arrive roughly at the same time.

1) If the key is new, create in map and return true.
2) If the key exists, if currentTimeStamp-previousTimeStamp < 10. Simply ignore. return false
3) If the key exists, if currentTimeStamp-previousTimeStamp >= 10.  add/update key again with new timeStamp.

Input  : [[],  [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output : [null, true,         true,       false,     false,        false,      true]
        1) true because foo is new entry.
        2) true because bar is new entry
        3) false because foo exists and currentTimeStamp-previousTimeStamp < 10
        4) false because bar exists and currentTimeStamp-previousTimeStamp < 10
        5) false because foo exists and currentTimeStamp-previousTimeStamp < 10
        6) true because foo exists and currentTimeStamp-previousTimeStamp == 10
 */
public class LoggerRateLimiter {
  private HashMap<String, Integer> loggerMapper = new HashMap<>();

  public boolean shouldPrintMessage(int currentTimestamp, String message) {
    if (!loggerMapper.containsKey(message)) {
      loggerMapper.put(message, currentTimestamp);
      return true;
    }

    // int prevTimestamp = loggerMapper.get(message);
    if (currentTimestamp - loggerMapper.get(message) < 10) return false;

    loggerMapper.put(message, currentTimestamp);
    return true;
  }
}
