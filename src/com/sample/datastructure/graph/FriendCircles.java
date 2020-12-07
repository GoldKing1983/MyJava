package com.sample.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/friend-circles/description/

1) Fill the AdjMatrix List
2) If entry is not visited. DFS all the connected list and set visited True.

Note: Forming adjMatrix is list not needed as the matrix already has that.
See solution FriendsCircles_Efficient, similar to island problem
==============================================Data Flow Analysis==================================================================
Ex:
[[1,1,0],
 [1,1,1],
 [0,1,1]]

{0=[0, 1], 1=[0, 1, 2], 2=[1, 2]}

1) Main function increments friendsCircleCount and calls DFS with List[0,1]
2) 0 is visited already. So skipped.
3) for 1. its friends called with [0,1,2]. Both 0 and 1 are already visited. So 2 is called.
4) for 2. its friends called with[1,2] is called. Both 0 and 1 are already visited. So returned.
5)====
6) All rows are visited in MainFunction. So MainFunction returns friendsCircleCount=1.


 */
public class FriendCircles {

  public int findCircleNum(int[][] matrix) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (matrix[row][col] == 1) map.computeIfAbsent(row, (key) -> new ArrayList<>()).add(col);
      }
    }

    boolean[] isVisited = new boolean[matrix.length];
    int friendCircle = 0;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      if (!isVisited[entry.getKey()]) {
        friendCircle++;
        dfs(isVisited, entry.getValue(), map);
      }
    }
    return friendCircle;
  }

  public void dfs(boolean isVisited[], List<Integer> friends, Map<Integer, List<Integer>> map) {
    for (Integer cyclicFriends : friends) {
      if (!isVisited[cyclicFriends]) {
        isVisited[cyclicFriends] = true;
        dfs(isVisited, map.get(cyclicFriends), map);
      }
    }
  }
}
