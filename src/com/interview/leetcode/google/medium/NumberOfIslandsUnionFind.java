package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/number-of-islands/

================================================Solution Approach - UnionFind====================================================
1) Convert the matrix to flat array for "nodes grouping". Ex: for 3*3 matrix, there would be 9 nodes.
2) For each of island present in matrix. Try grouping the island to 4 adjacent sides.
So for each Island a loop runs 4 times. Whereas in case of DFSCode we m*n times will update grid recursively.
2a) When placing isLand increment numberOfIslands.
2b) When grouping isLand in 4 direction, if it is grouped already to "sourceNodeGroup", no operation needed.
									  	 else decrement isLandCount and Update "targetNodeGroup" to "sourceNodeGroup"

Note: CurrentIslandLocation is sourceNodeGroup, 4AdjacentLocation is targetNodeGroup.
==================================================Data Flow Analysis=============================================================
Input:
[["1","1"],
 ["1","1"]]

nodes = [-1, -1, -1, -1]

After traversing 0,0
nodes = [0, -1, -1, -1]

After traversing 0,1
nodes = [0, 1, -1, -1]
nodes = [1, 1, -1, -1]

After traversing 1,0
nodes = [1, 1, 2, -1]
nodes = [1, 2, 2, -1]

After traversing 1,1
nodes = [1, 2, 2, 3]
nodes = [1, 2, 3, 3]
nodes = [1, 3, 3, 3]




*/
public class NumberOfIslandsUnionFind {

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
            nodes[targetNodeGroup] = sourceNodeGroup;
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
