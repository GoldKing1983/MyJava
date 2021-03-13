package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

https://leetcode.com/problems/top-k-frequent-words/
===========================================================Requirement===========================================================
1) Given a non-empty list of words, return the k most frequent elements.
2) If 2 different words have same count, return them alphabetically.

Input: ["the", "the", "the", "the", "sunny", sunny, "is", "is"], k = 2
Output: ["the", "is"]
Explanation:
"the" appears 4 times. So "the" would be the first result.
"sunny" and "is" both appears 2 times. But "i" is less than "s". So is comes in result.
============================================================Solution Approach =============================================
Step1: save each word by it counts in map.
Step2: sort the words.
  2 things are happening in sort
  1) for 2 words .
  2) If both are word appears same number of time, compare candidate itself. So that they will be sorted alphabetically.
  3) Else compare candidate count( for Descending order, make sure word2-word1).

See Also ReorderDataInLogFilesBest
 */
public class TopKFrequentWords {
  /*
    	 map = {the=4, is=2, sunny=2}
  candidates = [the, is, sunny] --> after sorting
    */
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    List<String> candidates = new ArrayList<>(map.keySet());
    Collections.sort(
        candidates,
        (word1, word2) -> {
          int word1Count = map.get(word1);
          int word2Count = map.get(word2);

          if (word1Count == word2Count) return word1.compareTo(word2);
          return word2Count - word1Count;
        });

    return candidates.subList(0, k);
  }
}
