package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/can-place-flowers/solution/
 *
Suppose you have a long flowerbed in which some of the plots are planted and some are not.
However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

===Note:  I can plant only if current column is 0, previous column is 0 and next column is 0.=========

 */
public class CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0) return true;
    for (int i = 0; i < flowerbed.length; i++) {

      boolean isLeftGood = i == 0 ? true : flowerbed[i - 1] == 0;
      boolean isRightGood = i == flowerbed.length - 1 ? true : flowerbed[i + 1] == 0;

      // I can plant only if current column is 0, previous column is 0 and next column is 0.
      if (flowerbed[i] == 0 && isLeftGood && isRightGood) {
        flowerbed[i] = 1; // Plant on the flowerbed
        n--; // Reduce the count of plant to be flowerbedded
        if (n == 0) return true;
      }

    }
    return false;
  }

}
