package com.interview.leetcode.topic.stack;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/next-greater-element-i/

=================================Solution Approach - Time Complexity : O(n^2)==========================================
1) Take nums.
2) For each of number in nums, find the nextGreaterElement and store in map.
    a) This is done in linear fashion
    b) Pick a number at index0 lets say left. right=left+1.
    c) Traverse all the way from leftToRight. If greaterNumber found update map with key and greaterNumber.
    Ex: nums = [6,5,4,3,2,1,7]
        map = {6:7}
    c) Pick the nextNumber. right=left+1. do stepC.
            map = {6:7,5:7}
    d) Finally we will have map like --> {1:7,2:7,3:7,4:7,5:7,6:7,7:-1}
3) Take findNums.
4) For each of number in findNums, find the nextGreaterElement from map.

========================================================================================================================


 */
public class NextGreaterElementIBruteForce {

  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    if (nums.length < 2) return findNums;

    int left = 0, right = 1;
    while (left < nums.length - 1) {
      if (nums[left] < nums[right]) {
        map.put(nums[left], nums[right]);
        left++;
        right = left + 1;
      } else if (right == nums.length - 1) { // right reached max. rest to left+1
        map.put(nums[left], -1);
        left++;
        right = left + 1;
      } else {
        right++;
      }
    }
    map.put(nums[nums.length - 1], -1);

    for (int i = 0; i < findNums.length; i++) {
      findNums[i] = map.get(findNums[i]);
    }
    return findNums;
  }
}
