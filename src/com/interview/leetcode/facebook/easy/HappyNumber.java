package com.interview.leetcode.facebook.easy;

/*

https://leetcode.com/problems/happy-number/
Requirement Understanding:
1) Split the number.
2) Do Square and sum of number.
3) Do until, if it loops or 1.
4) If it loops output false, If it reached 1 then true.
======================Example True======================
Input: 19
Output: true
Explanation:
1square + 9square = 82
8square + 2square = 68
6square + 8square = 100
1square + 0square + 0square = 1
======================Example False or number that loops======================
Input: 21
Output: false
2square + 1square = 5
5square = 25
2square + 5square = 29
2square + 9square = 85
8square + 5square = 89========> going to loop
8square + 9square = 145
1square + 4square + 5square= 42
4square + 2square = 20
2square + 0square = 4
4square  = 16
1square + 6square = 37
3square + 7square = 58
5square + 8square = 89=========> loop
========================================================================================


======Solution Approach1========
1) Use slowPtr and fastPtr pointer approach to identify the loop.
	Case1: If there is a loop, fastPtr will catch slowPtr.
	Case2: If there is no loop, fastPtr will change into 1.
2) For case1 return false. For case2 return true.
======Solution Approach2========
1) Use set to track the loop.
2) If 1 reached return. If number occurs again return false.

 */
public class HappyNumber {
  public boolean isHappy(int n) {
    int slowPtr = n;
    int fastPtr = n;
    while (true) {
      slowPtr = count(slowPtr);
      // If 1 is reached, doing one more process still yields 1 only
      fastPtr = count(count(fastPtr));
      if (fastPtr == 1) return true; // No loop, fastPtr reached 1.
      if (slowPtr == fastPtr) return false; // loop, fastPtr catched slowPtr.
    }
  }

  private int count(int num) {
    int ans = 0, digit = 0;
    while (num > 0) {
      digit = num % 10;
      ans = ans + (digit * digit);
      num = num / 10;
    }
    return ans;
  }

  // If fastPtr reaches 1, doing process again and again still yields 1 only
  // So slowPtr will catch fastPtr, if there is no loop
  public boolean isHappyWithoutIfCondition(int n) {
    int slowPtr = n;
    int fastPtr = n;
    do {
      slowPtr = count(slowPtr);
      fastPtr = count(count(fastPtr));
    } while (slowPtr != fastPtr);
    return slowPtr == 1;
  }
}
