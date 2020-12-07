package com.interview.leetcode.google.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
https://leetcode.com/problems/design-phone-directory/

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);

====================================================Solution Approach====================================================
1) If element exists already, and release called. Don't do anything

 */
public class PhoneDirectory {
  private Set<Integer> set = new HashSet<>();

  private PriorityQueue<Integer> q = new PriorityQueue<>();

  public PhoneDirectory(int maxNumbers) {
    for (int i = 0; i < maxNumbers; i++) {
      q.offer(i);
      set.add(i);
    }
  }

  public int get() {
    if (q.isEmpty()) return -1;
    int numToDelete = q.poll();
    set.remove(numToDelete);
    return numToDelete;
  }

  public boolean check(int number) {
    return set.contains(number);
  }

  public void release(int number) {
    if (set.contains(number)) return;
    set.add(number);
    q.offer(number);
  }
}
