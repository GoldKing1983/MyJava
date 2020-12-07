package com.interview.leetcode.google.medium;

/*
 * https://leetcode.com/problems/campus-bikes-ii/

Requirement: Same problem as CampusBikes.java. But here
"find minimum possible sum of Manhattan distances between each worker and their assigned bike."
===========================================================Solution Approach=================================================
1) For each of the bike, permute and calculate min against all workers
	Ex: 3 workers and 3 bikes, w1,w2,w3 and b1,b2,b3... There will be 6 combinations.

Current Permutation: [B0:W0]
Current Permutation: [B0:W0, B1:W1]
Current Permutation: [B0:W0, B1:W1, B2:W2] ======Permutation Found======
Current Permutation: [B0:W0, B1:W1]
Current Permutation: [B0:W0]
Current Permutation: [B0:W0, B2:W1]
Current Permutation: [B0:W0, B2:W1, B1:W2] ======Permutation Found======
Current Permutation: [B0:W0, B2:W1]
Current Permutation: [B0:W0]
Current Permutation: []
Current Permutation: [B1:W0]
Current Permutation: [B1:W0, B0:W1]
Current Permutation: [B1:W0, B0:W1, B2:W2] ======Permutation Found======
Current Permutation: [B1:W0, B0:W1]
Current Permutation: [B1:W0]
Current Permutation: [B1:W0, B2:W1]
Current Permutation: [B1:W0, B2:W1, B0:W2] ======Permutation Found======
Current Permutation: [B1:W0, B2:W1]
Current Permutation: [B1:W0]
Current Permutation: []
Current Permutation: [B2:W0]
Current Permutation: [B2:W0, B0:W1]
Current Permutation: [B2:W0, B0:W1, B1:W2] ======Permutation Found======
Current Permutation: [B2:W0, B0:W1]
Current Permutation: [B2:W0]
Current Permutation: [B2:W0, B1:W1]
Current Permutation: [B2:W0, B1:W1, B0:W2] ======Permutation Found======
Current Permutation: [B2:W0, B1:W1]
Current Permutation: [B2:W0]
Current Permutation: []

======================================================================================================================


 */
public class CampusBikesII {
  private int max;

  public int assignBikes(int[][] workers, int[][] bikes) {
    max = Integer.MAX_VALUE;
    dfs(workers, bikes, new boolean[bikes.length], 0, 0);
    return max;
  }

  private void dfs(
      int[][] workers, int[][] bikes, boolean[] visited, int sumDistance, int workerId) {
    if (workerId == workers.length) {
      max = Math.min(sumDistance, max);
      return;
    }

    for (int bikeId = 0; bikeId < bikes.length; bikeId++) {
      if (!visited[bikeId]) {
        visited[bikeId] = true;
        int distance = dist(workers[workerId], bikes[bikeId]);
        dfs(workers, bikes, visited, sumDistance + distance, workerId + 1);
        visited[bikeId] = false;
      }
    }
  }

  private int dist(int[] worker, int[] bike) {
    return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
  }
}
