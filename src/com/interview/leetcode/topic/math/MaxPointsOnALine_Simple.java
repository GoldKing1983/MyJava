package com.interview.leetcode.topic.math;

import java.util.HashMap;
import com.interview.leetcode.Point;

/*
 * Slope Formula =  line = (y2 - y1) / (x2 - x1).
 *
 * 1) A slope is a line which cuts 2 points.
 * 2) Take a point and calculate slope with all other points. So, there will be n-1 operation for a point.
 * 3) Do step2 for all the points.
 * 4) Whichever has the most point wins.
 */
public class MaxPointsOnALine_Simple {

  public int maxPoints(Point[] points) {
    HashMap<Double, Integer> hm = new HashMap<>();
    if (points.length <= 0) return 0;
    if (points.length <= 2) return points.length;
    int result = 0;
    for (int i = 0; i < points.length; i++) {

      for (int j = i + 1; j < points.length; j++) {
        if (j != i) {
          // Apply slope formula
          double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
          hm.put(k, hm.getOrDefault(k, 1) + 1);
          System.out.println(hm);
          result = Math.max(result, hm.get(k));
        }
      }
      hm.clear();
    }
    return result;
  }
}
