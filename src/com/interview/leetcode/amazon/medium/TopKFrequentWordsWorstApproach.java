package com.interview.leetcode.amazon.medium;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-words/

1) This code any fresher can write or any new coder who can understand requirement(knows API) can write.
2) Think for some-time, how we can write optimized code
 */
public class TopKFrequentWordsWorstApproach {
  /*
      map = {the=4, is=2, sunny=2}
  resultMap = {4=[the], 2=[is, sunny]}
   */
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    Map<Integer, List<String>> resultMap = new TreeMap<>(Collections.reverseOrder());
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (resultMap.containsKey(entry.getValue())) {
        resultMap.get(entry.getValue()).add(entry.getKey());
      } else {
        List<String> list = new ArrayList<>();
        list.add(entry.getKey());
        resultMap.put(entry.getValue(), list);
      }
    }

    List<String> result = new ArrayList<>();
    for (List<String> entry : resultMap.values()) {
      Collections.sort(entry);
      for (String e : entry) {
        result.add(e);
        if (result.size() == k) return result;
      }
    }
    return result;
  }
}
