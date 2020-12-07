package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/*

https://leetcode.com/problems/largest-rectangle-in-histogram/

https://www.youtube.com/watch?v=RVIh0snn4Qc&feature=youtu.be

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.
height = [2,1,5,6,2,3] Output: 10(5+5)
					  __
		 6		   __|  |
		 5		  |  |  |
		 4 		  |	 |  |   __
 		 3	 __	  |	 |  |__|  |
		 2	|  |__|  |  |  |  |
		_1__|__|__|__|__|__|__|___________________

========================================Solution Approach========================================
1) If currentValue is greater than previousValue, push the index to stack. Increment currIndex.
2) Else calculate area. currIndex is not incremented. currIndex is taken as base.
  	2a) Taking currIndex as base, stack is popped(looped) and area is calculated.
  	2b) If currIndex is 5, then area is calculated for 4 to 3, then 4 to 2 like that,
  	so we keep 3 values at the same time
========================================Data Flow Analysis========================================
Input : [1,2,3,4,5,3,3,2] Output: 15

        ====================
Starting Process at Index: 0
Current Value 1 is > than null Previous Value, so pushing current to stack
        ====================
Starting Process at Index: 1
Current Value 2 is > than 1 Previous Value, so pushing current to stack
        ====================
Starting Process at Index: 2
Current Value 3 is > than 2 Previous Value, so pushing current to stack
        ====================
Starting Process at Index: 3
Current Value 4 is > than 3 Previous Value, so pushing current to stack
        ====================
Starting Process at Index: 4
Current Value 5 is > than 4 Previous Value, so pushing current to stack
        ====================
Starting Process at Index: 5
Current Value 3 is <= to Previous Value 5, so calculating area between index 4 and 4
Area between index 4 and 4 is: 5. MaxArea is: 5
      ===Note: CurrentIndex is Not Incremented. So next process will happen at same currIndex===
        ====================
Starting Process at Index: 5
Current Value 3 is <= to Previous Value 4, so calculating area between index 4 and 3
Area between index 4 and 3 is: 8. MaxArea is: 8
      ===Note: CurrentIndex is Not Incremented. So next process will happen at same currIndex===
        ====================
Starting Process at Index: 5
Current Value 3 is <= to Previous Value 3, so calculating area between index 4 and 2
Area between index 4 and 2 is: 9. MaxArea is: 9
      ===Note: CurrentIndex is Not Incremented. So next process will happen at same currIndex===
        ====================
Starting Process at Index: 5
Current Value 3 is > than 2 Previous Value, so pushing current to stack
        ====================
Starting Process at Index: 6
Current Value 3 is <= to Previous Value 3, so calculating area between index 5 and 2
Area between index 5 and 2 is: 12. MaxArea is: 12
      ===Note: CurrentIndex is Not Incremented. So next process will happen at same currIndex===
        ====================
Starting Process at Index: 6
Current Value 3 is > than 2 Previous Value, so pushing current to stack
        ====================
Starting Process at Index: 7
Current Value 2 is <= to Previous Value 3, so calculating area between index 6 and 2
Area between index 6 and 2 is: 15. MaxArea is: 15
      ===Note: CurrentIndex is Not Incremented. So next process will happen at same currIndex===
        ====================
Starting Process at Index: 7
Current Value 2 is <= to Previous Value 2, so calculating area between index 6 and 1
Area between index 6 and 1 is: 12. MaxArea is: 15
      ===Note: CurrentIndex is Not Incremented. So next process will happen at same currIndex===
        ====================
Starting Process at Index: 7
Current Value 2 is > than 1 Previous Value, so pushing current to stack

========================================================================================================================

 */
public class LargestRectangleInHistogramStackApproach {
  public int largestRectangleArea(int[] height) {

    int max = 0;
    int currIndex = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    while (currIndex < height.length) {
      if (stack.isEmpty() || height[currIndex] > height[stack.peek()]) {
        stack.push(currIndex);
        currIndex++;
      } else {
        int prevIndex = stack.pop();
        int prevValue = height[prevIndex];

        Integer prevPrevIndex = stack.isEmpty() ? null : stack.peek();
        // Calculate Current Area
        int width = prevPrevIndex == null ? currIndex : currIndex - prevPrevIndex - 1;
        int currentArea = prevValue * width;

        max = Math.max(currentArea, max);
      }
    }

    // For the left-overs Ex: [1,2,3,4]
    while (!stack.isEmpty()) {
      int prevIndex = stack.pop();
      int prevValue = height[prevIndex];
      Integer prevPrevIndex = stack.isEmpty() ? null : stack.peek();
      // Calculate Current Area
      int width = prevPrevIndex == null ? currIndex : currIndex - prevPrevIndex - 1;
      int currentArea = prevValue * width;

      max = Math.max(currentArea, max);
    }

    return max;
  }
}
