package com.interview.leetcode.topic.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    for (String word : banned) {
      if (map.containsKey(word)) {
        map.remove(word);
      }
    }
    String res = null;
    for (String word : map.keySet()) {
      if (res == null || map.get(word) > map.get(res)) {
        res = word;
      }
    }
    return res;
  }

  public String mostCommonWord1(String paragraph, String[] banned) {
    String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    Set<String> bannedSet = new HashSet<>();
    for(String banString : banned) bannedSet.add(banString);

    String res = null;
    for (String word : map.keySet()) {
      if(bannedSet.contains(word)) continue;
      if (res == null || map.get(word) > map.get(res)) {
        res = word;
      }
    }
    return res;
  }
}
}
