package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
1) Given a dictionary of words and inputString find whether inputString can be formed with dictionary of words.
2) dictionary can contain duplicate. Each word can be used only once.

Ex1: dict = [foo, ba, r, ba, z] inputString="foobarbaz" output: true
Ex2: dict = [foo, ba, r, z]     inputString="foobarbaz" output: false... Because ba occurs one time only and it is used already.  
 */
public class AmazonOnlineTestWordBreak {

  private static boolean isValid(String inputWord, Map<String, Integer> dictionary) {

    Deque<String> q = new ArrayDeque<>();
    q.offer(inputWord);
    while (!q.isEmpty()) {
      String currentString = q.poll();
      int n = currentString.length();
      for (int i = 0; i < n; i++) {

        String prefixString = currentString.substring(0, i + 1);
        
        if (!dictionary.containsKey(prefixString) || dictionary.get(prefixString) <= 0) continue;
        dictionary.put(prefixString, dictionary.get(prefixString) - 1);

        String suffixString = currentString.substring(i + 1, n);
        if (dictionary.containsKey(suffixString) && dictionary.get(suffixString) > 0) return true;

        q.offer(suffixString);
      }
    }
    return false;

  }

  public static void main(String[] args) {
    String[] dict = {"foo", "ba", "r", "ba", "z"};
    String inputString = "foobarbaz";
    Map<String, Integer> map = new HashMap<>();
    for (String word : dict) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    System.out.println(isValid(inputString, map));

    String[] dict1 = {"foo", "ba", "r", "z"};
    map = new HashMap<>();
    for (String word : dict1) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    System.out.println(isValid(inputString, map));

  }
}
