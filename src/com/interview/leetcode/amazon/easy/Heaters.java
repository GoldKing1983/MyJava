package com.interview.leetcode.amazon.easy;

import java.util.TreeSet;

/*
 * https://leetcode.com/problems/heaters/
 *
 * https://www.youtube.com/watch?v=Ovpvgb8sBKY
 */
public class Heaters {
  public int findRadius(int[] houses, int[] heaters) {
    TreeSet<Integer> treeset = new TreeSet<>();
    for (int heater : heaters) treeset.add(heater);
    int res = 0;
    for (int house : houses) {
      Integer upper = treeset.ceiling(house);
      Integer lower = treeset.floor(house);
      res =
          Math.max(
              res,
              Math.min(
                  upper == null ? Integer.MAX_VALUE : upper - house,
                  lower == null ? Integer.MAX_VALUE : house - lower));
    }
    return res;
  }
}
