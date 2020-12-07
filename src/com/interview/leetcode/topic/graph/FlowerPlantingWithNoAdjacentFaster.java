package com.interview.leetcode.topic.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
FlowerPlantingWithNoAdjacent uses set add/remove operation which makes the run-time costlier.
Even though set is O(1) for add/remove operation.


*/
public class FlowerPlantingWithNoAdjacentFaster {
  public int[] gardenNoAdj(int n, int[][] paths) {
    Map<Integer, Set<Integer>> adjMap = new HashMap<>();
    for (int i = 1; i <= n; i++) adjMap.put(i, new HashSet<>());

    for (int[] edge : paths) {
      adjMap.get(edge[0]).add(edge[1]);
      adjMap.get(edge[1]).add(edge[0]);
    }

    int[] gardens = new int[n + 1];
    for (int garden = 1; garden <= n; garden++) {
      boolean[] availableFlowers = new boolean[5]; // ignoring 0.
      for (int flower = 1; flower <= 4; flower++) availableFlowers[flower] = true;

      for (int connectedGarden : adjMap.get(garden)) {
        int connectedGardenFlower = gardens[connectedGarden];
        // flower is taken by adjacent garden. So make it invalid
        availableFlowers[connectedGardenFlower] = false;
      }
      for (int flower = 1; flower <= 4; flower++) if (availableFlowers[flower]) {
        gardens[garden] = flower;
        break;
      }
    }

    return Arrays.copyOfRange(gardens, 1, n + 1); // Ignore 0th garden
  }
}
