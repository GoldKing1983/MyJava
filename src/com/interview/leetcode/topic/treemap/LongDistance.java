package com.interview.leetcode.topic.treemap;

import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

/*

1) Given an input array.
2) Find the number of occurrence of smaller elements to the right.

Input  : [3, 4, 9, 6, 1]
Output : [1, 1, 2, 1, 0]
          
          3 has only1 small element i.e 1
          4 has only1 small element i.e 1
          9 has only1 small element i.e 6,1
          6 has only1 small element i.e 1
          1 is the last element. So it must be 0. 
 */
public class LongDistance {

  // If there is no duplicates in input, then treeSet is enough
  public int[] solveNoDuplicates(int[] lst) {
    TreeSet<Integer> set = new TreeSet<>();
    int[] result = new int[lst.length];
    for (int i = lst.length - 1; i >= 0; i--) {
      int lowerCount = set.headSet(lst[i]).size();
      if (lowerCount == 0) {
        result[i] = 0;
      } else {
        result[i] = lowerCount;
      }
      set.add(lst[i]);
    }
    return result;
  }

  public int[] solveWithDuplicates(int[] lst) {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int[] result = new int[lst.length];
    for (int i = lst.length - 1; i >= 0; i--) {
      Collection<Integer> resultMapValues = map.headMap(lst[i]).values();
      if (resultMapValues.isEmpty()) {
        result[i] = 0;
      } else {
        int lowerCount = 0;
        for (int count : resultMapValues) lowerCount = lowerCount + count;
        result[i] = lowerCount;
      }
      map.put(lst[i], map.getOrDefault(lst[i], 0) + 1);
    }
    return result;

  }
}
