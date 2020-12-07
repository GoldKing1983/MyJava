package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/remove-k-digits/

Given a non-negative integer num represented as a string, remove k digits from the number,
so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Input: num = "91", k = 1
Output: "1"

Input: num = "19", k = 1
Output: "1"

================================================Solution Approach===============================================================
1) Run Loop from 0 to n-1.. Ex: "91". Loop runs one time.
2) Keep input as result itself.
3) From leftToRight, if "currentNumber" is bigger than "nextNumber", delete currentNumber from result.
4) Move "currPointer" to previous... So that we don't need stack.
Ex:   893 k=2.
At point 8. currentNumber is not biggerThan nextNumber. So no operation. Move Next
At point 9. currentNumber is     biggerThan nextNumber. So delete 9. Move currPointer to 8.
At point 8. currentNumber is     biggerThan nextNumber. So delete 8. Move currPointer to index "-1".


 */
public class RemoveKDigits {
  public String removeKdigits(String num1, int k) {

    if (num1.length() == k) return "0";
    StringBuilder num = new StringBuilder(num1);
    int currPointer = 0;
    // ====================Core Meat Logic - Starts====================
    while (k > 0) {
      if (currPointer + 1 == num.length()) break; // reached max...
      if (currPointer >= 0 && num.charAt(currPointer) > num.charAt(currPointer + 1)) {
        num = num.deleteCharAt(currPointer);
        k--;
        currPointer--;
        continue;
      }
      currPointer++;
    }
    // ====================Core Meat Logic - Ends====================

    // ====================Remaining Corner Cases====================

    // "10200" k=1 Output:"200". Truncate Leading Zeroes
    while (num.length() > 0 && num.charAt(0) == '0') num = num.deleteCharAt(0);

    // Ex: "10" k=2.. Add 0 manually
    if (num.length() == 0) return "0";

    // Ex: "112" k=1 data's in ascending order, input not changed. We can just delete lastKElements
    return num.substring(0, num.length() - k);
  }
}
