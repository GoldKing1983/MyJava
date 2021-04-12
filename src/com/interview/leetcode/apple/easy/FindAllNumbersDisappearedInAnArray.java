package com.interview.leetcode.apple.easy;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/


========================Solution Approach1 - Two pass with Negate Approach.==================================
  Note: On each parse we see 4 values.
   1) parentNode. i.e currentIndex
   2) parentNodeValue or childNode where parentNode is pointing.
   3) nums[childNode] --> childNodeValue 
  
    Parse1: Mark neighborNodeValue to visited by changing its value negative.
    [3,1,1] 
    [3,1,-1]
    [-3,1,-1]
    [-3,1,-1]-->1 visited already. So no action.
    
    Parse2: Whichever neighborNode is > 0 then parentNode is answer 


=========================
*/
public class FindAllNumbersDisappearedInAnArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int neighborNode : nums) {
      if (neighborNode < 0) neighborNode = -neighborNode;
      neighborNode--;
      if (nums[neighborNode] < 0) {
        // already visited. no action needed
      } else {
        // Change number to negative to mar
        nums[neighborNode] = -nums[neighborNode];
      }
    }
    List<Integer> result = new ArrayList<>();

    int parentNode = 1;
    for (int neighborNode : nums) {
      if (neighborNode > 0) result.add(parentNode);
      parentNode++;
    }

    return result;
  }
}
