package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

https://leetcode.com/problems/top-k-frequent-words/

Input: ["the", "the", "the", "the", "sunny", sunny, "is", "is"], k = 2
Output: ["the", "is"]
Explanation: "sunny" and "is" both has same size. But i is less than s. So is comes in result


map = {the=4, is=2, sunny=2}

resultMap = {4=[the], 2=[is, sunny]}

 */
public class TopKFrequentWords {
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

  /*
    	map = {the=4, is=2, sunny=2}
  candidates = [the, is, sunny]

  2 things are happening in sort
  1) for 2 candidate. If both are same compare candidate itself. Else compare candidate count(Descending).
    */
  public List<String> topKFrequentSimple(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    List<String> candidates = new ArrayList<>(map.keySet());
    Collections.sort(
        candidates,
        (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));

    return candidates.subList(0, k);
  }
}
