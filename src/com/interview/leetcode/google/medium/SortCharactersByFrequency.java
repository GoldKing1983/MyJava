package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
  https://leetcode.com/problems/sort-characters-by-frequency/description/

  groupByKeys
  SortByCounts and return result.

  How to achieve without sorting... See SortCharactersByFrequencyBucketApproach
*/
public class SortCharactersByFrequency {
  public String frequencySort(String s) {
    Map<Character, Integer> byKey = new HashMap<>();
    TreeMap<Integer, List<Character>> bySize = new TreeMap<>(Collections.reverseOrder());

    for (Character c : s.toCharArray()) byKey.put(c, byKey.getOrDefault(c, 0) + 1);

    for (Map.Entry<Character, Integer> entry : byKey.entrySet())
      bySize.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());

    StringBuilder result = new StringBuilder();
    for (Map.Entry<Integer, List<Character>> entry : bySize.entrySet()) {
      for (Character c : entry.getValue()) {
        for (int i = 0; i < entry.getKey(); i++) result.append(c);
      }
    }
    return result.toString();
  }
}
