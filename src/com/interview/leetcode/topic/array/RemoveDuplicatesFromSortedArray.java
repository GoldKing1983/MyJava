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
1) Initially make write to stand on a unique value. 
1) if currentValue equals to the previousValue, skip writing element.
2) Else copy currentElement to write location
*/
public class RemoveDuplicatesFromSortedArray {

  // Below code avoids un-necessary copying. Ex: [1,2,3,4,5]. In above code, "else(copy)" logic runs "n" times.
  // If we start our logic from directly duplicates. Then unnecessary copying can be avoided.
  // See also MoveZeroesBesyEasy
  public int removeDuplicatesAvoidUnnecessaryCopy(int[] nums) {
    int write = 1;
    // Move write to first duplicate location. 
    while (write < nums.length) {
      if (nums[write] == nums[write - 1]) break;
      write++;
    }

    int read = write + 1;
    while (read < nums.length) {
      if (nums[read] == nums[read - 1]) {
        read++;
      } else {
        nums[write] = nums[read];
        read++;
        write++;

      }
    }
    return write;
  }

  public int removeDuplicates(int[] nums) {
    int write = 1; // 0th element cannot be duplicate, so start from 1.
    for (int read = 1; read < nums.length; read++) {
      int currentValue = nums[read];
      int previousValue = nums[read - 1];
      if (currentValue == previousValue) {
        // Skip Writing. Don't do anything
      } else {
        nums[write] = nums[read];
        write++;
      }
    }
    return write;
  }

}
