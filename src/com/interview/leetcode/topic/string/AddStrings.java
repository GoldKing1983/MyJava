package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/add-strings/description/

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

====================================================Solution Approach====================================================
1) Add from last.
2) try to avoid if conditions for sum/carry logic.
*/
public class AddStrings {

  public String addStrings(String num1, String num2) {
    int num1Index = num1.length() - 1;
    int num2Index = num2.length() - 1;

    StringBuilder sumString = new StringBuilder();
    int carry = 0;

    while (num1Index >= 0 || num2Index >= 0) {
      // 0-'0' = 0...48-48=0......
      // 1-'0' = 1...49-48=1......
      int number1 = num1Index >= 0 ? num1.charAt(num1Index--) - '0' : 0;
      int number2 = num2Index >= 0 ? num2.charAt(num2Index--) - '0' : 0;

      int sum = number1 + number2 + carry;
      carry = sum / 10;
      sum = sum % 10;

      sumString.append(sum);
    }
    if (carry == 1) {
      sumString.append(carry);
    }
    return sumString.reverse().toString();
  }
}
