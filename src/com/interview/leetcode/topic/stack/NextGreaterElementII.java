package com.interview.leetcode.topic.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
https://leetcode.com/problems/next-greater-element-ii/
===========================================================Requirement===========================================================
Given a circular array (the next element of the last element is the first element of the array),
print the Next Greater Number for every element.

input : [ 5,4,3,2,1]
output: [-1,5,5,5,5]
===========Rotated input===========
        [ 5,4,3,2,1]
        [ 1,5,4,3,2]
        [ 2,1,5,4,3]
        [ 3,2,1,5,4]
        [ 4,3,2,1,5]

output: [-1,5,5,5,5]
=========================================================Initial Thought=========================================================
1) Append input with input.
2) Ex:
input : [ 5,4,3,2,1]
appendedInput : [ 5,4,3,2,1,5,4,3,2,1]
3) Now for each of value in appendedInput... do the stack operation and find nextGreaterElement.
See Also NextGreaterElementIRightApproach

 */
public class NextGreaterElementII {
  public int[] nextGreaterElements(int[] input) {
    int n = input.length, nPlusN = n+n, res[] = new int[input.length];
    int[] appendedInput = new int[nPlusN];
    for (int i = 0; i < nPlusN; i++) appendedInput[i] = input[i%n];

    Arrays.fill(res, -1);
    Deque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < nPlusN; i++) {
      int currentNumber = appendedInput[i % n];
      while (true) {
        if (stack.isEmpty()) break;
        int previousNumberInStack = stack.peek()[1];
        if (previousNumberInStack >= currentNumber) break;
        int[] previousIndexAndNumberInStack = stack.pop();
        int previousIndex = previousIndexAndNumberInStack[0];
        res[previousIndex%n] = currentNumber;
      }

      stack.push(new int[] {i % n, appendedInput[i]});
    }
    return res;
  }
}
