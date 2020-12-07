package com.interview.leetcode.amazon.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/keys-and-rooms/

1) There are N rooms and each room has keys to other rooms.
2) Initially, all the rooms are locked (except for room 0).
3) Start from room 0. If you are able to visit all rooms. Return True Else False.

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
======================================================Solution Approach======================================================
1) Do DFS from room 0. Add the visited room to visited.
2) If the "visitedRoomSize == totalRooms" true. Else false.

 */
public class KeysAndRooms {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visited = new HashSet<>();
    visited.add(0);
    dfs(rooms, 0, visited);
    return visited.size() == rooms.size();
  }

  private void dfs(List<List<Integer>> rooms, int currentRoom, Set<Integer> visited) {
    for (Integer room : rooms.get(currentRoom)) {
      if (visited.contains(room)) continue;
      visited.add(room);
      dfs(rooms, room, visited);
    }
  }
}
