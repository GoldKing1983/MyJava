package com.interview.leetcode.amazon.medium;

import java.util.Iterator;

/*
 * https://leetcode.com/problems/peeking-iterator/description/
 * 
 * Note: 
 * To support the peek operation on Iterator. Cache the first element in iterator and hold it.
 */

class PeekingIterator implements Iterator<Integer> {
  Integer top = null;
  Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator) {
    this.iterator = iterator;
    if (iterator.hasNext()) top = iterator.next();

  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return top;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer result = top;
    if (iterator.hasNext()) top = iterator.next();
    else top = null;
    return result;
  }

  @Override
  public boolean hasNext() {
    return top != null;
  }
}
