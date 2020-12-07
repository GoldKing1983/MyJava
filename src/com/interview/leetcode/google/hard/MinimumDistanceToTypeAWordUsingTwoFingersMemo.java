package com.interview.leetcode.google.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceToTypeAWordUsingTwoFingersMemo {
  int distance(int[] f1, int[] f2) {
    if (f1 == null || f2 == null) {
      return 0;
    }
    return Math.abs(f1[0] - f2[0]) + Math.abs(f1[1] - f2[1]);
  }

  Map<Character, int[]> keyMap = new HashMap<>();
  Map<String, Integer> dpCache = new HashMap<>();

  public int minimumDistance(String word) {
    char curr = 'A';
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 6; j++) {
        keyMap.put(curr, new int[] {i, j});
        if (curr == 'Z') break;
        curr++;
      }
    }
    return solve(null, null, 0, word);
  }

  int solve(int[] f1, int[] f2, int index, String word) {
    if (index == word.length()) return 0;

    String key = Arrays.toString(f1) + ";" + Arrays.toString(f2) + ";" + index;
    if (dpCache.containsKey(key)) return dpCache.get(key);
    int f1Use =
        distance(f1, keyMap.get(word.charAt(index)))
            + solve(keyMap.get(word.charAt(index)), f2, index + 1, word);
    int f2Use =
        distance(f2, keyMap.get(word.charAt(index)))
            + solve(f1, keyMap.get(word.charAt(index)), index + 1, word);
    int output = Math.min(f1Use, f2Use);
    dpCache.put(key, output);
    return output;
  }
}
