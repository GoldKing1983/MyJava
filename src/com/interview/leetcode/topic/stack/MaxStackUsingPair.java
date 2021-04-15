package com.interview.leetcode.topic.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/max-stack/description/ 
1) push(x) -- Push element x onto stack.
2) pop() -- Remove the element on top of the stack and return it.
3) top() -- Get the element on the top.
4) peekMax() -- Retrieve the maximum element in the stack.
5) popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

==========Solution Note: Using 1 stack and max variable.==========
 	1) A regular stack already supports the first 4 operations.
 	2) For the fifth operation do recursion stack...
 	See also queue QueueUsingStack

 */
public class MaxStackUsingPair {

  private Deque<int[]> stack;

  public MaxStackUsingPair() {
    stack = new ArrayDeque<>();
  }

  public void push(int x) {
    if (stack.isEmpty()) stack.push(new int[] {x, x});
    else {
      int topMax = stack.peek()[1];
      if (topMax > x) stack.push(new int[] {x, topMax});
      else stack.push(new int[] {x, x});
    }
  }

  public int pop() {
    return stack.pop()[0];
  }

  public int top() {
    return stack.peek()[0];
  }

  public int peekMax() {
    return stack.peek()[1];
  }

  public int popMax() {
    int max = stack.peek()[1];
    popMax(max);
    return max;
  }

  /*
   * 1) [Bottom 1,2,5,4,3 Top]. Data to be popped is 5.
   * 2) 3 popped, 4 popped. for 5 base condition will return.
   * 3) push 4, push 3.
   * Max for 4 and 3 will be populated by push logic... Nice Trick
   */
  private void popMax(int dataToPop) {
    int stackTop = stack.pop()[0];
    if (stackTop == dataToPop) return;
    popMax(dataToPop);
    push(stackTop);
  }
}
