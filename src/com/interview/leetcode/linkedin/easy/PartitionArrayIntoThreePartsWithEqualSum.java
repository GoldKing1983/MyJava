package com.interview.leetcode.linkedin.easy;

/*

input : [10,-10,10,-10,10,-10,10,-10] output: true
	[0,1][2,3][4,5,6,7] all forms 0.

*/
public class PartitionArrayIntoThreePartsWithEqualSum {
  public boolean canThreePartsEqualSum(int[] A) {
    int total = 0;
    for (int i = 0; i < A.length; i++) {
      total += A[i];
    }
    if (total % 3 != 0) return false; // Note it is not divide, it is MOD
    int count = 0, sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      if (sum == (total / 3)) {
        sum = 0;
        count++;
      }
    }
    return count >= 3;
  }
}
