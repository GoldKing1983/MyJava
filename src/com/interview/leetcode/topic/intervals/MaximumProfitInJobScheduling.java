package com.interview.leetcode.topic.intervals;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-profit-in-job-scheduling/
===========================================================Requirement===========================================================
===========================================================BruteForce============================================================
1) Permute all non-overlapping interval with its profit. Return the max profit.
============================================================TopDownDP============================================================
1) Group input startTime, endTime and profit into single array say jobs.
2) Sort the jobs by startTime.
3) For each job(startTime and endTime), find next non-overlapping job.
4) Include nextJob and profit and do recursion, Exclude currentJob and do recursion.
5) Time Complexity - 2^n
6) If i Memoize it, then Time Complexity - n^2 


========================================================Solution Approach========================================================
 */
public class MaximumProfitInJobScheduling {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int len = startTime.length;
    int[][] jobs = new int[len][3];
    for (int i = 0; i < len; i++) {
      jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
    }
    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

    return dfs(0, jobs, new Integer[len]);
  }

  private int dfs(int cur, int[][] jobs, Integer[] memo) {
    if (cur == jobs.length) return 0;
    if (memo[cur] != null) return memo[cur];

    int inclProf = jobs[cur][2] + dfs(findNext(cur, jobs), jobs, memo);
    int exclProf = dfs(cur + 1, jobs, memo);

    return memo[cur] = Math.max(inclProf, exclProf);
  }

  private int findNext(int cur, int[][] jobs) {
    for (int next = cur + 1; next < jobs.length; next++) {
      // if current job end is less than next job start then 
      if (jobs[cur][1] <= jobs[next][0] ) {
        return next;
      }
    }
    return jobs.length;
  }
}
