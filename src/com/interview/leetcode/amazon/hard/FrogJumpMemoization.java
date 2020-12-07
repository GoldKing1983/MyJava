package com.interview.leetcode.amazon.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/frog-jump/

================================================================================================
input: [0,1,3,4,5,7,9,10,12]
output: true

currentPosition: 0 NextPosition: 1  jumpDistance: 1
currentPosition: 1 NextPosition: 2  jumpDistance: 1
currentPosition: 1 NextPosition: 3  jumpDistance: 2
currentPosition: 3 NextPosition: 4  jumpDistance: 1
currentPosition: 3 NextPosition: 5  jumpDistance: 2
currentPosition: 3 NextPosition: 6  jumpDistance: 3
currentPosition: 5 NextPosition: 6  jumpDistance: 1
currentPosition: 5 NextPosition: 7  jumpDistance: 2
currentPosition: 5 NextPosition: 8  jumpDistance: 3
currentPosition: 7 NextPosition: 8  jumpDistance: 1
currentPosition: 7 NextPosition: 9  jumpDistance: 2
currentPosition: 7 NextPosition: 10 jumpDistance: 3


================================================================================================
input: [0,1,3,5,6,8,12,17]
output: true

currentPosition:  0 NextPosition: 1  jumpDistance: 1
currentPosition:  1 NextPosition: 2  jumpDistance: 1
currentPosition:  1 NextPosition: 3  jumpDistance: 2
currentPosition:  3 NextPosition: 4  jumpDistance: 1
currentPosition:  3 NextPosition: 5  jumpDistance: 2
currentPosition:  3 NextPosition: 6  jumpDistance: 3
currentPosition:  6 NextPosition: 8  jumpDistance: 2
currentPosition:  6 NextPosition: 9  jumpDistance: 3
currentPosition:  6 NextPosition: 10 jumpDistance: 4
currentPosition:  8 NextPosition: 9  jumpDistance: 1
currentPosition:  8 NextPosition: 10 jumpDistance: 2
currentPosition:  8 NextPosition: 11 jumpDistance: 3
currentPosition:  5 NextPosition: 6  jumpDistance: 1
currentPosition:  5 NextPosition: 7  jumpDistance: 2
currentPosition:  5 NextPosition: 8  jumpDistance: 3
currentPosition:  8 NextPosition: 10 jumpDistance: 2 ==> skipped
currentPosition:  8 NextPosition: 11 jumpDistance: 3 ==> skipped
currentPosition:  8 NextPosition: 12 jumpDistance: 4 ==> not skipped
currentPosition: 12 NextPosition: 15 jumpDistance: 3
currentPosition: 12 NextPosition: 16 jumpDistance: 4

================================================================================================
 */
public class FrogJumpMemoization {
  public boolean canCross(int[] stones) {
    HashSet<Integer> stoneSet = new HashSet<>();
    for (int i : stones) stoneSet.add(i);
    int lastStone = stones[stones.length - 1];
    Deque<int[]> stack = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    stack.push(new int[] {0, 0});
    while (!stack.isEmpty()) {
      int[] cur = stack.pop();
      int curPos = cur[0];
      int jumpDistance = cur[1];
      for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {

        if (i <= 0) continue;
        int nextPos = curPos + i;
        if (visited.contains(i + " " + nextPos)) continue;
        visited.add(i + " " + nextPos);
        if (nextPos == lastStone) return true;
        if (stoneSet.contains(nextPos)) stack.push(new int[] {nextPos, i});
      }
    }
    return false;
  }

  public static void main(String[] args) {
    new FrogJumpMemoization().canCross(new int[] {0, 1, 2, 3, 4, 8, 9, 11});
  }
}
