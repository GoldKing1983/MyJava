package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/online-stock-span/
============================================================Requirement======================================================================
1) For each of currentStockPrice, find "ImmediateLongestContinuousDecreasingGroup" size.
The group doesn't has to be in any order.
Consider first 3 days stockValue is [10,20,30] or [20,30,10] or [30,20,10]...
4th day stockValue is "40". Answer for 4th day is 4 for any of above sequence. That is why it said group (imagine quickSelect don't bother left is sorted)

Ex1: Input : [100],[120],[115]
	Output : [1],[2],[1]

Ex2: Input : [100],[115],[120]
	Output : [1],[2],[3]
=========================================Solution Approach - Time Complexity : O(n)=============================================================
1) Use a stack to keep a decreasing sub-sequence,
2) Whenever we see currentNumber greater than stack.peek(), we pop all elements less than currentNumber and for all the popped ones,
their next greater element is currentElement.
============================================================Data Flow Analysis===================================================================
Input : [100],[115],[120]
========Processing Current Stock Price : 100=========
Current Stack values [100, 1]
longestContinuousDecreasing Stock Count before Current Stock Price is : 1
========Processing Current Stock Price : 115=========
Current Stack values [115, 2]
longestContinuousDecreasing Stock Count before Current Stock Price is : 2
========Processing Current Stock Price : 120=========
Current Stack values [120, 3]
longestContinuousDecreasing Stock Count before Current Stock Price is : 3
============================================================Data Flow Analysis -- Explains Why stack is needed====================================
Input: [115],[100],[90],[120]
========Processing Current Stock Price : 115=========
Current Stack values [115, 1]
longestContinuousDecreasing Stock Count before Current Stock Price is : 1
========Processing Current Stock Price : 100=========
Current Stack values [115, 1][100, 1]
longestContinuousDecreasing Stock Count before Current Stock Price is : 1
========Processing Current Stock Price : 90=========
Current Stack values [115, 1][100, 1][90, 1]
longestContinuousDecreasing Stock Count before Current Stock Price is : 1
========Processing Current Stock Price : 120=========
Current Stack values [120, 4]
longestContinuousDecreasing Stock Count before Current Stock Price is : 4


 */
public class OnlineStockSpan {
  Deque<int[]> stack = new ArrayDeque<>();

  public int next(int price) {
    int res = 1;
    while (!stack.isEmpty() && price >= stack.peek()[0]) res += stack.pop()[1];
    stack.push(new int[] {price, res});
    return res;
  }
}
