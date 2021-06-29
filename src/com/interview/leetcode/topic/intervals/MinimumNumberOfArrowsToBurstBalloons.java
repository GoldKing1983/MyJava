package com.interview.leetcode.topic.intervals;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
===========================================================Requirement===========================================================
1) There are some spherical balloons spread in two-dimensional space. 
2) Given an array of start and end.  
return the minimum number of arrows that must be shot to burst all balloons.
============================================================Example1=============================================================
Input: points = [[2,8],[1,6],[7,12],[10,16]]
Output: 2
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
   ----------------------------------------
    -----------
     |        |  2-6 common
      -------------
                -------------
                      |     | 10-12 common 
                      --------------------
Explanation: One way is to shoot one arrow at any-points from2to6 (bursting the balloons [2,8] and [1,6]) 
and another arrow at any-points from10to12 (bursting the other two balloons).
============================================================Example2=============================================================
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
==========================================================Deep Thinking==========================================================
1) Group(only direct(without transitive ex: facebook) - ex: Twitter A -> B and B -> C and C -> D... Still 2 groups... 
A,B group1 and C,D group2)  
2) Group intervals optimally such that you will form minimum group...
3) So all balloons which can be burst in 1 arrow will be in 1 group...
========================================================Solution Approach========================================================
1) Sort input by startPoint.
2) if(currentStartPoint <= previousEndPoint) overlap happens, same arrow can be used to shot both ballons.
 No need to increment noOfArrowRequired. Here keep the smallest interval.  
3) else increment noOfArrowRequired.

=======================================================Data Flow Analysis========================================================

Input: points = [[2,8],[1,6],[7,12],[10,16]]
Output: 2
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
   ----------------------------------------
    -----------
      ------------- (overlap..ignore this)
                --------------
                      --------------------(overlap..ignore this)
See also NonOverlappingIntervals... Almost same logic/code                      

 */
public class MinimumNumberOfArrowsToBurstBalloons {

  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
    int noOfArrowRequired = 1; // if there are only 1 balloon, minimum 1 arrow is required.
    int previousEnd = points[0][1];
    for (int i = 1; i < points.length; i++) {
      int currentStart = points[i][0];
      int currentEnd = points[i][1];
      if (currentStart <= previousEnd) { // currentPoint intersect with previousPoint
        // Need for Math.min --> Ex: [[1,4],[2,3]].. previousEndPoint = 3 and not 4
        previousEnd = Math.min(previousEnd, currentEnd);
      } else { // currentPoint not intersect with previousPoint
        noOfArrowRequired++;
        previousEnd = currentEnd;
      }
    }
    return noOfArrowRequired;
  }
}
