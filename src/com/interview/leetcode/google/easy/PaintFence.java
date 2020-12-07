package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/paint-fence/
https://leetcode.com/problems/paint-fence/discuss/547999/One-visual-representation-thousand-words!
=============================================Requirement================================================
1) There is a fence with n posts, each post can be painted with one of the k colors.
2) You have to paint all the posts such that "at-most 2 fence can same color".

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Example:

Input: n = 3, k = 2 Output: 6
Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

            post1  post2  post3
 -----      -----  -----  -----
   1         c1     c1     c2
   2         c1     c2     c1
   3         c1     c2     c2
   4         c2     c1     c1
   5         c2     c1     c2
   6         c2     c2     c1

Input: n = 1, k = 10 Output: 10
=============================================BackTrack Thinking================================================
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
1) Case 1: Paint different color
You are currently at i'th fence and want to paint it with a color that is not present in the
(i-1)th fence. How many ways can you do it satisfying all the conditions?

f(n) = f(n-1) * k-1;

2) Case 2: Paint same color
You are currently at i'th fence and want to paint it with the same color that is present in the (i-1)th fence.
How many ways can you do it satisfying all the conditions?
f(n) = f(n-2) * k-1;

Final Formula = f(n) = (f(n-1)+f(n-2))* k-1;
===============================================================================================================
*/
public class PaintFence {

  public int numWays(int n, int k) {
    if (n == 0) return 0; // if there are no posts, there are no ways to paint them

    if (n == 1) return k; // if there is only one post, there are k ways to paint it

    // if there are only two posts, you can't make a triplet, so you are free to paint however you
    // want. So first post has k options and second post has k options. So k*k
    if (n == 2) return k * k;

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = k;
    dp[2] = k * k;
    for (int i = 3; i <= n; i++) {
      // the recursive formula that we derived
      dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
    }
    return dp[n];
  }

  public int numWaysFibStyle(int n, int k) {
    int fN = 0;
    int fNMinus1 = k;
    int fNMinus2 = k * k;
    if (n == 0) return fN;
    if (n == 1) return fNMinus1;
    if (n == 2) return fNMinus2;
    for (int i = 3; i <= n; i++) {
      fN = (fNMinus1 + fNMinus2) * (k - 1);
      fNMinus1 = fNMinus2;
      fNMinus2 = fN;
    }
    return fN;
  }
}
