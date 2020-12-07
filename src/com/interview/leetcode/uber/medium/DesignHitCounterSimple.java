package com.interview.leetcode.uber.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/design-hit-counter/

Requirement:
1) A clock is running.
2) Every seconds, the consumer can call hit or getHits with currentTimeStamp.
3) Design a system such that only last 5 minutes (300 seconds) of hits are managed.

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3. Because 1 is beyond 5 minute.
counter.getHits(301);

===========================================Solution Approach=Round-Robin==========================================
1) Insert the hits to queue.
2) During getHits, pop all the timeStemp which crossed "currentTimeStamp-QsFirstTimeStamp >= 300" .
 This Logic needs to be added in getHits. Because only there we are returning result. If hit method needs to return result.
 Then same logic should be inside there also.
 */
public class DesignHitCounterSimple {
  Queue<Integer> q = null;

  public DesignHitCounterSimple() {
    q = new LinkedList<>();
  }

  public void hit(int timestamp) {
    q.offer(timestamp);
  }

  public int getHits(int timestamp) {
    while (!q.isEmpty() && timestamp - q.peek() >= 300) {
      q.poll();
    }
    return q.size();
  }
}
