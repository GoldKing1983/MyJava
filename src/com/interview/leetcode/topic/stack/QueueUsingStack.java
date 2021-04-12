package com.interview.leetcode.topic.stack;

import java.util.Deque;
import java.util.LinkedList;

/*
https://leetcode.com/problems/implement-queue-using-stacks/description/

========================================================Solution Approach========================================================
1) Keep the element "stacked" like "queue" during push itself. This makes pop operation easy.


=======================================================Data Flow Analysis========================================================
input: 1,2,3,4

process1 : [1]

process2 : pop1. push2. push1

process3 : pop1, pop2, push3, push2, push1. 
 
process4 : pop1, pop2, pop3, push4, push3, push2, push1 
 */
public class QueueUsingStack {

  Deque<Integer> stack;

  public QueueUsingStack() {
    stack = new LinkedList<>();
  }

  public void push(int currentNumber) {
    if (stack.isEmpty()) {
      stack.push(currentNumber);
    } else {
      int previousNumber = stack.pop();
      push(currentNumber);
      stack.push(previousNumber);
    }
  }

  public int pop() {
    return stack.pop();
  }

  public int peek() {
    return stack.peek();
  }

  public boolean empty() {
    return stack.isEmpty();
  }
}
