package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/number-of-islands-ii/

================================================Solution Approach - UnionFind====================================================
1) Convert the matrix to flat array for "nodes grouping". Ex: for 3*3 matrix, there would be 9 nodes.
2) For each of island placed in matrix. Try grouping the island to 4 adjacent sides.
So for each Island a loop runs 4 times. Whereas in case of DFSCode we m*n times loop will run, which is un-necessary.
2a) When placing isLand increment isLandCount.
2b) When grouping isLand in 4 direction, if it is grouped already to "sourceNodeGroup", no operation needed.
									  	 else decrement isLandCount and Update "targetNodeGroup" to "sourceNodeGroup"

Note: CurrentIslandLocation is sourceNodeGroup, 4AdjacentLocation is targetNodeGroup.
=================================================================================================================================
This problem can be solved only with "UnionFind". Because of grouping is needed in island.

Exmaple1: Currently "numberOfLand" = 4
				0	1	0
				1	0	1
				0	1	0
placing a isLand at position "1,0" will update "numberOfIsLand" from 4 to 1

Exmaple2: Currently "numberOfLand" = 1
				1	1	1
				1	0	1
				1	1	1
placing a isLand at position "1,0" will still hold "numberOfIsLand" to 1


================================================why visited logic================================================================
3
3
[[0,0],[0,1],[1,2],[1,2]]
Output
[1,1,2,3]
Expected
[1,1,2,2]

If the same node comes again return previous island count .
=================================================================================================================================
3
3
[[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]]

Wrong Output: [1,2,3,4,3,2,-1]. If I simply update 4 sides, if 4 sides are 1. Then output will be wrong see "NumberOfIslandsIIDFS"
Right Output: [1,2,3,4,3,2,1]


[-1, 1, -1,
-1, -1, -1,
-1, -1, -1]

[-1, 1, -1,
-1, -1, 5,
-1, -1, -1]

[-1, 1, -1,
-1, -1, 5,
-1, 7, -1]

[-1, 1, -1,
3, -1, 5,
-1, 7, -1]


================
0 1 0
1 0 1
0 1 0

After placing 0,2 ==> [0,1][0,2][1,2] are grouped
0 1 1
1 0 1
0 1 0

[-1,  2,  2,
  3, -1,  2,
 -1,  7, -1]
====================
0 1 1
1 0 1
0 1 0

After placing 0,0 ==> [0,0][0,1][1,0] are grouped
1 1 1
1 0 1
0 1 0

[0, 2, 0,
0, -1, 2,
-1, 7, -1]
====================
1 1 1
1 0 1
0 1 0

After placing 1,1 ==> [0,1][1,0][1,1][1,2][2,1] are grouped

1 1 1
1 1 1
0 1 0


[4,  0,  0,
 4,  4,  0,
-1,  4, -1]




 */
public class NumberOfIslandsII {
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public List<Integer> numIslands2(int maxRow, int maxCol, int[][] positions) {
    List<Integer> result = new ArrayList<>();
    if (maxRow <= 0 || maxCol <= 0) return result;

    int numberOfIslands = 0;
    // flatten the grid matrix to array for Union-Find Traversal
    int[] nodes = new int[maxRow * maxCol];
    Arrays.fill(nodes, -1);
    boolean[][] visited = new boolean[maxRow][maxCol];
    for (int[] position : positions) {
      int currentRow = position[0];
      int currentCol = position[1];
      if (visited[currentRow][currentCol]) {
        result.add(numberOfIslands);
        continue;
      }
      visited[currentRow][currentCol] = true;
      // converted "position of island" in flat array
      int sourceNodeGroup = maxCol * currentRow + currentCol;
      nodes[sourceNodeGroup] = sourceNodeGroup; // change -1 to current nodeId
      numberOfIslands++;

      for (int[] dir : DIRECTIONS) {
        int nextRow = currentRow + dir[0];
        int nextCol = currentCol + dir[1];
        if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol) continue;

        int nextNode = maxCol * nextRow + nextCol;
        if (nodes[nextNode] == -1) continue;

        int targetNodeGroup = find(nodes, nextNode);
        // sourceNode and targetNode are already in the same group. So no operation needed.
        if (sourceNodeGroup == targetNodeGroup) continue;

        // Update targetNodeGroup to sourceNodeGroup or union it. Note: Reversing will not work
        nodes[targetNodeGroup] = sourceNodeGroup;

        numberOfIslands--;
      }

      result.add(numberOfIslands);
    }
    return result;
  }

  public int find(int[] roots, int id) {
    while (id != roots[id]) {
      roots[id] = roots[roots[id]]; // path compression
      id = roots[id];
    }
    return id;
  }
}
