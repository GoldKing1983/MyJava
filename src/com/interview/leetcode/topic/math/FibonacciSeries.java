package com.interview.leetcode.topic.math;

import java.util.HashMap;
import java.util.Map;

/*

https://leetcode.com/problems/fibonacci-number/submissions/

  n  =	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	...
f(n) =	0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	...

f(n) = f(n-1) + f(n-2)
 */
public class FibonacciSeries {

  //=======================================fib-Basic Recursion========================================//
  // Time Complexity is O(2^n)
  public static int fibRecursive(int n) {
    if (n <= 1) return n;
    return (fibRecursive(n - 1) + fibRecursive(n - 2));
  }

  //========================================fibMemoization-Map========================================//
  private Map<Integer, Integer> cache = new HashMap<>();

  // Time Complexity is O(n) with memoization
  public int fibMemoization(int n) {
    if (n <= 1) return n;
    if (cache.containsKey(n)) return cache.get(n);
    Integer result = fibMemoization(n - 1) + fibMemoization(n - 2);
    cache.put(n, result);
    return result;
  }

  //========================================fibMemoization-Array======================================//
  public int fibMemoizationArray(int N) {
    return fib(N, new Integer[N + 1]);
  }

  public int fib(int N, Integer[] cache) {
    if (N <= 1) return N;

    if (cache[N] != null) return cache[N];
    int left = fib(N - 1, cache);
    int right = fib(N - 2, cache);

    cache[N] = left + right;
    return cache[N];
  }

  //============================================fibDP- Simple=========================================//
  public static int fibWhile(int n) {
    if (n <= 1) return n;
    int fNMinus2 = 0;
    int fNMinus1 = 1;
    int fN = 1;
    for (int i = 2; i <= n; i++) {
      fN = fNMinus2 + fNMinus1;
      fNMinus2 = fNMinus1;
      fNMinus1 = fN;
    }
    return fN;
  }

  //=============================================fibDP- Array=========================================//
  public int fibonacciArray(int n) {
    int[] dp = new int[n + 1];
    // base cases
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  //===========================================fibDP- from nbonacci===================================//
  public int fibonacci(int N) {
    if (N <= 1) return N;
    int result = 0;
    for (int i = 1; i <= 2; i++) {
      int currentResult = fibonacci(N - i);
      result += currentResult;
    }
    return result;
  }
}
