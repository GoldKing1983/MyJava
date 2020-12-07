package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/stone-game-ii/

https://www.youtube.com/watch?v=KU9Ch59-4vw

We will use the minimax algorithm of game theory.

Regardless of who the player is, we want the function call to only return Alex's score.
From Lee's point it is about stealing the number and minimizing.

So, we'll keep a turn variable isAlex to keep track of whose turn it is.
So if we're Alex, we'll return the maximum of the set:
(stones grabbed this turn + recurse on Lee's turn starting at the next index from what we grabbed).

If we're Lee, we will return the minumum of (recurse on Alex's turn starting at the next index from what we grabbed).

The size of these sets will be--assuming we're not at the end of the array--2m, since one can try grabbing 2m stones at a turn.

Memoize it all into a n * n * 2 DP array.

 */
public class StoneGameII {

  public int stoneGameII(int[] piles) {
    return recur(piles, 0, 1, true);
  }

  private int recur(int[] piles, int pileIndex, int move, boolean isAlex) {
    if (pileIndex >= piles.length) return 0;

    int maxScore = isAlex ? Integer.MIN_VALUE : Integer.MAX_VALUE;

    int currSum = 0;
    int currentMaximumMove = pileIndex + 2 * move;

    for (int currentPileIndex = pileIndex;
        currentPileIndex < piles.length && currentPileIndex < currentMaximumMove;
        currentPileIndex++) {

      currSum += piles[currentPileIndex];

      int nextMaximumMove = Math.max(currentPileIndex - pileIndex + 1, move);
      int next = recur(piles, currentPileIndex + 1, nextMaximumMove, !isAlex);

      if (isAlex) maxScore = Math.max(maxScore, currSum + next);
      else maxScore = Math.min(maxScore, next);
    }

    return maxScore;
  }
}
