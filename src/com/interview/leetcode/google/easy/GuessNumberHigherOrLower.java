package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/guess-number-higher-or-lower/

 We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

Input: n = 10, pick = 6
Output: 6

=================Solution Approach=========
1) Basic Binary Search
2) No Exit Condition needed. Because there will be result all the time.

 */
public class GuessNumberHigherOrLower {
  public int guessNumber(int n) {
    return binSearch(0, n - 1);
  }

  private int binSearch(int low, int high) {
    int mid = low + (high - low) / 2;
    int response = guess(mid);
    if (response == 0) return mid;
    if (response == 1) return binSearch(mid + 1, high);
    return binSearch(low, mid - 1);
  }

  int guess(int num) {
    return num;
  }
}
