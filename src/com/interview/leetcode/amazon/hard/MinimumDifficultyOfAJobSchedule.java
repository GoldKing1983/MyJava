package com.interview.leetcode.amazon.hard;

/*
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
===========================================================Requirement===========================================================
1) Given a array of input, split the givenInputArray into given "d" size.
2) Like SubString(unlike SubSequence) input should be consecutive, when splitting.
3) Pick max of each day split and sum the result.
4) If "d" is greater than inputSize. Then -1.
============================================================Example1=============================================================
Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Here, we have to take 2 days. We cannot complete all work in 1 day.
Also we cannot rearrange because to do next work previous work should be completed. Therefore:

max(6,5,4,3,2) = 6
max(1) = 1
Total: 7
============================================================Example2=============================================================
Input: jobDifficulty = [9,9,9], d = 4
Three jobs cannot be completed in 4 days because we need to do one job per day. So it will finish in 3 days.
Therefore:
-1
============================================================Example3=============================================================
Input: jobDifficulty = [1,1,1], d = 3
We have to take 3 days.

max(1) = 1
max(1) = 1
max(1) = 1
Total: 3
============================================================Example4=============================================================
Input: jobDifficulty = [7,1,7,1,7,1], d = 3
We have to take three days. Therefore:
max(7,1,7) = 7
max(1,7) = 7
max(1) = 1
Total: 15

another solution would be
max(7,1,7) = 7
max(1) = 1
max(7,1) = 7
Total: 15

another solution would be
max(7,1) = 7
max(7,1,7) = 7
max(1) = 1
Total: 15

============================================================Example4=============================================================
Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
Output: 843
We have to take 6 days. Should not complete fast. Therefore

max(11) = 11
max(111) = 111
max(22) = 22
max(222) = 222
max(33) = 33
max(333, 44, 444) = 444
Total: 843
=================================================================================================================================
 */
public class MinimumDifficultyOfAJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int jobs = jobDifficulty.length;
        if (jobs < d) return -1;

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        dfs(jobDifficulty, d, 0, min, 0);
        return min[0];
    }

    private void dfs(int[] jobDifficulty, int d, int idx, int[] min, int sum) {
        int jobs = jobDifficulty.length;
        // Base Case
        if (idx == jobs && d == 0) {
            min[0] = Math.min(sum, min[0]);
            return;
        }
        if (d == 0 || jobs - idx < d) return;

        int diff = 0;
        for (int i = idx; i < jobs; i++) {
            diff = Math.max(diff, jobDifficulty[i]);
            dfs(jobDifficulty, d - 1, i + 1, min, sum + diff);
        }
        return;
    }
}
