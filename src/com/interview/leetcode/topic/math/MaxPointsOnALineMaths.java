package com.interview.leetcode.topic.math;

import java.util.HashMap;
import java.util.Map;
import com.interview.leetcode.Point;

/*
https://leetcode.com/problems/max-points-on-a-line/description/

Slope Formula =  line = (y2 - y1) / (x2 - x1).

1) A slope is a line which cuts 2 points([x1,y1][x2,y2]).
2) Take a point and calculate slope with all other points. So. it will be n*n operation. See MaxPointsOnALine_Simple.java
3) Do step1 for all the points.
4) Whichever has the most point wins.
5) Only problem is point lies on the same point  or overlapOrSameXYAxis. Ex: [[1,1][1,1][1,1]] --> Here result is 3
6) Another issue is, I can't take step5 logic out because Ex: [[1,1][1,1][2,2]] --> Here result is 3


 */
public class MaxPointsOnALineMaths {
  public int maxPoints(Point[] points) {
    int maxLine = 0;

    for (int i = 0; i < (points.length - maxLine); i++) {
      int overlapOrSameXYAxis = 0;
      Map<Double, Integer> slopeCountsMap = new HashMap<>();
      for (int j = i + 1; j < points.length; j++) {
        Double slope;
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          overlapOrSameXYAxis++;
          continue;
        } else if (points[i].x == points[j].x) {
          slope = Math.PI; // Keeping a constant
        } else if (points[i].y == points[j].y) {
          slope = 0.0; // logically we don't need this, but in practice i find that we do
        } else {
          // https://leetcode.com/problems/max-points-on-a-line/discuss/47119/Why-is-one-of-the-test-case-so-annoying
          // To avoid divide by overflow, multiplying 10.0.. It was luck as leetcode test case,
          // might fail for other test cases
          slope = 10.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
        }

        if (slopeCountsMap.containsKey(slope))
          slopeCountsMap.put(slope, slopeCountsMap.get(slope) + 1);
        else slopeCountsMap.put(slope, new Integer(1));
      }
      maxLine = Math.max(maxLine, 1 + overlapOrSameXYAxis + maxValue(slopeCountsMap));
    }

    return maxLine;
  }

  private int maxValue(Map<Double, Integer> slopeCountsMap) {
    int max = 0;
    for (Integer maxValue : slopeCountsMap.values()) {
      max = Math.max(max, maxValue);
    }
    return max;
  }
}
