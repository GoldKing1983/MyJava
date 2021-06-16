package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/possible-bipartition/
Refer PossibleBipartitionDFS
===================================================================================================================
 */
public class PossibleBipartitionBFS {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    Boolean[] color = new Boolean[n + 1];
    List<List<Integer>> adjList = new ArrayList<>(n + 1);
    for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
    for (int[] d : dislikes) { // Directional Graph. So initialize both ways.
      adjList.get(d[0]).add(d[1]);
      adjList.get(d[1]).add(d[0]);
    }

    for (int i = 1; i <= n; i++) {
      if (color[i] != null) continue; // color assigned already. No need to traverse
      color[i] = true; // Eagerly assign color1.
      Queue<Integer> q = new LinkedList<>();
      q.add(i);
      while (!q.isEmpty()) {
        int parent = q.poll();
        for (int children : adjList.get(parent)) {
          if (color[children] == null) {
            color[children] = !color[parent]; // Assign neighbor with opposite of parent.
            q.add(children);
          } else {
            if (color[children].equals(color[parent])) return false;
          }
        }
      }
    }
    return true;
  }
}
