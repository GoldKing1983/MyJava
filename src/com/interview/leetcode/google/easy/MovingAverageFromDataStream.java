package com.interview.leetcode.google.easy;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/moving-average-from-data-stream/

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

================Problem Understanding=========
1) If the data size is less than the "size" mentioned, then sum all divide by data size.
2) If the data size reached the "size" mentioned, then sum top of size and divide by size
 *
 */
class MovingAverageFromDataStream {

  Queue<Integer> queue;
  Integer size = 0;
  double total = 0.0;

  /** Initialize your data structure here. */
  public MovingAverageFromDataStream(int size) {
    queue = new LinkedList<>();
    this.size = size;
  }

  public double next(int val) {
    queue.offer(val);
    total = total + val;
    if (queue.size() > size) {
      total = total - queue.poll();
    }
    return total / queue.size();
  }

}
