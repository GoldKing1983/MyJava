package com.interview.leetcode.topic.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/majority-element/
=================================================Requirement===========================================================
1) Problem states x number will appear more than n/2 times.
2) So x will occupy more than half of array.
3) You may assume that the array is non-empty and the "majority element always exist" in the array.

Note: The algorithm should run in linear time and in O(1) space.

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Input: [3,2,3]
Output: 3

Input: [2,2,1,1,1,2,2]
Output: 2

=================================================Solution Approach=====================================================
1) Since "element" occupies more than "n/2" times.
2) We can Split entire array into 2 groups. MajorGroup and MinorGroup.
3) If point2 is 100% clear, then [2,2,1,1,1] same as [10,20,1,1,1]. 1 majorGroup and remainingAll forms minorGroup.
4) So now think and code for combinations....[2,2,1,1,1] [1,1,1,2,2] [1,2,1,2,1] [2,1,2,1,1]
5) Take value at index0 as majorityNumber and its count as 1.
6) If the nextNumber==majorityNumber , then increment count, else decrement count.
7) If the count goes belowZero, then change majorityNumber to currentNumber and count to 1. Ex: [2,2,1,1,1]

 */
public class MajorityElement {

  public int majorityElement(int[] nums) {

    int majorityNumber = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      int currNumber = nums[i];
      if (currNumber == majorityNumber) {
        count++;
      } else {
        count--;
        if (count < 0) {
          majorityNumber = currNumber;
          count = 1;
        }
      }
    }
    return majorityNumber;
  }

  public int majorityElementMapApproach(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    int maxNumber = 0;
    for (Integer num : nums) {
      int count = map.getOrDefault(num, 0) + 1;
      if (count > maxCount) {
        maxCount = count;
        maxNumber = num;
      }
      map.put(num, count);
    }
    return maxNumber;
  }

  public int majorityElementSortApproach(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
