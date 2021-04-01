package com.interview.leetcode.google.medium;

import java.util.Arrays;

/* 
https://leetcode.com/problems/3sum-closest/

===========================================================Requirement===========================================================
1) Given an array nums and an integer target.
2) Find three integers, such that the sum is closest to target.
3) Note: There will be solution all the time and there will be "only one unique" solution.
========================================================Solution Approach========================================================
1) Same as "ThreeSum" problem. In "ThreeSum" we need to capture all combination without duplicate.  
2) We don't know to worry about duplicates... because another set of same results will override previous result.
3) Closest can come in negative or positive.
      Ex1: target = 5 
          threeSum = -5  closestAbs = 10  
          threeSum = 15  closestAbs = 10...
          Now both are having equal close. But this case is not possible as per requirement.
      Ex1: target = 5 
          threeSum = -5  closestAbs = 10  
          threeSum = 14  closestAbs = 9...
          
=========================================================Time Complexity=========================================================
Sorting takes O(NlogN). 2 loops takes O(n^2). So we can say it takes O(n^2)
 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    // Since there will be 1 output all the time. we can assign initial result with nums[0] + nums[1] + nums[2];
    int closestThreeSum = nums[0] + nums[1] + nums[2];
    int closestThreeSumAbs = Math.abs(target - closestThreeSum);

    for (int outer = 0; outer < nums.length - 2; outer++) {
      int firstNumber = nums[outer];
      //if (outer > 0 && nums[outer] == nums[outer - 1]) continue; // performance, can be ignored.
      int left = outer + 1, right = nums.length - 1;
      while (left < right) {
        int secondNumber = nums[left];
        int lastNumber = nums[right];
        int threeSum = firstNumber + secondNumber + lastNumber;

        if (threeSum == target) return target;
        else if (threeSum > target) right--;
        else left++;

        int currentClosestThreeSumAbs = Math.abs(target - threeSum);

        if (currentClosestThreeSumAbs < closestThreeSumAbs) {
          closestThreeSum = threeSum;
          closestThreeSumAbs = currentClosestThreeSumAbs;
        }
      }
    }
    return closestThreeSum;
  }
}
