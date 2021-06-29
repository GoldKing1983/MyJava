package com.interview.leetcode.topic.unionfind;

import java.util.Arrays;

/*

1) Sort the connections by minimal cost.
2) 

 */
public class ConnectingCitiesWithMinimumCostUnionFind {

  public int minimumCost(int n, int[][] connections) {
    int[] root = new int[n + 1];
    for (int i = 0; i <= n; i++) root[i] = i;

    Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

    int cost = 0, connectionCount = 1;

    for (int[] connection : connections) {
      int sourceNodeId = connection[0], targatNodeId = connection[1];
      int sourceNodeGroup = find(root, sourceNodeId);
      int targetNodeGroup = find(root, targatNodeId);

      if (sourceNodeGroup == targetNodeGroup) continue;

      root[targetNodeGroup] = sourceNodeGroup;
      cost += connection[2];
      connectionCount++;
    }

    return connectionCount == n ? cost : -1;
  }

  public int find(int[] root, int id) {
    while (true) {
      //root[id] = root[root[id]]; // path compression
      if (id == root[id]) return id;
      id = root[id];
    }
  }



}
