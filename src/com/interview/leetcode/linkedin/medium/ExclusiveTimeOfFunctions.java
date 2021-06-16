package com.interview.leetcode.linkedin.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
https://leetcode.com/problems/exclusive-time-of-functions/description/

1) Given a input sequenced as fuctionId:start||end:timestamp.
2) Return the execution time of each functionId.


Input: n = 2, logs = ["f0:start:0","f1:start:2","f1:end:5","f0:end:6"]
Output: [3,4]

Explanation:
Function f0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
Function f1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
Function f0 resumes execution at the beginning of time 6 and executes for 1 unit of time.

So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.


1) currentfunction started end depends on nextEnd
2) We don't know when currentStart ends.
3) 

1) But a same id can start and end and it can start again. See below example
["0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3"] n=3
Ans: [1,1,2]

["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"] n=1
Ans: [8]

2) Thread started should be completed LIFO order. Ex: T1 starts, T2 starts. T2 should complete and T1 cannot complete b4 T2
So Below case is not possible.
["0:start:0","1:start:2","0:end:5","1:end:6"] n=2
3) So based on case3 T1 = T1+T2. So when calculating T2. Update T1(with negative T2) with T2 value.

=========Solution Approach ==========
Take the simple test case ["0:start:0","1:start:2","1:end:5","0:end:6"]
1) Push data1, Push data2
2) On seeing end, pop the top(data2). T2 = 0+5-2+1 = 4
3) Update T1 with -4.
4) On seeing end, pop the top(data1). T1 = -4 + 6-0+1 = 3
=========================================================

*/
public class ExclusiveTimeOfFunctions {
  public int[] exclusiveTime(int n, List<String> logs) {
    Deque<Log> stack = new ArrayDeque<>();
    int[] result = new int[n];
    for (String content : logs) {
      Log log = new Log(content);
      if (log.isStart) {
        stack.push(log);
      } else {
        Log top = stack.pop();
        int currentDuration = log.time - top.time + 1;
        result[top.id] += currentDuration;
        if (!stack.isEmpty()) { // Update previous
          result[stack.peek().id] -= currentDuration;
        }
      }
    }

    return result;
  }

  public static class Log {
    private int id;
    private boolean isStart;
    private int time;

    public Log(String content) {
      String[] strs = content.split(":");
      id = Integer.valueOf(strs[0]);
      isStart = strs[1].equals("start");
      time = Integer.valueOf(strs[2]);
    }
  }

  public static void main(String[] args) {
    ExclusiveTimeOfFunctions e = new ExclusiveTimeOfFunctions();
    List<String> logs = new ArrayList<>();
    logs.add("0:start:0");
    logs.add("1:start:2");
    logs.add("1:end:5");
    logs.add("0:end:6");

    e.exclusiveTime(2, logs);
  }
}
