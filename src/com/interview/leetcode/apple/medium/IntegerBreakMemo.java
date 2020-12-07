package com.interview.leetcode.apple.medium;

import java.util.HashMap;

public class IntegerBreakMemo {
  public int integerBreak(int n) {
    return dfs(n, 1, 0);
  }

  HashMap<String, Integer> memo = new HashMap<>();

  public int dfs(int n, int sum, int product) {
    if (sum == n) return product;

    if (sum > n) return 0;
    String key = sum + "," + product;
    if (memo.containsKey(key)) return memo.get(key);

    int pro = Integer.MIN_VALUE;
    for (int i = 1; i <= Math.ceil(n / 2.0); i++) {
      pro = Math.max(pro, dfs(n, product * i, sum + i));
    }
    memo.put(key, pro);
    return pro;
  }
}
