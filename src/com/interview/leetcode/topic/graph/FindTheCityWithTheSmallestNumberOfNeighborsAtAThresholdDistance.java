package com.interview.leetcode.topic.graph;

import java.util.*;

/*
https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

===========================================================Requirement===========================================================
1) Given a list of source,neighbor with cost and thresholdCost.
2) For each sourceNode find how many neighbor it can visit within thresholdCost.
3) Return lowest number of neighbors of any sourceNode can visit.. If there are more than 1 answer then
return max of node.
Ex: node1 can reach100 nodes, node3 can reach100 nodes, then return node3 as answer.
This is achieved by parsing from 1 to n. If same min found again, then result updated with recentNode.

If the interviewer asks for min of node in case duplicateMin, then parse from n to 1, thats it.
===========================Solution Approach using Prims(Greedy) Algorithm ===========================
1) Greedily push the neighbors to pQ and mark it as visited.
2) pQ will float with lowest cost neighbor.
3) So path with highest cost route, never processed.
=======================================================Data Flow Analysis========================================================
6
[[0,1,10],[0,2,1],[2,3,1],[1,3,1],[1,4,1],[4,5,10]]
20
Output: 5

source : 0..nodesReachable : 6(6 not 5 because, any node is reachable by itself)
source : 1..nodesReachable : 6
source : 2..nodesReachable : 6
source : 3..nodesReachable : 6
source : 4..nodesReachable : 6
source : 5..nodesReachable : 6

           (10)                       (1)        (10)
         ---------------- 1-------------------4---------5
      0                  | (1)
         -------2--------3
           (1)     (1)

=======================================================Data Flow Analysis========================================================
4
[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]
4
Output :3
                (1)
        (3)   -------2
    0-------1         |(1)
              -------3
                (4)

 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    Map<Integer, Map<Integer, Integer>> adjMap = new HashMap<>();
    for (int[] e : edges) {
      adjMap.computeIfAbsent(e[0], k -> new HashMap<>()).put(e[1], e[2]);
      adjMap.computeIfAbsent(e[1], k -> new HashMap<>()).put(e[0], e[2]);
    }
    int minReachableNodeCount = Integer.MAX_VALUE;
    int result = -1;
    for (int i = 0; i < n; i++) {
      Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
      q.add(new int[] {i, 0});

      Set<Integer> visited = new HashSet<>();
      int reachableNodeCount = 0;
      while (!q.isEmpty()) {
        int[] city = q.poll();
        int source = city[0], costSoFor = city[1];
        if (costSoFor > distanceThreshold) continue;
        if (visited.contains(source)) continue;
        visited.add(source);
        reachableNodeCount++;
        Map<Integer, Integer> neighbors = adjMap.get(source);
        if (neighbors == null) continue;
        for (Map.Entry<Integer, Integer> neighborAndCost : neighbors.entrySet()) {
          int neighbor = neighborAndCost.getKey(), neighborCost = neighborAndCost.getValue();
          q.add(new int[] {neighbor, costSoFor + neighborCost});
        }
      }
      if (reachableNodeCount <= minReachableNodeCount) {
        minReachableNodeCount = reachableNodeCount;
        result = i;
      }
    }
    return result;
  }
}
