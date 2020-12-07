package com.interview.leetcode.facebook.easy;
/*
https://leetcode.com/problems/minimum-time-visiting-all-points/
==================================================Requirement===============================================================
On a plane there are n points with integer coordinates  [xi, yi].
Your task is to find the minimum time in seconds to visit all points.

You can move according to the next rules:

1) In one second always you can either move vertically, horizontally by one unit or diagonally
	(it means to move one unit vertically and one unit horizontally in one second).
2) You have to visit the points in the same order as they appear in the array.
==================================================Example===================================================================
See image: MinimumTimeVisitingAllPoints.png
Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
Time from [1,1] to [3,4] = 3 seconds
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds

 */
public class MinimumTimeVisitingAllPoints {
  public int minTimeToVisitAllPoints(int[][] points) {
    int totalDistance = 0;
    for (int i = 1; i < points.length; ++i) {
      int[] cur = points[i], prev = points[i - 1];
      int differenceInXAxis = Math.abs(cur[0] - prev[0]);
      int differenceInYAxis = Math.abs(cur[1] - prev[1]);
      totalDistance += Math.max(differenceInXAxis, differenceInYAxis);
    }
    return totalDistance;
  }
}
