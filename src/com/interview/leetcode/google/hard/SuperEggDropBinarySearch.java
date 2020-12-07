package com.interview.leetcode.google.hard;

/*

https://leetcode.com/problems/super-egg-drop/
Sample - Two Eggs 100 Floors - Analysis
https://www.youtube.com/watch?v=2WtCA_uyBuw

1) You are given K eggs, and you have access to a building with N floors from 1 to N.

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break,
and any egg dropped at or below floor F will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?




 */
public class SuperEggDropBinarySearch {
  public int superEggDrop(int eggCount, int floorCount) {
    int[][] dp = new int[eggCount + 1][floorCount + 1];
    for (int i = 1; i <= floorCount; i++) {
      dp[1][i] = i;
    }
    for (int egg = 2; egg <= eggCount; egg++) {
      for (int floor = 1; floor <= floorCount; floor++) {
        int min = Integer.MAX_VALUE;
        // search for k in [1, j] to minimize number of moves
        int low = 1;
        int high = floor;
        while (low <= high) {
          int mid = low + (high - low) / 2;
          int a = dp[egg - 1][mid - 1]; // break
          int b = dp[egg][floor - mid]; // did not break
          min = Math.min(min, Math.max(dp[egg - 1][mid - 1], dp[egg][floor - mid]) + 1);
          if (a == b) {
            break;
          } else if (a < b) {
            low = mid + 1;
          } else {
            high = mid - 1;
          }
        }
        dp[egg][floor] = min;
      }
    }
    return dp[eggCount][floorCount];
  }
}
