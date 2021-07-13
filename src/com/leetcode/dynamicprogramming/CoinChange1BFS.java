package com.leetcode.dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange1BFS {
  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] visit = new int[amount];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(amount);
    int idx = 1;
    int count = 0;
    while (!queue.isEmpty()) {
      count++;
      int size = idx;
      idx = 0;
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        for (int item : coins) {
          int rem = cur - item;
          if (rem == 0) return count;
          if (rem > 0 && visit[rem] == 0) {
            queue.offer(rem);
            visit[rem] = 1;
            idx++;
          }
        }
      }
    }
    return -1;
  }
}
