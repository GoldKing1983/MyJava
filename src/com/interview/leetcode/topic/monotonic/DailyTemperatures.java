package com.interview.leetcode.topic.monotonic;

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
		              1-0  2-1  6-2  5-3  5-4  6-5   
For Day1 "Next Greater Temperature" is Day2. So differenceOfDaysFromIndex is 1-0 = 1
For Day2 "Next Greater Temperature" is Day3. So differenceOfDaysFromIndex is 2-1 = 1
For Day3 "Next Greater Temperature" is Day7. So differenceOfDaysFromIndex is 6-2 = 4
For Day4 "Next Greater Temperature" is Day6. So differenceOfDaysFromIndex is 5-3 = 2
For Day5 "Next Greater Temperature" is Day6. So differenceOfDaysFromIndex is 5-4 = 1
For Day6 "Next Greater Temperature" is Day7. So differenceOfDaysFromIndex is 6-5 = 1
For Day7 no "Next Greater Temperature" available so 0
For Day8 no "Next Greater Temperature" available so 0
=========================================================Initial Thought=========================================================
Based on MonotonicQueue concept...keeping data either increasing(ascending) or decreasing(descending) in queue/stack.... 
This problem fall into that category, 
because in above problem using stack we keep data in descendingOrder(Ex: 7,6,5,4,3,2)..
once we see 8, we pop all lowerValues, set result...
=================================================================================================================================

 */
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {

    // 5,4,3,6
    // on seeing 6 pop
    Deque<Integer> stack = new ArrayDeque<>();
    int[] result = new int[temperatures.length];
    int currentDay = 0;
    for (int temperature : temperatures) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperature) {
        int previousDay = stack.pop();
        int nextGreaterTemperature = currentDay - previousDay;
        result[previousDay] = nextGreaterTemperature;
      }
      stack.push(currentDay);
      currentDay++;
    }
    return result;
  }
}
