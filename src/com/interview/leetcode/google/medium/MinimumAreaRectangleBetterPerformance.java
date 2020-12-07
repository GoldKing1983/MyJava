package com.interview.leetcode.google.medium;

import java.util.HashSet;

/*
* https://leetcode.com/problems/minimum-area-rectangle/

Logic is same as "MinimumAreaRectangle". Only the hash change

==============================================================================================================================

*/
public class MinimumAreaRectangleBetterPerformance {

  private int hash(int x, int y) {
    return x * 40000 + y;
  }

  public int minAreaRect(int[][] points) {
    HashSet<Integer> st = new HashSet<>();
    for (int i = 0; i < points.length; i++) st.add(hash(points[i][0], points[i][1]));
    int minArea = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        Integer s1 = hash(x1, y2);
        Integer s2 = hash(x2, y1);
        if (x1 != x2 && y1 != y2 && st.contains(s1) && st.contains(s2)) {
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
