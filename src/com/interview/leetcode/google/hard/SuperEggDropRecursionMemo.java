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
public class SuperEggDropRecursionMemo {
  public int superEggDrop(int K, int N) {
    int[][] memo = new int[K + 1][N + 1];
    return helper(K, N, memo);
  }

  private int helper(int eggsCount, int floorsCount, int[][] memo) {
    if (floorsCount <= 1) {
      return floorsCount;
    }
    if (eggsCount == 1) {
      return floorsCount;
    }
    if (memo[eggsCount][floorsCount] > 0) {
      return memo[eggsCount][floorsCount];
    }
    int min = floorsCount;
    for (int floors = 1; floors <= floorsCount; floors++) {
      int left = helper(eggsCount - 1, floors - 1, memo); 
      int right = helper(eggsCount, floorsCount - floors, memo);
      min = Math.min(min, Math.max(left, right) + 1);
    }
    memo[eggsCount][floorsCount] = min;
    return min;
  }
}
