package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
===========================================================Requirement===========================================================
1) Given a sorted array nums.
2) Remove the duplicates in-place.
============================================================Example1=============================================================
Given nums =       [1,1,2]
changed input nums=[1,2,x]
Your function should return length = 2,
============================================================Example1=============================================================
Given nums =       [0,0,1,1,1,2,2,3,3,4]
changed input nums=[0,1,2,3,4,x,x,x,x,x]
Your function should return length = 5, 
========================================================Solution Approach========================================================
1) if readValue equals to the writeValue. Just move read.
2) Else copy currentElement to write location
*/
public class RemoveDuplicatesFromSortedArray {
  /*
      if both same, increment read  
      1   1   1   2
      w,r 
       
      1   1   1   2
      w   r 
      
      1   1   1   2
      w       r 
  
      1   2   1   2
          w       r
      
      if both different, increment write... move data(not swap) from read to write... increment read  
   */
  public int removeDuplicates(int[] nums) {
    int n = nums.length, write = 0, read = 0;
    while (read < n) {
      if (nums[read] == nums[write]) {
        // no operation
      } else {
        write++;
        nums[write] = nums[read];
      }
      read++;
    }
    return write + 1;
  }

}
