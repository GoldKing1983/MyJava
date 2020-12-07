package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/sentence-similarity-ii/

1) similarity relation is transitive
Ex: 	a -> b -> c

["a","c"]
["c","a"]
[["a","b"],["b","c"]]
Output: true

 */
public class SentenceSimilarityII {
  private Map<String, List<String>> adjMatrix;

  public boolean areSentencesSimilarTwo(
      String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) return false;
    adjMatrix = new HashMap<>();
    for (List<String> pair : pairs) {
      String key = pair.get(0);
      String value = pair.get(1);
      List<String> existing = adjMatrix.getOrDefault(key, new ArrayList<>());
      existing.add(value);
      adjMatrix.put(key, existing);

      existing = adjMatrix.getOrDefault(value, new ArrayList<>());
      existing.add(key);
      adjMatrix.put(value, existing);
    }
    for (int i = 0; i < words1.length; i++) {
      if (!doDFS(words1[i], words2[i], new HashSet<>())) return false;
    }
    return true;
  }

  private boolean doDFS(final String source, final String dest, Set<String> isVisited) {
    if (isVisited.contains(source)) return false;
    isVisited.add(source);
    if (source.equals(dest)) return true;
    if (adjMatrix.get(source) == null) return false;
    for (String node : adjMatrix.get(source)) {
      if (doDFS(node, dest, isVisited)) return true;
    }

    return false;
  }
}
