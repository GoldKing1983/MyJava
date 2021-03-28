package com.interview.leetcode.topic.graph;

import java.util.*;

/*
https://leetcode.com/problems/connecting-cities-with-minimum-cost/
Problem mapped to Graph Theory - MST(MinimumCostSpanningTree) - Any Source Shortest path - bidirectional(undirected) traversal
====================================================Requirement====================================================
There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.
(A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

Return the minimum cost so that for every pair of cities, there exists a path of connections
(possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used.
If the task is impossible, return -1.

Input: N = 3, connections = [[1,2,500],[1,3,600],[2,3,100]]
Output: 600 (1-->2 and 2-->3)
								1
						  500)/   \(600)
							 2 --- 3
							  (100)

===========================Solution Approach using Prims(Greedy) Algorithm ===========================
1) Pick any node randomly. Lets say we picked node1. Mark it as visited and add all it neighbors to PriorityQueue.
2) From node1. Find lowest next connected node. Lets say node2 & node3.
3) From node2 and node3. Find lowest next connected node.
4) Follow approach till N-1 times for unvisited nodes.

=====Prims algorithm in 1 line :Randomly pick a node. From there greedily select connected smallest cost node.=====
This works, because we need to traverse "all node", so greedily picking "less cost" neighbor always works.
======================How the priority queue processes elements========
Input: N = 3, connections = [[1,2,500],[1,3,600],[2,3,100]]
Output: 600 (1-->2 and 2-->3)
								1
						  500)/   \(600)
							 2 --- 3
							  (100)

 adjMap =
    1->[2 500], [3 600]
    2->[1 500], [3,100]
    3->[1 600], [2,100]

    Lets say random picked 1 as source... Add 1s neighbor to pQ
    pQ = [2 500], [3 600]

    [2 500] is the lowest. So it is polled
    pQ = [3 600]
    So now source is 2... Add 2s neighbor to pQ
    pQ = [3 600], [1 500], [3,100]

    [3 100] is the lowest. So it is polled.

==============
 */
public class ConnectingCitiesWithMinimumCost {
  // source->[neighbor,travelCost]
  Map<Integer, List<Map.Entry<Integer, Integer>>> adjMap = new HashMap<>();
  PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
  Set<Integer> visited = new HashSet<>();

  private void buildAdjMap(int[][] connections) {
    for (int[] conn : connections) {
      int source = conn[0], destination = conn[1], cost = conn[2];
      adjMap
          .computeIfAbsent(source, a -> new ArrayList<>())
          .add(new AbstractMap.SimpleEntry<>(destination, cost));
      adjMap
          .computeIfAbsent(destination, a -> new ArrayList<>())
          .add(new AbstractMap.SimpleEntry<>(source, cost));
    }
  }

  private int doBFS(int nodeCount) {
    int costs = 0;
    while (!pQ.isEmpty()) {
      int[] conn = pQ.poll();
      int destinationNode = conn[0], cost = conn[1];

      if (visited.contains(destinationNode)) continue;
      costs += cost;
      visited.add(destinationNode);
      if (visited.size() == nodeCount) return costs;
      for (Map.Entry<Integer, Integer> entry : adjMap.get(destinationNode)) {
        pQ.add(new int[] {entry.getKey(), entry.getValue()});
      }
    }
    return -1;
  }

  public int minimumCost(int nodeCount, int[][] connections) {

    buildAdjMap(connections);

    int sourceNode = new Random().nextInt(nodeCount) + 1;
    // If any node is hanging or no neighbors return -1 immediately
    if (!adjMap.containsKey(sourceNode)) return -1;
    for (Map.Entry<Integer, Integer> entry : adjMap.get(sourceNode)) {
      pQ.add(new int[] {entry.getKey(), entry.getValue()});
    }
    visited.add(sourceNode);

    return doBFS(nodeCount);
  }
}
