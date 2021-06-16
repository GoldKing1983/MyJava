package com.interview.leetcode.topic.bucket;

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
    for (String s : strs) {
      int hashedS = hashCode(s);
      map.computeIfAbsent(hashedS, k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
  }

  private int hashCode(String input) {
    // Create unique id for "input" String
    char[] bucket = new char[26];
    for (char c : input.toCharArray()) bucket[c - 'a']++;
    return new String(bucket).hashCode();
  }
}
