package com.interview.leetcode.google.medium;

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
  public boolean possibleBipartition(int N, int[][] dislikes) {
    int[] color = new int[N + 1];
    List<List<Integer>> adjList = new ArrayList<>(N + 1);
    for (int i = 0; i <= N; i++) adjList.add(new ArrayList<Integer>());
    for (int[] d : dislikes) { // Directional Graph. So initialize both ways.
      adjList.get(d[0]).add(d[1]);
      adjList.get(d[1]).add(d[0]);
    }

    for (int i = 1; i <= N; i++) {
      if (color[i] != 0) continue; // color assigned already. No need to traverse
      color[i] = 1; // Eagerly assign color1.
      Queue<Integer> q = new LinkedList<>();
      q.add(i);
      while (!q.isEmpty()) {
        int parent = q.poll();
        for (int children : adjList.get(parent)) {
          if (color[children] == 0) {
            color[children] = color[parent] == 1 ? 2 : 1; // Assign neighbor with color2.
            q.add(children);
          } else {
            if (color[children] == color[parent]) return false;
          }
        }
      }
    }
    return true;
  }
}
