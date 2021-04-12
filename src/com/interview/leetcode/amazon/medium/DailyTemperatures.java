package com.interview.leetcode.amazon.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/daily-temperatures/
Exact same problem as NextGreaterElementIRightApproach
===========================================================Requirement===========================================================
Problem Requirement: Find the "Next Greater Temperature" and return "difference of days".
If there is no "Next Greater Temperature" available, then return 0.
============================================================Example1=============================================================
		index	=	   0    1    2    3    4    5    6    7
		 days	=	Day1 Day2 Day3 Day4 Day5 Day6 Day7	Day8
	Temperature =	[ 73,  74,  75,  71,  69,  72,  76,  73 ],
		 Output = 	[  1,   1,   4,   2,   1,   1,   0,   0 ].
		 
For Day1 "Next Greater Temperature" is Day2. So differenceOfDaysFromIndex is 1-0 = 1
For Day2 "Next Greater Temperature" is Day3. So differenceOfDaysFromIndex is 2-1 = 1
For Day3 "Next Greater Temperature" is Day7. So differenceOfDaysFromIndex is 6-2 = 4
For Day4 "Next Greater Temperature" is Day6. So differenceOfDaysFromIndex is 5-3 = 2
For Day5 "Next Greater Temperature" is Day6. So differenceOfDaysFromIndex is 5-4 = 1
For Day6 "Next Greater Temperature" is Day7. So differenceOfDaysFromIndex is 6-5 = 1
For Day7 no "Next Greater Temperature" available so 0
For Day8 no "Next Greater Temperature" available so 0
=========================================================Initial Thought=========================================================
MonotonicQueue is concept...keeping data either increasing(ascending) or decreasing(descending) in queue/stack.... 
This problem fall into that category, 
because in above problem using stack we keep data in descendingOrder(Ex: 7,6,5,4,3,2)..
once we see 8, we pop all lowerValues, set result...
=================================================================================================================================

 */
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] result = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int idx = stack.pop();
        result[idx] = i - idx;
      }
      stack.push(i);
    }
    return result;
  }
}
