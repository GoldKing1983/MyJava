package com.interview.leetcode.facebook.medium;

import java.util.HashMap;

/*
https://leetcode.com/problems/decode-ways/description/

*/
public class DecodeWaysRecursionMemo {
  HashMap<Integer, Integer> memo = new HashMap<>();

  private int recursiveWithMemo(int index, String str, int n) {

    if (index == n) return 1;

    if (memo.containsKey(index)) return memo.get(index);


    if (str.charAt(index) == '0') return 0;
    int left = recursiveWithMemo(index + 1, str, n);


    boolean validRight =
        (index + 1 <= n - 1) && Integer.parseInt(str.substring(index, index + 2)) <= 26;

    int right = validRight ? recursiveWithMemo(index + 2, str, n) : 0;

    memo.put(index, left + right);
    return left + right;
  }

  public int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    return recursiveWithMemo(0, s, s.length());
  }
}
