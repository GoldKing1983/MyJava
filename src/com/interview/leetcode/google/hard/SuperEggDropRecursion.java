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

===========================================Solution Approach===========================================
brute force - consider all possible combinations.
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from ‘xth’ floor, then we only need to check for floors lower than ‘x’
with remaining eggs as some floor should exist lower than ‘x’ in which egg would not break; so the problem
reduces to x-1 floors and n-1 eggs.
2) If the egg doesn’t break after dropping from the ‘xth’ floor, then we only need to check for floors higher than ‘x’;
so the problem reduces to ‘k-x’ floors and n eggs.

=======Time Complexity O(K*N^2)==>
						K   "for loop".
						N^2 "binary recursion".


 */
public class SuperEggDropRecursion {
  public int superEggDrop(int K, int N) {
    return helper(K, N);
  }

  private int helper(int eggsCount, int floorsCount) {
    if (floorsCount <= 1) return floorsCount;

    if (eggsCount == 1) return floorsCount;

    int min = floorsCount;
    for (int floors = 1; floors <= floorsCount; floors++) {

      int left = helper(eggsCount - 1, floors - 1); // Egg Breaks
      int right = helper(eggsCount, floorsCount - floors); // Egg don't Breaks
      min = Math.min(min, Math.max(left, right) + 1);
    }
    return min;
  }
}
