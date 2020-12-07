package com.interview.leetcode.amazon.medium;

import java.util.List;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/minimum-time-difference/

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference
between any two time points in the list.

Input: ["23:59","00:00","23:57"]
Output: 1
=========================================
Multiplied by 60 and how it is available in priority queue[0, 1437, 1439]
==================================Solution Overview======================
1) Convert the time into minutes by multiplying hour with 60.
2) Sort the minute.
3) Start from 2nd. do curr-prev. track min.
4) Finally 1 subtraction  needs to be done for 1st and last.
5) Ex: For 3 elements.
	2nd-1st (1437-0)
	3rd-2nd (1439-1437)
	1st-3rd (1440-1439) For 1-3 1 needs to be added with (24*60). Because of 0. Ex: 00:01 will be 1+(24*60)

 */
public class MinimumTimeDifference {
  public int findMinDifference(List<String> timePoints) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (String s : timePoints) {
      int h = Integer.parseInt(s.substring(0, 2));
      int m = Integer.parseInt(s.substring(3));
      pq.offer(h * 60 + m);
    }
    int res = Integer.MAX_VALUE, prev = pq.poll();
    int first = prev + (24 * 60);
    while (!pq.isEmpty()) {
      int curr = pq.poll();
      res = Math.min(res, curr - prev);
      prev = curr;
    }
    return Math.min(res, first - prev);
  }
}
