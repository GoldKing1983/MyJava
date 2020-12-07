package com.interview.leetcode.google.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceToTypeAWordUsingTwoFingersRecursionPrint {
  int distance(int[] f1, int[] f2) {
    if (f1 == null || f2 == null) {
      return 0;
    }
    return Math.abs(f1[0] - f2[0]) + Math.abs(f1[1] - f2[1]);
  }

  Map<Character, int[]> keyMap = new HashMap<>();

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

  private char getCharForIndex(int[] index) {
    if (index == null) return ' ';
    int x = index[0];
    int y = index[1];
    char startChar = 'A';
    int totalIncrement = (x * 6) + y;
    while (totalIncrement-- > 0) startChar++;
    return startChar;
  }

  int level = -1;

  int solve(int[] f1, int[] f2, int index, String word) {
    level++;
    System.out.println(
        "At Level "
            + level
            + "===Chosen Characters=== f1 : '"
            + getCharForIndex(f1)
            + "', f2: '"
            + getCharForIndex(f2)
            + "'");
    if (index == word.length()) {
      System.out.println("Combination is Found");
      return 0;
    }
    int[] keysAtIndex = keyMap.get(word.charAt(index));
    int f1Use = distance(f1, keysAtIndex) + solve(keysAtIndex, f2, index + 1, word);
    level--;
    int f2Use = distance(f2, keysAtIndex) + solve(f1, keysAtIndex, index + 1, word);
    level--;
    return Math.min(f1Use, f2Use);
  }
}
