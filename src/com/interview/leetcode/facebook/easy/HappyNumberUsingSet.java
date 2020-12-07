package com.interview.leetcode.facebook.easy;

import java.util.HashSet;
import java.util.Set;

/*

https://leetcode.com/problems/happy-number/
Requirement Understanding:
1) Split the number.
2) Do Square and sum of number.
3) Do until,  it loops or turns 1.
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


======Solution Approach========
1) Use set to track the loop.
2) If 1 reached return true. If number occurs again return false.

 */
public class HappyNumberUsingSet {
  public boolean isHappy(int n) {
    int slow = n;
    Set<Integer> set = new HashSet<>();
    while (true) {
      slow = count(slow);
      if (!set.add(slow)) return false;
      if (slow == 1) return true;
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
}
