package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/number-of-islands/

================================================Solution Approach - UnionFind==================================================================
Same as NumberOfIslandsUnionFind. Here updating each node to sourceNodeGroup, instead of targetNodeGroup.
==================================================Data Flow Analysis==============================================================================
Input:
[["1","1"],
 ["1","1"]]

nodes = [-1, -1, -1, -1]

After traversing 0,0
nodes = [0, -1, -1, -1]

After traversing 0,1
nodes = [0, 1, -1, -1]
nodes = [0, 0, -1, -1]

After traversing 1,0
nodes = [0, 0, 2, -1]
nodes = [0, 0, 0, -1]

After traversing 1,1
nodes = [0, 0, 0, 3]
nodes = [0, 0, 0, 0]




*/
public class NumberOfIslandsUnionFind2 {

  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int maxRow = grid.length, maxCol = grid[0].length;
    int[] nodes = new int[maxRow * maxCol];
    Arrays.fill(nodes, -1);
    int numberOfIslands = 0;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (grid[row][col] == '1') {
          int sourceNodeGroup = row * maxCol + col;
          nodes[sourceNodeGroup] = sourceNodeGroup; // change -1 to current nodeId
          numberOfIslands++;
          for (int[] dir : DIRECTIONS) {
            int nextRow = dir[0] + row;
            int nextCol = dir[1] + col;
            if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol) continue;

            int nextNode = nextRow * maxCol + nextCol;
            if (nodes[nextNode] == -1) continue;

            int targetNodeGroup = find(nodes, nextNode);
            // sourceNode and targetNode are already in the same group. So no operation needed.
            if (sourceNodeGroup == targetNodeGroup) continue;

            // Update targetNodeGroup to sourceNodeGroup or union it.
            nodes[sourceNodeGroup] = targetNodeGroup;
            sourceNodeGroup = targetNodeGroup;
            numberOfIslands--;
          }
        }
      }
    }
    return numberOfIslands;
  }

  public int find(int[] nodes, int id) {
    while (id != nodes[id]) {
      nodes[id] = nodes[nodes[id]]; // path compression
      id = nodes[id];
    }
    return id;
  }
}
