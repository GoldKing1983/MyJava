package com.interview.leetcode.google.medium;

import java.util.List;

/*

https://leetcode.com/problems/zigzag-iterator/

No logic, just move pointers and get result.

Adding the v1 and v2 to another list or any new data structure is un-necessary.
 */
public class ZigzagIterator {
  int p1 = 0, p2 = 0;
  int n1, n2;
  List<Integer> v1, v2;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    n1 = v1.size();
    n2 = v2.size();
    this.v1 = v1;
    this.v2 = v2;
  }

  public int next() {
    if (p1 < p2 && p1 < n1) {
      return v1.get(p1++);
    } else if (p2 < p1 && p2 < n2) {
      return v2.get(p2++);
    }
    if (p1 < n1) return v1.get(p1++);
    if (p2 < n2) return v2.get(p2++);
    return -1;
  }

  public boolean hasNext() {
    return (p1 < n1 || p2 < n2);
  }
}
