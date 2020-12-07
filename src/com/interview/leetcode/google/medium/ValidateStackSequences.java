package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/validate-stack-sequences/

Requirement: Given two sequences pushed and popped with distinct values, return true if and only if this could have
 been the result of a sequence of push and pop operations on an initially empty stack.
==================================================Example1============================================================
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
==================================================Example2============================================================
Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
==================================================Solution Approach============================================================
This problems tests our coding skills. Just straight forward problem.

1) Self Explanatory code. Note 2 loops.
2) 2nd loop will pop, till it finds not matches in popped.


 */
public class ValidateStackSequences {
  // This approach is good to visualize the problem solution first.
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Deque<Integer> stack = new ArrayDeque<>();
    int popIndex = 0;
    for (int current : pushed) {
      stack.push(current);
      while (true) {
        if (stack.peek() == popped[popIndex]) {
          stack.pop();
          popIndex++;
          if (stack.isEmpty()) break;
        } else break;
      }
    }
    return stack.isEmpty();
  }
  // We don't need stack for the problem, which is un-necessary.
  public boolean validateStackSequencesBest(int[] pushed, int[] popped) {
    int i = 0, j = 0;
    for (int current : pushed) {
      pushed[i++] = current;
      while (true) {
        if (i == 0) break; // stack is empty.
        if (pushed[i - 1] == popped[j]) {
          --i;
          ++j;
        } else break;
      }
    }
    return i == 0;
  }
}
