package com.interview.leetcode.google.hard;

import java.util.TreeSet;

/*
https://leetcode.com/problems/k-empty-slots/description/

Requirement:
1) Plant a flower at a location on each day.
2) If between 2 flowers, if K empty slot found. Return that day.
3) First and last are considered empty slot.

To understand the problem description read below
https://stackoverflow.com/questions/46393470/find-earliest-time-for-k-empty-group

see sample1 "K-Empty-Slots.png" and sample2 "K-Empty-Slots1.png"
==================================================Solution Approach==================================================
Solution: Insert Into Sorted Structure
1) After adding a "currentValue", I need to a) get "higherValue" than "currentValue"
											 b) get "lowerValue" than "currentValue".
2) If the difference of higherValue-currentValue or currentValue-lowerValue is equal to K.
Then result found return the current day.
=====================================Data Flow Analysis===============================================================
Ex1 :{5, 3, 2} K=1
0 0 0 0 1 ---> higher = null and lower = null
0 0 1 0 1 ---> higher = 5 and lower = null (5-3-1=1) // Result Found
========Result Found at Day2 (Right To Left), no need to traverse 3rd day========

Ex2 : {2, 5, 1, 4, 3} K = 2
0 1 0 0 0 ---> higher = null and lower = null
0 1 0 0 1 ---> higher = null and lower = 2 (5-2-1 = 2) // Result Found
========Result Found at Day2 ( Left To Right), no need to traverse 3rd day========

Ex3: {1, 4, 3, 5, 2} K = 1
1 0 0 0 0 ---> higher = null and lower = null
1 0 0 1 0 ---> higher = null and lower = 1 (4-1-1 = 2) // Result Not Found. Because 1!=2
1 0 1 1 0 ---> higher = 4 and lower = 1 --> 3-1-1=1. Result Found. Or Condition will not execute(Left to Right is 4-3-1=0)
========Result Found at Day3 (Right To Left), no need to traverse 4th day

 */
public class KEmptySlots {
  public int kEmptySlots(int[] flowers, int k) {
    TreeSet<Integer> flowerSlot = new TreeSet<>();
    int day = 0;
    for (int flowerAtCurrentIndex : flowers) {
      day++;
      flowerSlot.add(flowerAtCurrentIndex);
      Integer flowerAtLowerIndex = flowerSlot.lower(flowerAtCurrentIndex);
      Integer flowerAtHigherIndex = flowerSlot.higher(flowerAtCurrentIndex);
      if (flowerAtLowerIndex != null && flowerAtCurrentIndex - flowerAtLowerIndex - 1 == k
          || flowerAtHigherIndex != null && flowerAtHigherIndex - flowerAtCurrentIndex - 1 == k)
        return day;
    }
    return -1;
  }
}
