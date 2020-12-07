package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/paint-fence/
https://leetcode.com/problems/paint-fence/discuss/547999/One-visual-representation-thousand-words!

n=1 and k=10, Answer= 10

n=3 and k=2, Answer = 6
 000--> more than 2 0s, skipped
 001
 010
 011
 100
 101
 110
 111--> more than 2 1s, skipped

 =====================================Solution Approach===========================
1) Case 1
You are currently at i'th fence and want to paint it with a color that is not present in the
(i-1)th fence. How many ways can you do it satisfying all the conditions?

f(n) = f(n-1) * k-1;

2) Case 2
You are currently at i'th fence and want to paint it with the same color that is present in the (i-1)th fence.
How many ways can you do it satisfying all the conditions?
f(n) = f(n-2) * k-1;

Final Formula = f(n) = (f(n-1)+f(n-2))* k-1;
===============================================================================================================
*/

public class PaintFenceRecursion {

  public int numWays(int n, int k) {
    if (n == 0 || k == 0) return 0;
    if (n == 1) return k;
    if (n == 2) return k * k;
    int sameColor = numWays(n - 1, k) * (k - 1);
    int differentColor = numWays(n - 2, k) * (k - 1);
    return sameColor + differentColor;
  }
}
