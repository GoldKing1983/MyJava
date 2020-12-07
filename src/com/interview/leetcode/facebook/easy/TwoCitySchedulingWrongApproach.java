package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/two-city-scheduling/


Sort by lowest and eagerly selecting the smallest will fail.

[[1,10],[2,2],[2,1],[3,4]] Output:7.

=================================Data Flow Analysis=================================
[[1,10],[2,2],[2,1],[3,4]] Output:7.
Map = {1=[1, 0, 2, 2], 2=[1, 1, 2, 1, 1, 2], 3=[1, 3], 4=[2, 3], 10=[2, 0]}
But for below output will be 8, which is wrong


*/

public class TwoCitySchedulingWrongApproach {
  public int twoCitySchedCost(int[][] costs) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    int n = costs.length;
    boolean[] filled = new boolean[n];
    int i = 0;
    for (int[] cost : costs) {
      map.computeIfAbsent(cost[0], k -> new ArrayList<>()).add(1);
      map.get(cost[0]).add(i);
      map.computeIfAbsent(cost[1], k -> new ArrayList<>()).add(2);
      map.get(cost[1]).add(i);
      i++;
    }
    int sum = 0;
    int person1Count = n / 2, person2Count = n / 2;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      int value = entry.getKey();
      List<Integer> list = entry.getValue();
      for (i = 0; i < list.size(); i++) {
        int person = list.get(i++);
        int index = list.get(i);
        if (filled[index]) continue;
        if (person == 1) {
          if (person1Count > 0) {
            person1Count--;
            sum += value;
            filled[index] = true;
          }
        } else { // person2
          if (person2Count > 0) {
            person2Count--;
            sum += value;
            filled[index] = true;
          }
        }
      }
    }
    return sum;
  }
}
