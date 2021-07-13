package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.com/problems/minimum-height-trees/

1) Given an undirected graph without cycle.
2) Find the list of nodes where if I measure the height, the height will be minimum
============================================================Example1=============================================================
  input: 1 -- 2 -- 3 -- 4 -- 5. Ans:3
  
                3         ---- height 0
               / \
              2   4       ---- height 1  
             /     \
            1       5     ---- height 2
 Here for the node 3 height is 2..
 For rest of nodes height is 3 or more...
============================================================Example2=============================================================  
  input: 1 -- 2 -- 3 -- 4 -- 5 -- 6. Ans:3,4
  
                3         ---- height 0
               / \
              2   4       ---- height 1  
             /     \
            1       5     ---- height 2
                     \
                      6   ---- height 3
 
                4         ---- height 0
               / \
              3   5       ---- height 1  
             /     \
            2       6     ---- height 2
           /
          1               ---- height 3
                         
 Here for the node 3 and 4 height is 3..
 For rest of nodes height is 4 or more...             
========================================================Solution Approach========================================================
1) Prune from leaf. Standard Topological sort.
2) input: 1 -- 2 -- 3 -- 4 -- 5 -- 6. Ans:3,4
3) 1 and 6 will be in q. Also in result.
4) 2 and 5 will be in q. Previous result cleared. current result is 2,5.
5) 3 and 4 will be in q. Previous result cleared. current result is 3,4.
6) Nothing to parse. Return result.

 
 */
public class MinimumHeightTreesTopologicalSort {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> result = new ArrayList<>();
    if (n == 0) return result;
    if (n == 1) {
      result.add(0);
      return result;
    }

    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    int[] indegree = new int[n];
    Queue<Integer> q = new LinkedList<>();

    for (int[] edge : edges) {
      adjMap.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
      adjMap.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
      indegree[edge[0]]++;
      indegree[edge[1]]++;
    }

    for (int i = 0; i < n; i++) {
      if (indegree[i] == 1) {
        q.add(i);
      }
    }

    // Push everything to result. Till last leaf.
    while (!q.isEmpty()) {
      int size = q.size();
      result = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        int curr = q.poll();
        result.add(curr);
        for (Integer x : adjMap.get(curr)) {
          indegree[x]--;
          if (indegree[x] == 1) {
            q.add(x);
          }
        }
      }
    }
    return result;
  }

}
