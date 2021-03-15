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
  public int minDominoRotations(int[] A, int[] B) {
    int minRotation = Integer.MAX_VALUE;
    minRotation = Math.min(minRotation, noOfRotation(A[0], A, B));
    minRotation = Math.min(minRotation, noOfRotation(B[0], A, B));
    minRotation = Math.min(minRotation, noOfRotation(A[0], B, A));
    minRotation = Math.min(minRotation, noOfRotation(B[0], B, A));

    return minRotation == Integer.MAX_VALUE ? -1 : minRotation;
  }

  private int noOfRotation(int source, int A[], int[] B) {
    int n = A.length;
    int rotationRequired = 0;
    for (int i = 0; i < n; i++) {
      if (A[i] == source) {
        // no operation needed. i.e already openSide has the target
      } else if (B[i] == source) { // flip needed from oppositeSide.
        rotationRequired++;
      } else {
        return Integer.MAX_VALUE; // flip didn't match. No way it can match.
      }
    }
    return rotationRequired;
  }
}
