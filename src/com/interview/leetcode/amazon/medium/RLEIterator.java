package com.interview.leetcode.amazon.medium;

/*
 * https://leetcode.com/problems/rle-iterator/

Input: ["RLEIterator","next","next","next","next"], [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
Output: [null,8,8,5,-1]
Explanation:
RLEIterator is initialized with RLEIterator([3,8,0,9,2,5]).
This maps to the sequence [8,8,8,5,5].
RLEIterator.next is then called 4 times:

.next(2) exhausts 2 terms of the sequence, returning 8.  The remaining sequence is now [8, 5, 5].

.next(1) exhausts 1 term of the sequence, returning 8.  The remaining sequence is now [5, 5].

.next(1) exhausts 1 term of the sequence, returning 5.  The remaining sequence is now [5].

.next(2) exhausts 2 terms, returning -1.  This is because the first term exhausted was 5,
but the second term did not exist.  Since the last term exhausted does not exist, we return -1.

============================Solution Approach============================
1) Stack or Queue nothing is needed.
2) Use the same input array as such.
3)
 */
public class RLEIterator {
  int index;
  int[] A;

  public RLEIterator(int[] A) {
    this.A = A;
    index = 0;
  }

  public int next(int n) {
    while (index < A.length && n > A[index]) {
      n = n - A[index];
      index += 2;
    }

    if (index >= A.length) return -1;

    A[index] = A[index] - n;
    return A[index + 1];
  }
}
