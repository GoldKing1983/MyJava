package com.interview.leetcode.google.hard;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/

==========================Solution Approach================
1) Permute all the combination of keys pressed.
2) This is an perfect example of binary recursion, because of requirement to use 2 fingers.

This is not an optimized code. Ex: If input is 'HA'. 4 combo's are created as per binary tree. Actually 1 is enough.
For 3 characters 8 combinations are created.
It is actually "TreeHeight=numberOfHeight". So for 10 character word. 2^10 combinations are created.
====================================Data Flow Analysis====================================
word = 'NEW' output= 3

At Level 0===Chosen Characters=== f1 : ' ', f2: ' '
At Level 1===Chosen Characters=== f1 : 'N', f2: ' '
At Level 2===Chosen Characters=== f1 : 'E', f2: ' '
At Level 3===Chosen Characters=== f1 : 'W', f2: ' '
Combination is Found
At Level 3===Chosen Characters=== f1 : 'E', f2: 'W'
Combination is Found
At Level 2===Chosen Characters=== f1 : 'N', f2: 'E'
At Level 3===Chosen Characters=== f1 : 'W', f2: 'E'
Combination is Found
At Level 3===Chosen Characters=== f1 : 'N', f2: 'W'
Combination is Found
At Level 1===Chosen Characters=== f1 : ' ', f2: 'N'
At Level 2===Chosen Characters=== f1 : 'E', f2: 'N'
At Level 3===Chosen Characters=== f1 : 'W', f2: 'N'
Combination is Found
At Level 3===Chosen Characters=== f1 : 'E', f2: 'W'
Combination is Found
At Level 2===Chosen Characters=== f1 : ' ', f2: 'E'
At Level 3===Chosen Characters=== f1 : 'W', f2: 'E'
Combination is Found
At Level 3===Chosen Characters=== f1 : ' ', f2: 'W'
Combination is Found


 */
public class MinimumDistanceToTypeAWordUsingTwoFingersRecursion {
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

  int solve(int[] f1, int[] f2, int index, String word) {
    if (index == word.length()) return 0;
    int[] keysAtIndex = keyMap.get(word.charAt(index));
    int f1Use = distance(f1, keysAtIndex) + solve(keysAtIndex, f2, index + 1, word);
    int f2Use = distance(f2, keysAtIndex) + solve(f1, keysAtIndex, index + 1, word);
    return Math.min(f1Use, f2Use);
  }
}
