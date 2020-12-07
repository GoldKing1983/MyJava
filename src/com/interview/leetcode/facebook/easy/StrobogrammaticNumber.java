package com.interview.leetcode.facebook.easy;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/strobogrammatic-number/

==================================Solution using Two Pointer Approach========================================
1) Take actual number on "left side". Take rotated number on "right side".
2) If both matches then continue matching next. Else return false.
3) Rotated number for "0,1,8" is "0,1,8" itself
4) Rotated number for "6,9" is "9,6".
5) For rest of chars, save any dummy char. Because if it occurs, it can never be Strobogrammatic.

6) Last trick is, for odd number of input, only '0','1' and '8' can pass.
The loop runs till "left<=right". i.e for 1 input loop runs 1 time. and 3 for input loop runs 2 times.
Ex: 6. In this case run loop 1 time. 6 compared with 9. So fails
Ex: 699. In this case run loop 2 times. Middle 9 compared with 6. So fails
Ex: 619. In this case run loop 2 times. Middle 1 compared with 1. So it succeeds.
==========================================================================================================================
Input: "619". Output: True
*/

public class StrobogrammaticNumber {

  private Map<Character, Character> map = new HashMap<>();

  {
    map.put('0', '0');
    map.put('1', '1');
    map.put('6', '9');
    map.put('8', '8');
    map.put('9', '6');
  }

  public boolean isStrobogrammatic(String num) {
    StringBuilder s = new StringBuilder(num);
    for (int left = 0, right = s.length() - 1; left <= right; left++, right--) {
      char leftNumber = num.charAt(left);
      char rightNumber = num.charAt(right);
      Character rightRotatedNumber = map.get(rightNumber);
      if (rightRotatedNumber == null) return false;
      if (leftNumber != rightRotatedNumber) return false;
    }
    return true;
  }
}
