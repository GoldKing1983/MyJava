package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class FirstUniqueNumber {
  Set<Integer> unique = new HashSet<>();
  Set<Integer> duplicate = new HashSet<>();
  Deque<Integer> q = new ArrayDeque<>();

  public FirstUniqueNumber(int[] nums) {
    for (int num : nums) {
      if (duplicate.contains(num)) continue;
      if (unique.contains(num)) {
        duplicate.add(num);
        unique.remove(num);
        continue;
      }
      q.offer(num);
      unique.add(num);
    }
  }

  public int showFirstUnique() {
    while (!q.isEmpty()) {
      if (duplicate.contains(q.peek())) {
        q.poll();
        continue;
      }
      return q.peek();
    }
    return -1;
  }

  public void add(int num) {
    if (duplicate.contains(num)) return;
    if (unique.contains(num)) {
      duplicate.add(num);
      unique.remove(num);
      return;
    }
    q.offer(num);
    unique.add(num);
  }
}
