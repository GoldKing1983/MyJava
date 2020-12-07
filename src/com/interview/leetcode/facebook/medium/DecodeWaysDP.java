package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/decode-ways/

Ex: "123
==================Initial State==================
initial dp = [1, 1, 0, 0]
==================Pointer at index1 data2.Verify 2 and 12==================
After 1digit update dp = [1, 1, 1, 0]
After 2digit update dp = [1, 1, 2, 0]
==================Pointer at index2 data3.Verify 3 and 23==================
After 1digit update dp = [1, 1, 2, 2]
After 2digit update dp = [1, 1, 2, 3]
==================Loop Runs totally 2 times==================
*/
public class DecodeWaysDP {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    if (s.charAt(0) == '0') return 0;

    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int first = Integer.valueOf(s.substring(i - 1, i));
      int second = Integer.valueOf(s.substring(i - 2, i));
      if (first != 0) {
        dp[i] += dp[i - 1];
      }
      if (second >= 10 && second <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[n];
  }
}
