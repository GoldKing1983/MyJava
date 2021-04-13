package com.interview.leetcode.topic.array;

/*

https://leetcode.com/problems/largest-rectangle-in-histogram

=====KeyPoint========
Height of the rectangle formed between "two or more bars" is limited by the height of the shortest bar.
See Pic "LargestRectangleInHistogram1.png".

===================================================Solution Approach - O(n^2)==================================================
1) Simple Sliding Window.
2) Start left from 0, right from left.
3) From right to endOfArray. Calculate Area.
	Area = minHeight* (right-left+1)
4) Cache the maxArea.

==========================================Data Analysis===============================================================
Input: [2,1,5,6,2,3] Output: 10

Current Left Index:0, Calculation will happen from index 0 to 5
Current Right Index: 0, Current Right Height:2, currentArea:2, maxArea:2
Current Right Index: 1, Current Right Height:1, currentArea:2, maxArea:2
Current Right Index: 2, Current Right Height:5, currentArea:3, maxArea:3
Current Right Index: 3, Current Right Height:6, currentArea:4, maxArea:4
Current Right Index: 4, Current Right Height:2, currentArea:5, maxArea:5
Current Right Index: 5, Current Right Height:3, currentArea:6, maxArea:6

Current Left Index:1, Calculation will happen from index 1 to 5
Current Right Index: 1, Current Right Height:1, currentArea:1, maxArea:6
Current Right Index: 2, Current Right Height:5, currentArea:2, maxArea:6
Current Right Index: 3, Current Right Height:6, currentArea:3, maxArea:6
Current Right Index: 4, Current Right Height:2, currentArea:4, maxArea:6
Current Right Index: 5, Current Right Height:3, currentArea:5, maxArea:6

Current Left Index:2, Calculation will happen from index 2 to 5
Current Right Index: 2, Current Right Height:5, currentArea:5, maxArea:6
Current Right Index: 3, Current Right Height:6, currentArea:10, maxArea:10
Current Right Index: 4, Current Right Height:2, currentArea:6, maxArea:10
Current Right Index: 5, Current Right Height:3, currentArea:8, maxArea:10

Current Left Index:3, Calculation will happen from index 3 to 5
Current Right Index: 3, Current Right Height:6, currentArea:6, maxArea:10
Current Right Index: 4, Current Right Height:2, currentArea:4, maxArea:10
Current Right Index: 5, Current Right Height:3, currentArea:6, maxArea:10

Current Left Index:4, Calculation will happen from index 4 to 5
Current Right Index: 4, Current Right Height:2, currentArea:2, maxArea:10
Current Right Index: 5, Current Right Height:3, currentArea:4, maxArea:10

Current Left Index:5, Calculation will happen from index 5 to 5
Current Right Index: 5, Current Right Height:3, currentArea:3, maxArea:10
==============================================================================================================================


 */
public class LargestRectangleInHistogramBruteForce {
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    for (int left = 0; left < heights.length; left++) {
      int minHeight = Integer.MAX_VALUE;
      for (int right = left; right < heights.length; right++) {
        int currentRightHeight = heights[right];
        minHeight = Math.min(minHeight, currentRightHeight);
        int currentArea = minHeight * (right - left + 1);
        maxArea = Math.max(maxArea, currentArea);
      }
    }
    return maxArea;
  }
}
