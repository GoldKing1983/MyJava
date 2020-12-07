package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
1) Pick any node randomly. Lets say we picked A. Mark it as visited and cost with 0. Then we can proceed.
2) From A. Find lowest next connected node. Lets say B & C.
3) From B and C. Find lowest next connected node.
4) Follow approach till N-1 times for unvisited nodes.

=====Prims algorithm in 1 line : Randomly pick a node. Then from there always select connected smallest cost node.=====

=======================================Implementation=======================================
1) Use Priority Queue to get the edge with least cost,
2) visited to keep nodes that are visited or nodes visited.
======================How the priority queue processes elements========
Input: N = 3, connections = [[1,2,500],[1,3,600],[2,3,100]]
Output: 600 (1-->2 and 2-->3)
								1
						  500)/   \(600)
							 2 --- 3
							  (100)

[1, 1, 0  ] --->process node1. node1 marked as visited. Node2 and node3 pushed
[1, 2, 500] --> Node2 comes at top, because it has low cost. process node2. node 2 marked as visited.
[2, 3, 100] --> Node3 comes last. node 3 marked as visited.
[3, 2, 100] --> visited already so skipped
[2, 1, 500] --> visited already so skipped
[3, 1, 600] --> visited already so skipped
[1, 3, 600] --> visited already so skipped

==============
 */
public class ConnectingCitiesWithMinimumCost {
  public int minimumCost(int nodeCount, int[][] connections) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    Set<Integer> visited = new HashSet<>();
    int costs = 0;

    for (int[] conn : connections) {
      int source = conn[0], destination = conn[1], cost = conn[2];

      graph.computeIfAbsent(source, a -> new ArrayList<>()).add(new int[] {destination, cost});
      graph.computeIfAbsent(destination, a -> new ArrayList<>()).add(new int[] {source, cost});
    }

    pQ.add(new int[] {1, 1, 0});
    while (!pQ.isEmpty()) {
      int[] conn = pQ.poll();
      int destinationNode = conn[1], cost = conn[2];

      if (!visited.contains(destinationNode)) {
        costs += cost;
        visited.add(destinationNode);
        for (int[] next : graph.get(destinationNode)) {
          pQ.add(new int[] {destinationNode, next[0], next[1]}); // if(!visited.contains(next[0]))
        }
      }
    }

    return visited.size() == nodeCount ? costs : -1;
  }
}
