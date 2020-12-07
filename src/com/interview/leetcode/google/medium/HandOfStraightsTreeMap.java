package com.interview.leetcode.google.medium;

import java.util.TreeMap;

/*
https://leetcode.com/problems/hand-of-straights/description/
	Same Logic as HandOfStraights but using TreeMap.
	Time Complexity : O(n(log n))
 */
public class HandOfStraightsTreeMap {

  public boolean isNStraightHand(int[] hands, int groupCount) {
    int n = hands.length;
    if (n % groupCount != 0) return false;
    int totalGroups = n / groupCount;

    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int hand : hands) map.put(hand, map.getOrDefault(hand, 0) + 1);


    while (totalGroups-- > 0) {
      int top = map.firstKey();
      int topCount = map.get(top);

      if (topCount == 1) map.remove(top);
      else map.put(top, topCount - 1);

      for (int i = 1; i < groupCount; i++) {
        Integer next = top + i;
        Integer nextCount = map.get(next);

        if (nextCount == null) return false;

        if (nextCount == 1) map.remove(next);
        else map.put(next, nextCount - 1);
      }
    }
    return true;
  }
}
