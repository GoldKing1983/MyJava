package com.interview.leetcode.google.medium;

/*
1) Take A's each value as source try flip A and B.
2) Take B's each value as source try flip B and A.
3) Above steps are un-necessary and below code leads TLE, because if any index does not match with other values we can skip right away.
4) Analyzing statement3 makes only 4 combination possible.
    4a) Take any value in either A or B. flip it 4 times and see whether it matches with rest of all.
*/
public class MinimumDominoRotationsForEqualRowWrongApproach {
  public int minDominoRotations(int[] A, int[] B) {
    int minRotation = Integer.MAX_VALUE;
    for (int a : A) {
      minRotation = Math.min(minRotation, noOfRotation(a, A, B));
    }
    for (int b : B) {
      minRotation = Math.min(minRotation, noOfRotation(b, B, A));
    }
    return minRotation == Integer.MAX_VALUE ? -1 : minRotation;
  }

  private int noOfRotation(int source, int A[], int[] B) {
    int n = A.length;
    int rotationRequired = 0;
    for (int i = 0; i < n; i++) {
      if (A[i] == source) {
        // don't do anything
      } else if (B[i] == source) {
        rotationRequired++;
      } else {
        return Integer.MAX_VALUE; // second dice is not matching the source.
      }
    }
    return rotationRequired;
  }
}
