package com.interview.leetcode.google.hard;

import com.interview.leetcode.google.easy.ConfusingNumber;
/*
 * https://leetcode.com/problems/confusing-number-ii/
 */
public class ConfusingNumberIIBruteForce {

  public int confusingNumberII(int N) {
    int count = 0;
    ConfusingNumber c = new ConfusingNumber();
    for (int i = 1; i <= N; i++) {
      if (c.confusingNumber(i)) count++;
    }
    return count;
  }
}
