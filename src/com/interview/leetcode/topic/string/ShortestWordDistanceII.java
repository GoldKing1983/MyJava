package com.interview.leetcode.topic.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/shortest-word-distance-ii/description/
===========================================================Requirement===========================================================
1) Same as ShortestWordDistance
2) But here there will be query of word1 and word2.
=====================================Solution Approach=====================================
1) Instead of iterating the words every-time for query, save the indexes in map.
2) For each of query get the indexes and calculate minDistance. 

Ex: words = ["a", "a", "b", "b"].
map= a[1,2] and b[3,4] 

Input: word1 = “a”, word2 = “b”
Output: 1 (3-2)

Input: word1 = "b", word2 = "a"
Output: 1 (3-2)

  
 */
public class ShortestWordDistanceII {
  Map<String, List<Integer>> map;

  public ShortestWordDistanceII(String[] words) {
    map = new HashMap<>();
    int index = 1;
    for (String word : words) map.computeIfAbsent(word, (k) -> new ArrayList<>()).add(index++);
  }

  public int shortest(String word1, String word2) {
    int minDistance = Integer.MAX_VALUE;
    //Ex: words = ["a", "a", "b", "b"]. map= a[1,2] and b[3,4] 

    List<Integer> word1Indexes = map.get(word1); // word1 = a.. So, word1Indexes = [1,2]

    List<Integer> word2Indexes = map.get(word2); // word2 = b.. So, word2Indexes = [3,4]

    for (Integer i1 : word1Indexes) {
      for (Integer i2 : word2Indexes) {
        minDistance = Math.min(minDistance, Math.abs(i1 - i2));
      }
    }
    return minDistance;
  }
}
