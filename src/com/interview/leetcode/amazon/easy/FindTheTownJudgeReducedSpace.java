package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/find-the-town-judge/

From "FindTheTownJudge" variable "outDegree" removed. So 1 more iteration is added to
verify judge for below case. 3 has N-1 trusts. But he trusts 1. So he cannot be a judge.

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 */
public class FindTheTownJudgeReducedSpace {

  public int findJudge(int n, int[][] trusts) {
    int[] inDegree = new int[n + 1];
    for (int[] trust : trusts) inDegree[trust[1]]++;
    int possibleJudge = -1;
    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == n - 1) {
        possibleJudge = i;
        break;
      }
    }
    for (int[] trust : trusts) {
      if (trust[0] == possibleJudge) return -1;
    }
    return possibleJudge;
  }
}
