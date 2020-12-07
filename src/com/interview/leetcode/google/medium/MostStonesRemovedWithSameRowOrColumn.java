package com.interview.leetcode.google.medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)

Requirement:
1) On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
2) Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
3) What is the largest possible number of moves we can make?

input: [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]] Output: 5

 6  ||
 5  ||
 4  ||
 3  ||
 2  ||     x   x
 1  || x       x
 0  || x   x
    || =================================
       0 . 1 . 2 . 3 . 4 . 5 . 6

There are multiple path available to come up with 5. Below is 1 sequence.
       (0,1) -> (0,0) -> (1,0) -> (1,2) -> (2,2) -> (2,1)


Either x or y co-ordinates should be same. So (0,0) -> (1,2) cannot be connected
Another point : we cannot move from last(2,1) to first(0,1). Because whenever move happens, that stone is removed.

=========================================================================================================================

				  x
			x     x
				  x

==========================Solution Approach==============================================================================
This belongs to "InterviewDeduceRequirement". Problem converted to "NumberOfIslands".

1) Think of the problem as "number of island" problem.
2) Here the island is connected, if the "x" or "y" co-ordinate is same.
3) Ans = # of stones – # of islands
4) Note: We are not forming, adjMatrix to do DFS neighbor visits, everyTime input stones are traversed, against
"not visited" stones.
 */
public class MostStonesRemovedWithSameRowOrColumn {
  public int removeStones(int[][] stones) {
    Set<int[]> visited = new HashSet<>();
    int numOfIslands = 0;
    for (int[] s1 : stones) {
      if (!visited.contains(s1)) {
        dfs(s1, visited, stones);
        numOfIslands++;
      }
    }
    return stones.length - numOfIslands;
  }

  private void dfs(int[] stone, Set<int[]> visited, int[][] stones) {
    visited.add(stone);
    for (int[] s2 : stones) {
      if (!visited.contains(s2)) {
        // stone with same row or column. group them into island
        if (stone[0] == s2[0] || stone[1] == s2[1]) dfs(s2, visited, stones);
      }
    }
  }
}
