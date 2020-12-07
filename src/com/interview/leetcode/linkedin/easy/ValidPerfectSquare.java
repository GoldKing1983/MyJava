package com.interview.leetcode.linkedin.easy;

/*
https://leetcode.com/problems/valid-perfect-square/

negativeNumbers -> false
0 -> true
1 -> true
2 -> false
4 -> true
 */

public class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    if (num < 2) return true;
    return binSearch(2, num / 2, num);
  }

  private boolean binSearch(int low, int high, int target) {
    if (low > high) return false;
    float mid = low + (high - low) / 2;
    if (mid == target / mid) return true;
    if (mid > target / mid) return binSearch(low, (int) mid - 1, target);
    return binSearch((int) mid + 1, high, target);
  }

  private boolean binSearchLongVersion(int low, int high, int target) {
    if (low > high) return false;
    long mid = low + (high - low) / 2;
    if (mid * mid == target) return true;
    if (mid * mid > target) return binSearch(low, (int) mid - 1, target);
    return binSearch((int) mid + 1, high, target);
  }
}
