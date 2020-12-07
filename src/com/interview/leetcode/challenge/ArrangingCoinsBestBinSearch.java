package com.interview.leetcode.challenge;

/*
https://leetcode.com/problems/arranging-coins/
================================================Time Complexity==================================================================
1) You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
2) Given n, find the total number of full staircase rows that can be formed.
3) n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1: n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤
Because the 3rd row is incomplete, we return 2.

Example 2: n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
=================================================Solution Approach - O(log(n))===================================================
1) steps can be derived from formula  numberOfSteps = n*(n+1/2);
2) if n=15. Then answer is = 5.
	5* (5+1/2)...5*(3/2)=15... 1 2 3 4 5
3) Between low and high, get n (which is mid).
4) if nIntoNPlusOneByTwo == target, then found exact number of steps.
5) if nIntoNPlusOneByTwo > target go left. Note: This makes high to stay in "correctAnswer". So returning high in base condition.
6) else go right.
==========================================BinarySearch is best - Reasoning========================================================
1) If target=2000. Output: 62. Bin-Search algorithm will take 12 steps.
2) If target=2000. Output: 62. ArrangingCoinsAlternate will take 62 steps(which is the answer)
3) ArrangingCoinsFormulaApproach is still O(log(n)). Still "Bin-Search algorithm" is better rather than deriving the formula.
 */
public class ArrangingCoinsBestBinSearch {
  public int arrangeCoins(int n) {
    return binSearch(n, 0, n);
  }

  private int binSearch(int target, int low, int high) {
    if (low > high) return high;
    // n is also mid which falls between low and high
    long n = (long) low + (high - low) / 2;
    long nIntoNPlusOneByTwo = n * (n + 1) / 2;
    if (nIntoNPlusOneByTwo == target) return (int) n;
    if (nIntoNPlusOneByTwo > target) return binSearch(target, low, (int) n - 1);
    return binSearch(target, (int) n + 1, high);
  }
}
