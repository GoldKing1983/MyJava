package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
===========================================================Requirement===========================================================
Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular 
value.

Implement the TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false
 
============================================================Example1=============================================================
Input:
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output:
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false
========================================================Solution Approach========================================================
catch here is to handle duplicate value.
Ex: 5,6,6,6,10 --> target 12..
At anytime, I can ignore duplicate more than 2 times. Because for TwoSum, atmost I can use only 2 value.
Use the map and record duplicate by true.
======If the interviewer says no duplicate, then set is enough=====

Ex: 6,6 --> target 12. 
map = [6,true]

At iteration 1... 12-6=6 map already has 6.

So if num1==num2, then 6 should be present twice. So check for value.
=================================================================================================================================
*/
public class TwoSumIIIDataStructureDesign {

  Map<Integer, Boolean> map = new HashMap<>();

  public void add(int number) {
    // Record duplicate by setting true in value
    if (map.containsKey(number)) map.put(number, true);
    else map.put(number, false);

  }

  public boolean find(int target) {

    for (Map.Entry<Integer, Boolean> mapEntry : map.entrySet()) {
      int num1 = mapEntry.getKey();
      int num2 = target - num1;
      if (num1 == num2) {
        if (mapEntry.getValue()) return true;
      } else if (map.containsKey(num2)) {
        return true;
      }
    }
    return false;
  }
}
