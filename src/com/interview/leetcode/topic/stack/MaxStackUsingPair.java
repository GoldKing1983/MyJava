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
public class MaxStackUsingPair implements MaxStackInterface<Integer> {

  private Deque<Integer[]> stack;

  public MaxStackUsingPair() {
    stack = new ArrayDeque<>();
  }

  public void push(Integer x) {
    if (stack.isEmpty()) stack.push(new Integer[] {x, x});
    else {
      int topMax = Math.max(x, stack.peek()[1]);
      stack.push(new Integer[] {x, topMax});
    }
  }

  public Integer pop() {
    return stack.pop()[0];
  }

  public Integer top() {
    return stack.peek()[0];
  }

  public Integer peekMax() {
    return stack.peek()[1];
  }

  public Integer popMax() {
    Integer max = stack.peek()[1];
    popMax(max);
    return max;
  }

  /*
   *
   * 4 4
   * 1 4
   * 5 5
   * 3 5
   * 
   * Assume Data to be popped is 5.
   * 3 5 pair popped, 
   * 5 5 pair popped. for 5 base condition will return.
   * push of 3 call will happen.
   * push logic will push 3 4 to stack... Nice Trick
   * 
   * updated stack is
   * 4 4
   * 1 4
   * 3 4
  
   */
  private void popMax(Integer dataToPop) {
    Integer stackTop = stack.pop()[0];
    if (stackTop == dataToPop) return;
    popMax(dataToPop);
    push(stackTop);
  }
}
