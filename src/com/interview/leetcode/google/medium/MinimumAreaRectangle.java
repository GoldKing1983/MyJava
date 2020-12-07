package com.interview.leetcode.google.medium;

import java.util.HashSet;

/*
* https://leetcode.com/problems/minimum-area-rectangle/
Requirement: For the given points find the "minimal area rectangle";
Note: only for positive numbers
Area of Rectangle = length*width
=========================================================Solution Approach====================================================
1) A Rectangle Can be formed between 4 points. Based on below condition.
Condition1: If (x1 != x2 && y1 != y2)
	Ex: Between any 2 Points, which is not in same line("x- axis wise" or "y- axis wise") or only between diagonal
					===============
						   X
						  /
						 /
						X       (Possible, provided matching condition2)
					===============
						X-----X (Not Possible)
					===============
						X
						|
						|
						X       (Not Possible)
					===============

        String line1And2 = x1 + "," + y2;
        String line3And4 = x2 + "," + y1;
Condition2: pointsSet.contains(line1And2) && pointsSet.contains(line3And4)

						4	|(3,1) line3 (3,4)
						3	|  x-----------x
						2	|  |<--line4   | line2
						1	|  x-----------x
							|(1,1) line1  (1,4)
				--------------------------------
							|  1   2   3   4
							|
							|
							|

2) String is slow. To improve performance in leetcode, do hash for pointsSet.
==============================================================================================================================
Input : [[1,1],[3,3]], Output: 0
X Map: {1=[1], 3=[3]}
Y Map: {1=[1], 3=[3]}
Finding Rectangle for points: 1,1 and 3,3
==============================================================================================================================
Input : [[1,2],[3,4]], Output: 0
X Map: {1=[2], 3=[4]}
Y Map: {2=[1], 4=[3]}
Finding Rectangle for points: 1,2 and 3,4
==============================================================================================================================
Input: [[1,1],[1,3],[3,1],[3,3]], Output:4
X Map: {1=[1, 3], 3=[1, 3]}
Y Map: {1=[1, 3], 3=[1, 3]}
Finding Rectangle for points: 1,1 and 3,3
Finding Rectangle for points: 1,3 and 3,1

						4	|(3,1)	 (3,3)
						3	|  x       x
						2	|
						1	|  x       x
							|(1,1)   (1,3)
				-----------------------------
							|  1   2   3   4
							|
							|
							|

==============================================================================================================================

*/
public class MinimumAreaRectangle {

  public int minAreaRect(int[][] points) {
    HashSet<String> pointsSet = new HashSet<>();
    for (int i = 0; i < points.length; i++) pointsSet.add(points[i][0] + "," + points[i][1]);
    int minArea = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        String line1And2 = x1 + "," + y2;
        String line3And4 = x2 + "," + y1;
        if (x1 != x2
            && y1 != y2
            && pointsSet.contains(line1And2)
            && pointsSet.contains(line3And4)) {
          int length = Math.abs(x1 - x2);
          int width = Math.abs(y1 - y2);
          int currentArea = length * width;
          minArea = Math.min(currentArea, minArea);
        }
      }
    }
    return minArea == Integer.MAX_VALUE ? 0 : minArea;
  }
}
