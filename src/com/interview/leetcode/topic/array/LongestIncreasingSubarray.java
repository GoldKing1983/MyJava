package com.interview.leetcode.topic.array;


/*
https://www.youtube.com/watch?v=ZQOIOsKehtA
This problem is not available in leetcode. But Similar to MaximumSubArraySum
===========================================================Requirement===========================================================
1) Given an array.
2) Find the length of longest increasing subArray(not subSequenceArray)

 Ex: input:[1,2,3,0,4] output:3[1,2,3]
========================================================Solution Approach========================================================
1) Initially set resultCount as 1, as there will 1 result at all time.
2) Start from index1 or secondElement. If currentElement > previousElement. Then increase resultCount else reset resultCount.

Ex: [5, 10, 11]... We might think, when we compare I need to do like sliding-window.
Lets say I am in index2 then compare firstElement(5) and currentElement(11).  That is not needed, because 10 is greater than 5. 
We need to find subString only so comparing previous is enough.

 
 */
public class LongestIncreasingSubarray {
  
  public int solve(int[] nums) {
    int resultCount = 1;
    for(int i=1; i<nums.length; i++) {
      if(nums[i] > nums[i-1]) resultCount++;
      else resultCount=1;
    }
    return resultCount;
  }

}
