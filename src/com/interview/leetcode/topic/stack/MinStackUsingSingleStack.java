package com.interview.leetcode.topic.stack;

import java.util.Deque;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack
 *
 * index0 stores data.
 * index1 stores minimum.
 *
 */
public class MinStackUsingSingleStack {
  Deque<int[]> stack = new LinkedList<>();

  public void push(int x) {
    if (!stack.isEmpty()) {
      int previousMin = stack.peek()[1];
      int currentMin = Math.min(previousMin, x);
      stack.push(new int[] {x, currentMin});
    } else stack.push(new int[] {x, x});
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek()[0];
  }

  public int getMin() {
    return stack.peek()[1];
  }
}
