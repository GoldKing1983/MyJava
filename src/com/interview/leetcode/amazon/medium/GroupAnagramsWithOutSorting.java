package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/group-anagrams/description/
==========================================Requirement===================================================================
Given an array of strings, group anagrams together.

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
==========================================Solution Approach==============================================================
Instead of sorting, unique hash is created from buckets of input.
 */
public class GroupAnagramsWithOutSorting {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Integer, List<String>> map = new HashMap<>();
    for (String input : strs) {
      // Create unique id for "input" String
      int[] index = new int[26];
      for (char c : input.toCharArray()) index[c - 'a']++;
      int uniqueIndex = hashCode(index);

      map.computeIfAbsent(uniqueIndex, k -> new ArrayList<>()).add(input);
    }
    return new ArrayList<>(map.values());
  }

  private int hashCode(int a[]) {

    int uniqueId = 1;
    for (int element : a) uniqueId = (31 * uniqueId) + element;
    return uniqueId;
  }
}
