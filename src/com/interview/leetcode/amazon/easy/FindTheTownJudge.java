package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/find-the-town-judge/
 *
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1)The town judge trusts nobody.
2)Everybody (except for the town judge(So N-1)) trusts the town judge.
3)There is exactly one person that satisfies properties 1 and 2.
====================================================================================
Corner Case: For this case only we are managing "cannotBeJudge". If there is no cornerCase, trustCount logic is enough
3
[[1,3],[2,3],[3,1]]
1----->
   		| -->3---->1
2----->
Output: -1... 3 is possible Judge. But 3 trust 1. So no judge in result.
====================================================================================
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]] Output: 3

1--->(3,4)
2--->(3,4)
4--->(3)
====================================================================================
3
[[1,2],[2,3]] Output: -1
Reason: Exactly N-1 person needs to trust an judge.
======================================================Solution Approach======================================================
For a node, if the inDegreeCount is n-1 and outDegreeCount is 0, then he/she is judge. 
 */
public class FindTheTownJudge {

  public int findJudge(int n, int[][] trusts) {
    int[] inDegree = new int[n + 1];
    boolean[] outDegree = new boolean[n + 1];
    for (int[] trust : trusts) {
      outDegree[trust[0]] = true;
      inDegree[trust[1]]++;
    }

    for (int i = 1; i <= n; i++) {
      if (outDegree[i]) continue;
      if (inDegree[i] == n - 1) return i;
    }

    return -1;
  }

}
