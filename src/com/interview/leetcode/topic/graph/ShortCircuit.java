package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://binarysearch.com/problems/Short-Circuit
 */
public class ShortCircuit {



  public boolean solve(String[] words) {
    if (words == null || words.length == 0) return false;
    int[] startCount = new int[26];
    int[] endCount = new int[26];
    Map<Character, List<String>> charToWordMap = new HashMap<>();
    for (String word : words) {
      word = word.toLowerCase();
      charToWordMap.putIfAbsent(word.charAt(0), new ArrayList<String>());
      charToWordMap.get(word.charAt(0)).add(word);
      startCount[word.charAt(0) - 'a']++;
      endCount[word.charAt(word.length() - 1) - 'a']++;
    }
    /*
    ["hair", "
     racket", "
     touch", 
    
     stCount
     h - 1
     r - 1
     t - 1
    
     end 
      r - 1
      t - 1
      h - 1
    
    
    */

    for (int i = 0; i < 26; i++) {
      if (startCount[i] != endCount[i]) {
        return false;
      }
    }
    Set<String> visited = new HashSet<>();
    return dfs(words.length, words[0].toLowerCase(), words[0].toLowerCase(), visited,
        charToWordMap);
  }

  /*
   1. start == end condition => cycle
   2. visited == n all words
  
   visited -> raket touch
       ["chair", "height", "racket", "touch", "tunic"]
       f(raket, raket)
       /
      f(rak, touch)
      /
      f()
  
  */
  private boolean dfs(int n, String start, String current, Set<String> visited,
      Map<Character, List<String>> charToWordMap) {
    if (current.equals(start) && visited.contains(current)) {
      return n == visited.size();
    }
    visited.add(current);
    for (String neighbor : charToWordMap.getOrDefault(current.charAt(current.length() - 1),
        new ArrayList<String>())) {
      if ((neighbor.equals(start) || !visited.contains(neighbor))
          && dfs(n, start, neighbor, visited, charToWordMap)) {
        return true;
      }
    }
    visited.remove(current);
    return false;
  }
}
