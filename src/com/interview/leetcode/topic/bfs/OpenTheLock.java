package com.interview.leetcode.topic.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/problems/open-the-lock/

Requirement:
1) We have lock with 4 circular wheels.
2) Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
3) The wheels can rotate freely "up" or "down". For example we can turn '9' to be '0', or '0' to be '9'.
4) The lock initially starts at '0000'.
5) For a given target, find minimum step to reach the target.
6) Condition: If any of "dead-ends" found, during a step, then that path should be ignored.
7) See picture "OpenTheLock.jpg" for understanding.
=======================================High Level Thinking==================================================================
1) We can think of this problem as a shortest path problem on a graph: there are '10000' nodes('0000' to '9999').
2) All nodes are interconnected. Ex: 0000 connected to 8 nodes(0001,0010,0100,1000,0009,0090,0900,9000),
subsequently the remaining nodes are connected too.
level1 Connected Nodes: 1*8  = 8  (8 nodes in q)
level2 Connected Nodes: 8*8  = 64 (64 nodes in q)
level3 Connected Nodes: 64*8 = 512(512 nodes in q)
3) A connection is broken, if it appears in dead-ends. Ex: [1000,9000] are dead-ends.
Then 0000 connected to only 6 nodes (0100,0900,0010,0090,0001,0009).
=======================================Solution Approach==================================================================
1) Start with "0000".
2) Generate 8 combination for each number.
	2a) Pick number at index 0. Increment. Form next number.
	2a) Pick number at index 0. Decrement. Form previous number.
	2a) Pick number at index 1. Increment. Form next number.
	2a) Pick number at index 1. Decrement. Form previous number.
	2a) Pick number at index 2. Increment. Form next number.
	2a) Pick number at index 2. Decrement. Form previous number.
	2a) Pick number at index 3. Increment. Form next number.
	2a) Pick number at index 4. Decrement. Form previous number.
3) Push all the 8 new combination to queue.
4) If a combination is "not visited" and not in "inValidCombo". Generate Combo.
5) At any-point if target is found return.
======================================Combination Generation for 0000 and 1000====================================================================================
0000 at index 0 Incremented to 1000
0000 at index 0 Decremented to 9000
0000 at index 1 Incremented to 0100
0000 at index 1 Decremented to 0900
0000 at index 2 Incremented to 0010
0000 at index 2 Decremented to 0090
0000 at index 3 Incremented to 0001
0000 at index 3 Decremented to 0009
Queue Data: [1000, 9000, 0100, 0900, 0010, 0090, 0001, 0009]
==========
1000 at index 0 Incremented to 2000
1000 at index 0 Decremented to 0000
1000 at index 1 Incremented to 1100
1000 at index 1 Decremented to 1900
1000 at index 2 Incremented to 1010
1000 at index 2 Decremented to 1090
1000 at index 3 Incremented to 1001
1000 at index 3 Decremented to 1009
Queue Data: [9000, 0100, 0900, 0010, 0090, 0001, 0009, 2000, 0000, 1100, 1900, 1010, 1090, 1001, 1009]
==========

 */
public class OpenTheLock {
  public int openLock(String[] deadends, String target) {
    Set<String> inValidCombo = new HashSet<>(Arrays.asList(deadends));
    Set<String> visited = new HashSet<>();
    if (inValidCombo.contains("0000")) return -1;
    visited.add("0000");

    return bfs(inValidCombo, visited, target);
  }

  private int bfs(Set<String> inValidCombo, Set<String> visited, String target) {
    int level = 0;

    Queue<String> q = new LinkedList<>();
    q.offer("0000");

    while (!q.isEmpty()) {
      int size = q.size();
      for (int j = 0; j < size; j++) {
        String currentCombo = q.poll();
        if (currentCombo.equals(target)) return level;
        for (int i = 0; i < 4; i++) {
          char c = currentCombo.charAt(i);

          char nextNumber = c == '9' ? '0' : (char) (c + 1);
          StringBuilder incrementComboSB = new StringBuilder(currentCombo);
          incrementComboSB.setCharAt(i, nextNumber);
          String incrementCombo = incrementComboSB.toString();
          if (!visited.contains(incrementCombo) && !inValidCombo.contains(incrementCombo)) {
            visited.add(incrementCombo);
            q.offer(incrementCombo);
          }

          char previousNumber = c == '0' ? '9' : (char) (c - 1);
          StringBuilder decrementComboSB = new StringBuilder(currentCombo);
          decrementComboSB.setCharAt(i, previousNumber);
          String decrementCombo = decrementComboSB.toString();
          if (!visited.contains(decrementCombo) && !inValidCombo.contains(decrementCombo)) {
            visited.add(decrementCombo);
            q.offer(decrementCombo);
          }
        }
      }
      level++;
    }
    return -1;
  }
}
