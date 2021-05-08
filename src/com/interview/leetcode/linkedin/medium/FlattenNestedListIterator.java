package com.interview.leetcode.linkedin.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.NestedInteger;

/*
https://leetcode.com/problems/flatten-nested-list-iterator/description/

This code reduces the space-complexity of q to maxSize of anyone of NestedInteger
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
  private Queue<Integer> q;
  List<NestedInteger> nestedList;

  public FlattenNestedListIterator(List<NestedInteger> nestedList) {
    q = new LinkedList<>();
    flatten(nestedList);
  }

  int count = 0;
  int n;

  private void flatten(List<NestedInteger> nestedList) {
    this.nestedList = nestedList;
    n = nestedList.size();
    // fill the first;
    fill(nestedList.get(count));
    count++;
  }

  private void fill(NestedInteger root) {
    if (root.isInteger()) {
      q.offer(root.getInteger());
    } else {
      for (NestedInteger child : root.getList()) {
        fill(child);
      }
    }
  }

  @Override
  public Integer next() {
    return q.poll();
  }

  @Override
  public boolean hasNext() {
    // if to while... for the test case : [[],[],[-1]]  
    while (q.isEmpty() && count < n) {
      fill(nestedList.get(count));
      count++;
    }
    return !q.isEmpty();

  }
}
