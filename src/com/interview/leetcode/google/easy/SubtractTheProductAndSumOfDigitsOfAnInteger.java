package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
  public int subtractProductAndSumFromLastToFirst(int n) {
    int product = 1;
    int sum = 0;
    while (n > 0) {
      int lastNumber = n % 10;
      n = n / 10;
      sum += lastNumber;
      product *= lastNumber;
    }
    return product - sum;
  }

  public int subtractProductAndSumFromFirstToLast(int n) {
    String s = Integer.toString(n);
    int product = 1;
    int sum = 0;
    for (char c : s.toCharArray()) {
      int currentNumber = Integer.parseInt(String.valueOf(c));
      product *= currentNumber;
      sum += currentNumber;
    }
    return product - sum;
  }
}
