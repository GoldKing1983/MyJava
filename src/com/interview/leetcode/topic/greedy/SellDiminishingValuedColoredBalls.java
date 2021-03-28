package com.interview.leetcode.topic.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/sell-diminishing-valued-colored-balls/

Input: inventory = [2,5], orders = 4
Output: 14
Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 + 3).
The maximum total value is 2 + 5 + 4 + 3 = 14.


 */
public class SellDiminishingValuedColoredBalls {
  public int maxProfit(int[] inventory, int orders) {
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    for (int inv : inventory) {
      while (inv > 0) {
        pQ.offer(inv--);
      }
    }
    int ans = 0;
    while (orders-- > 0) {
      ans += pQ.poll();
    }
    return ans;
  }
}
