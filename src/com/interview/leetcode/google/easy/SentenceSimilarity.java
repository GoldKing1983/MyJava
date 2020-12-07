package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

1) similarity relation is not transitive

["great"]
["great"]
[["great","fine"]]
Output : true

["great","great"]
["fine","fine1"]
[["great","fine"],["fine1","great"]]


 */
public class SentenceSimilarity {
  public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) return false;
    Map<String, Set<String>> map = new HashMap<>();
    for (List<String> pair : pairs) {
      String key = pair.get(0);
      String value = pair.get(1);
      Set<String> existing = map.getOrDefault(key, new HashSet<>());
      existing.add(value);
      map.put(key, existing);

      existing = map.getOrDefault(value, new HashSet<>());
      existing.add(key);
      map.put(value, existing);
    }
    for (int i = 0; i < words1.length; i++) {
      String word1 = words1[i];
      String word2 = words2[i];
      if (word1.equals(word2)) continue;
      if (map.containsKey(word1)) {
        if (!map.get(word1).contains(word2)) {
          return false;
        }
        continue;
      }
      if (map.containsKey(word2)) {
        if (!map.get(word2).contains(word1)) {
          return false;
        }
      }
    }

    return true;
  }
}
