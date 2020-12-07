package com.interview.leetcode.facebook.hard;

/*
 https://leetcode.com/problems/trapping-rain-water/description/
step0: create leftToRight array and leftToRight array equal to size of A.
step1: scan A from leftToRight. update leftMax with largest seen so for during the scan;
step2: scan A from rightToLeft, update rightMax with largest seen so for during the scan;
step3: then for each position the water level sum is below
				sum = sum + Math.min(leftMax[i], rightMax[i]) - A[i];
 
 
Input    = [10,  5, 7] Answer is 2
leftMax  = [10, 10, 10]
rightMax = [10,  7, 7]

min(10,10)-> 10-10 = 0
min(10,7) -> 7 - 5 = 2
min(10,7) -> 7 - 7 = 0

Space Complexity : 2N . Time Complexity : N
Similar Problem: MaximizeDistanceToClosestPerson
 *
*/
public class TrappingRainWater {
  public int trap1(int[] A) {
    int n = A.length;
    if (n == 0) return 0;
    int[] leftToRightMax = new int[n];
    int[] rightToLeftMax = new int[n];
    for (int i = 0, max = A[0]; i < n; i++) {
      leftToRightMax[i] = max = Math.max(max, A[i]);
    }
    for (int i = n, max = A[--i]; i >= 0; i--) {
      rightToLeftMax[i] = max = Math.max(max, A[i]);
    }
    int sum = 0;
    for (int i = 0; i < n; i++) sum = sum + Math.min(leftToRightMax[i], rightToLeftMax[i]) - A[i];
    return sum;
  }

}
