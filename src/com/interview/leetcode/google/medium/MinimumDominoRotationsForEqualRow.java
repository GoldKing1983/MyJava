package com.interview.leetcode.google.medium;

import java.util.stream.IntStream;

/*
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

1) In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
2) We may rotate the i-th domino, so that A[i] and B[i] swap values.
3) Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
4) If it cannot be done, return -1.

See image for requirement "SwapDomino.png"
Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2] Output: 2

Explanation:  The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

=================================================Solution Approach======================================================================
See video https://www.youtube.com/watch?v=9Q73ScVu2GI
 */
public class MinimumDominoRotationsForEqualRow {
  public int minDominoRotations(int[] openSide, int[] oppositeSide) {
    int swap1 = findMin(openSide[0], openSide, oppositeSide);
    int swap2 = findMin(openSide[0], oppositeSide, openSide);
    int swap3 = findMin(oppositeSide[0], openSide, oppositeSide);
    int swap4 = findMin(oppositeSide[0], oppositeSide, openSide);
    int min = IntStream.of(swap1, swap2, swap3, swap4).min().getAsInt();
    return Integer.MAX_VALUE == min ? -1 : min;
  }

  private int findMin(int target, int[] openSide, int[] oppositeSide) {
    int flipCount = 0;
    for (int i = 0; i < openSide.length; i++) {
      if (openSide[i] == target) {
        // no operation needed. i.e already openSide has the target
        continue;
      }
      // flip needed from oppositeSide.
      if (oppositeSide[i] == target) { // flip matches the target
        flipCount++;
      } else { // flip didn't match. No way it can match.
        return Integer.MAX_VALUE;
      }
    }
    return flipCount;
  }
}
