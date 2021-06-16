package com.interview.leetcode.topic.stack;

/*
https://leetcode.com/problems/max-stack/description/ 

 */
public interface MaxStackInterface<T extends Comparable<T>> {

  public void push(T x);

  public T pop();

  public T top();

  public T peekMax();

  public T popMax();

}
