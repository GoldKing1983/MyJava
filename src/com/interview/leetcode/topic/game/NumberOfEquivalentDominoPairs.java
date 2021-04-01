package com.interview.leetcode.topic.game;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/number-of-equivalent-domino-pairs/

===========================================================Requirement===========================================================
1) Given a list of dominoes.
2) Find how many ways we can make pairs.
2) Condition : A domino 1,2 is same as 2,1 or 1,2 and 2,1 are equal

============================================================Example1=============================================================
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
Explanation : 1,2 and 2,1 are same... So it makes 1 pair

============================================================Example1=============================================================
Input: dominoes = [[1,2],[2,1],[2,1],[5,6]]
Output: 3
Explanation : 1,2 and 2,1 are same... if we say term it as A, B, C. Then 3 pair is possible. A,B..B,C.. C,A
============================================================Example3=============================================================

if you have A,B equal, then 1 pair
if you have A,B,C all equal, then there are 3 pairs because A,B, A,C, B,C are equal
if you have A,B,C,D all equal, then these are 6 pairs.
if you have A,B is equal and C,D is equal, then total pair is 2
=======================================================Data Flow Analysis========================================================
Take the example from the problem:
dominoes = [[1,2],[2,1],[3,4],[5,6]]
now we transform it into [12,12,34,56].

How math works. Assume I have 5 pair.

Step1:        1   2   3   4   5

Step2:        1   2   3   4   5
              | \ | \ | \ | \ | \
              0   1   3   6  10  15

 */
public class NumberOfEquivalentDominoPairs {
  public int numEquivDominoPairs(int[][] dominoes) {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int[] domino : dominoes) {
      int x = domino[0];
      int y = domino[1];
      int maxX = Math.max(x, y);
      int minY = Math.min(x, y);

      int hash = maxX * 10 + minY;
      result += map.getOrDefault(hash, 0);
      map.put(hash, map.getOrDefault(hash, 0) + 1);
    }
    return result;
  }
}
