package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/guess-number-higher-or-lower-ii/

We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
Given a particular n ≥ 1, find out how much minimum needed for guaranteed win.

Example:
n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Above is not an optimal minimum money. Optimal minimum for a guaranteed win is 16.


Similar to EggDrop Problem, binary search is not a solution.

======================================================================High Level Idea===============================================
Firstly, we should note that choosing mid is not always the best strategy. Becuase of the "penalty" on each guess.
For exmple [1,2,3,4,5], with mid strategy we pay $3+$4 = $7 in the worst case (i.e target=5).
But we can do it in $2+$4=$6 for all possible targets.

So our goal is try all possible guesses at every stage and choose the minimum. But remember every time we guess,
we are diving the search space, [i..j], into two parts, the target could be anywhere (obvioulsy except our current guess).
So we solve each part with the assumption that target could be anywhere and see the cost at each possible k in [i..j].
We take the max cost out of two parts because target could be anywhere and we need to cover the cost for that. (i.e.
If we take minimum say that is from left part, what if the target is in right part).



 */
public class GuessNumberHigherOrLowerIIMiniMax {
  int[][] dp;

  public int getMoneyAmount(int n) {
    dp = new int[n + 1][n + 1];
    return getMoneyAmount(1, n);
  }

  private int getMoneyAmount(int lower, int upper) {
    if (lower >= upper) return 0;

    if (dp[lower][upper] != 0) return dp[lower][upper];

    int maxPay = Integer.MAX_VALUE;
    for (int amountToPay = lower; amountToPay <= upper; amountToPay++) {
      int leftPay = getMoneyAmount(lower, amountToPay - 1) + amountToPay;
      int rightPay = getMoneyAmount(amountToPay + 1, upper) + amountToPay;
      int currentMaxPay = Math.max(leftPay, rightPay);

      maxPay = Math.min(maxPay, currentMaxPay);
    }
    dp[lower][upper] = maxPay;

    return maxPay;
  }
}
