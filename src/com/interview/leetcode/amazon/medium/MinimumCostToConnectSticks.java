package com.interview.leetcode.amazon.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/

1) Pick Top 2. Sum it put it back to queue. Before putting add that to result.
2) Do above till q.size>1

sticks = [1,8,3,5]
step 1:
cost -> 1+3 = 4
result -> [4,8,5]
step 2:
cost -> 4+5 = 9
result -> [9,8]
step 3:
cost -> 9+8 = 17
result = [17]
FINAL COST = 4 + 9 + 17 = 30


 */
public class MinimumCostToConnectSticks {
  public int connectSticks(int[] sticks) {
    Queue<Integer> pQ = new PriorityQueue<>();
    for (int stick : sticks) pQ.offer(stick);

    int answer = 0;
    while (pQ.size() > 1) {
      int curr = pQ.poll() + pQ.poll();
      answer += curr;
      pQ.offer(curr);
    }
    return answer;
  }
}
