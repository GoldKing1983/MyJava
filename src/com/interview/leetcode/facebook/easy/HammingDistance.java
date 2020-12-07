package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/hamming-distance/
=====================================================Requirement=================================================================
The Hamming distance between two integers is the "countOfNumberOfPositions" at which the corresponding bits are different.

=======================================================Example1==================================================================
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
=======================================================Example2==================================================================
Input: x = 2, y = 4

Output: 2

Explanation:
1   (0 0 1 0)
4   (0 1 0 0)
       ↑ ↑  

The above arrows point to positions where the corresponding bits are different.
=================================================================================================================================
 */
public class HammingDistance {
  public int hammingDistance(int x, int y) {
    if (x == y) return 0;
    int count = 0;
    for (int i = 0; i < 31; i++) {
      count += (x & 1) ^ (y & 1);
      x = x >> 1;
      y = y >> 1;
    }
    return count;
  }
}
