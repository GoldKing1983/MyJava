package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/number-of-islands/

================================================Solution Approach - UnionFind====================================================
1) Convert the matrix to flat array for "nodes grouping". Ex: for 3*3 matrix, there would be 9 nodes.
2) For each of island present in matrix. Try grouping the island to 2 adjacent sides. 4 sides not needed. 
So for each Island a loop runs 2 times(right and down). Whereas in case of DFSCode we m*n grid times will update recursively.
2a) When placing isLand increment numberOfIslands.
2b) When grouping isLand in 2 direction, if it is grouped already to "sourceNodeGroup", no operation needed.
                                         else decrement isLandCount and Update "targetNodeGroup" to "sourceNodeGroup"

Note: CurrentIslandLocation is sourceNodeGroup, 2AdjacentLocation is nextNodeGroup.


==================================================Data Flow Analysis==============================================================================

Input:
[["1","1"],
 ["1","1"]]


initial: numberOfIslands:0. root:[0, 1, 2, 3]

row=0, col=0
source 0,0: numberOfIslands:1. root:[0, 1, 2, 3]
right  0,1: numberOfIslands:0. root:[0, 0, 2, 3]
down   1,0: numberOfIslands:-1. root:[0, 0, 0, 3]

row=0, col=1
source 0,1: numberOfIslands:0. root:[0, 0, 0, 3]
down   1,1:numberOfIslands:-1. root:[0, 0, 0, 0]

row=1, col=0
source 1,0: numberOfIslands:0. root:[0, 0, 0, 0]
right  1,1: sourceNodeGroup and nextNodeGroup same so no update on root.

row=1, col=1
source : numberOfIslands:1. root:[0, 0, 0, 0]





*/
public class NumberOfIslandsUnionFind {

  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {-1, 0}};

  public int numIslands(char[][] grid) {
    int maxRow = grid.length, maxCol = grid[0].length;
    int n = maxRow * maxCol;
    int[] root = new int[n];
    for (int i = 0; i < root.length; i++) root[i] = i;
    int numberOfIslands = 0;

    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (grid[row][col] == '0') continue;

        int sourceNodeId = row * maxCol + col;
        int sourceNodeGroup = find(root, sourceNodeId);

        numberOfIslands++;
        for (int[] dir : DIRECTIONS) {
          int nextRow = dir[0] + row;
          int nextCol = dir[1] + col;

          if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
          if (grid[nextRow][nextCol] == '0') continue;

          int nextNode = nextRow * maxCol + nextCol;
          int nextNodeGroup = find(root, nextNode);

          if (sourceNodeGroup == nextNodeGroup) continue;// sourceNode and nextNodeGroup are already in the same group. So no operation needed.

          root[nextNodeGroup] = sourceNodeGroup; // Update nextNodeGroup to sourceNodeGroup or union it.
          numberOfIslands--;
        }

      }
    }
    return numberOfIslands;
  }

  public int find(int[] root, int id) {
    while (true) {
      //root[id] = root[root[id]]; // path compression
      if (id == root[id]) return id;
      id = root[id];
    }
  }
}
