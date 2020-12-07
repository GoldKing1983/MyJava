package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/remove-element/
============================================Solution Approach=========================================================
1) In the "RemoveElement" code, there are too many swaps. Ex: out of 1000 elements. If target was there in only one place.
Still there will be 1000 swaps.
2) The requirement says order can be changed.
3) So in this code, when we found target on read location, write happens in read itself by moving data from end side.

 */
public class RemoveElementBest {
  public int removeElement(int[] nums, int target) {
    int readAndWrite = 0;
    int last = nums.length - 1;
    while (readAndWrite <= last) {
      if (nums[readAndWrite] == target) {
        nums[readAndWrite] = nums[last];
        last--; // reduce array size by one
      } else {
        readAndWrite++;
      }
    }
    return last + 1;
  }
}
