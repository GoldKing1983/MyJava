package com.interview.leetcode.linkedin.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.NestedInteger;

/*
https://leetcode.com/problems/flatten-nested-list-iterator/description/

1) This code reduces the space-complexity of q to maxSize of anyone of NestedInteger
2) Lets say nestedList size is 5. Initially 1st nestedList is loaded to q.
3) Once q is empty. Then 2nd is loaded to q. Like that we load q on demand.
4) Check for corner case test case : [[],[],[-1]]... nestedList can be empty.  
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
  private Queue<Integer> q;
  List<NestedInteger> nestedList;
  int count = 0;
  int n;

  public FlattenNestedListIterator(List<NestedInteger> nestedList) {
    q = new LinkedList<>();
    flatten(nestedList);
  }

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
