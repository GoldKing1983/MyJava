package com.leetcode.maths;
/*
https://leetcode.com/problems/check-if-it-is-a-straight-line/

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.
=================================================Solution Approach=================================================
1) Calculate slope for 2 points.
2) Slope doesn't needs to be consecutive or need to be related. It can be any between 2 points.
Ex: p1, p2, p3.
Comparing (p1 and p2), (p1 and p3), (p2 and p3) all yields same result.

Ex:Input: [[1,2],[2,3],[3,4]] Output: true
[1,2],[2,3] is 1.0  [1,2],[3,4] is 1.0 [2,3],[3,4] is 1.0
====================================================================================================================
 */
public class CheckIfItIsAStraightLine {
  public boolean checkStraightLine(int[][] coor) {
    // slope formula:
    // slope = (y2 - y1) / (double) (x2 - x1)
    int x1 = coor[0][0];
    int y1 = coor[0][1];
    int x2 = coor[1][0];
    int y2 = coor[1][1];

    double slope = calcSlope(x1, y1, x2, y2);

    for (int i = 2; i < coor.length; i++) {
      x2 = coor[i][0];
      y2 = coor[i][1];
      double currSlope = calcSlope(x1, y1, x2, y2);

      if (slope != currSlope) return false;
    }

    return true;
  }

  private double calcSlope(int x1, int y1, int x2, int y2) {
    return (y2 - y1) / (double) (x2 - x1);
  }
}
