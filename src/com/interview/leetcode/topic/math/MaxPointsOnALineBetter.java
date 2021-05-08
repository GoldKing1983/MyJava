package com.interview.leetcode.topic.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/*

1) Multiple slope points falls into same points by big precision. ex: 1.23456546756757576456
2) To catch up on all those BIGDECIMAL is used.
 */
public class MaxPointsOnALineBetter {
  private static final String SAME = "same";
  private static final String INF = "inf";

  public int maxPoints(int[][] points) {
    if (points.length < 3) return points.length;
    int currentSlopeCount = 0, maxSlopeCount = 0;
    String currentSlope = null;
    Map<String, Integer> slopeCountMap = null;

    for (int i = 1; i < points.length; i++) {
      currentSlopeCount = 0;
      slopeCountMap = new HashMap<>();
      for (int j = 0; j < i; j++) {
        currentSlope = slope(points[i], points[j]);
        slopeCountMap.put(currentSlope, slopeCountMap.getOrDefault(currentSlope, 0) + 1);
        // repeat mistake. Dont count SAME here. it will be dup count. eg - [1,1][1,1][1,1] res = 3 vs 5
        if (currentSlope.equals(SAME)) continue;
        currentSlopeCount = Math.max(currentSlopeCount, slopeCountMap.get(currentSlope));

      }
      currentSlopeCount++; // repeat mistake. need to count current point.
      currentSlopeCount += slopeCountMap.getOrDefault(SAME, 0);
      maxSlopeCount = Math.max(maxSlopeCount, currentSlopeCount);
    }
    return maxSlopeCount;
  }

  private String slope(int[] point1, int[] point2) {
    String result = null;
    // repeat mistake. This one should be first if. if I put next one at top INF will be returned for SAME
    if (point1[0] == point2[0] && point1[1] == point2[1]) {
      result = SAME;
    } else if ((point1[0] - point2[0]) == 0) {
      result = INF;
    } else {
      result = String.valueOf(BigDecimal.valueOf(point1[1] - point2[1])
          .divide(BigDecimal.valueOf(point1[0] - point2[0]), new MathContext(20)));
    }
    return result;
  }

}
