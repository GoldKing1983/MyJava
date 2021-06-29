package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*

https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
===========================================================Requirement===========================================================
1) Given an array nums.
2) You can change 3 numbers atmost.
3) Return the minimum difference between the largest and smallest value.

========================================================Solution Approach========================================================
1) There are 4 cases to be handled. 
2) Solution is about discussing with interviewer and nothing much coding or logic
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
  public int minDifference(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int min = Integer.MAX_VALUE;

    if (nums[0] == nums[n - 1]) return 0;
    if (n < 5) return 0;

    //Ex1: [0,1,5,10,14]--> Ans1 --> change 5,10,14 to 0 or 1--> kill biggest 3
    min = Math.min(min, nums[n - 4] - nums[0]); //kill biggest 3;

    //Ex2: 0,1,1,4,6,6,6--> Ans2 --> change 0,1,1 to 4 to 6--> kill smallest 3;
    min = Math.min(min, nums[n - 1] - nums[3]); //kill smallest 3;

    //Ex3: 1,5,6,14,15 -->  Ans1 --> change 1,14,15 to 5 --> kill 1 smallest, 2 biggest
    min = Math.min(min, nums[n - 2] - nums[2]); //kill 1 biggest , 2 smallest

    //Ex4: [1,20,25,26,50]-->  Ans1 --> change 1,14,15 to 5 --> kill 1 biggest, 2 smallest
    min = Math.min(min, nums[n - 3] - nums[1]); //kill 1 smallest, 2 biggest

    return min;
  }
}
