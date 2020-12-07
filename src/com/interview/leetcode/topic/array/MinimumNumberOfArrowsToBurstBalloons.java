package com.interview.leetcode.topic.array;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
===========================================================Requirement===========================================================
1) There are some spherical balloons spread in two-dimensional space. 
2) For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
3) Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. 
4) The start is always smaller than the end.
5) An arrow can be shot up exactly vertically from different points along the x-axis. 
6) There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.
7) Given an array points where points[i] = [x-start, x-end], 
return the minimum number of arrows that must be shot to burst all balloons.
============================================================Example1=============================================================
Input: points = [[2,8],[1,6],[7,12],[10,16]]
Output: 2
Explanation: One way is to shoot one arrow at any-points from2to6 (bursting the balloons [2,8] and [1,6]) 
and another arrow at any-points from10to12 (bursting the other two balloons).
============================================================Example2=============================================================
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
========================================================Solution Approach========================================================
1) Balloon is for confusing the coder. Assume each input is straight line with startPoint and endPoint.But startPoint or endPoint
can be negative too, that is one major difference with mergeIntervals. 
In mergeIntervals problem negative input is not possible 
2) Now solution is similar to mergeIntervals problem.
3) Sort input by startPoint.
4) if(currentStartPoint <= previousEndPoint) merge happens. No need to increment noOfArrowRequired.
   else increment noOfArrowRequired.

Note: to handle negative overflow... sort has to be like ==> Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
                                              instead of ==> Arrays.sort(points, (a, b) -> a[0]- b[0]);

if Arrays.sort(points, (a, b) -> a[0]- b[0]); is used
then for input [[-2147483646,-2147483645],[2147483646,2147483647]] overflow will occur and answer goes wrong to 1 instead of 2.   

Ex: [[-5,-4],[5,6]]... a[0]-b[0]... -5-(5)=-10, if -5 is the min of integer then here it is overflow.
So don't use a-b to compare when sorting. Use Integer.compare(a,b) instead!!!
=================================================================================================================================
 */
public class MinimumNumberOfArrowsToBurstBalloons {

  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
    int noOfArrowRequired = 1; // if there are only 1 balloon, minimum 1 arrow is required.
    int previousEndPoint = points[0][1];
    for (int i = 1; i < points.length; i++) {
      int currentStartPoint = points[i][0];
      if (currentStartPoint <= previousEndPoint) { // currentPoint intersect with previousPoint
        // Need for Math.min --> Ex: [[1,4],[2,3]].. previousEndPoint = 3 and not 4
        previousEndPoint = Math.min(previousEndPoint, points[i][1]);
      } else { // currentPoint not intersect with previousPoint
        noOfArrowRequired++;
        previousEndPoint = points[i][1];
      }
    }
    return noOfArrowRequired;
  }
}
