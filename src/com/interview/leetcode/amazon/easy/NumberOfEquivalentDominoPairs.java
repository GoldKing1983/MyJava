package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.Map;

/*

https://leetcode.com/problems/number-of-equivalent-domino-pairs/

[[1,2],[2,1],[1,2],[5,6],[1,2],[1,2]] Ans:10

{1,2=1} 		res:0
{1,2=2} 		res:1
{1,2=3} 		res:3
{1,2=3, 5,6=1}  res:3
{1,2=4, 5,6=1}  res:6
{1,2=5, 5,6=1}  res:10

 */
public class NumberOfEquivalentDominoPairs {
  public int numEquivDominoPairs(int[][] dominoes) {
    Map<String, Integer> map = new HashMap<>();
    int res = 0;
    for (int[] domino : dominoes) {
      StringBuilder sb = new StringBuilder();
      if (domino[0] < domino[1]) {
        sb.append(domino[0] + "," + domino[1]);
      } else {
        sb.append(domino[1] + "," + domino[0]);
      }
      if (map.containsKey(sb.toString())) res += map.get(sb.toString());
      map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
      System.out.println(map);
    }
    return res;
  }
}
