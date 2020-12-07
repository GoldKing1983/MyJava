package com.interview.leetcode.topic.string;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/jewels-and-stones/description/

1) J represents the types of stones that are jewels.
2) S representing the stones.
3) The letters in J are guaranteed distinct.

Input: J = "aA", S = "aAAbbbb", Output: 3
 */
public class JewelsAndStones {
  // O(n)
  public int numJewelsInStones(String jewel, String stone) {
    Set<Character> jewels = new HashSet<>();
    for (Character c : jewel.toCharArray()) jewels.add(c);
    int jewelCount = 0;
    for (Character c : stone.toCharArray()) {
      if (jewels.contains(c)) jewelCount++;
    }
    return jewelCount;
  }

  // O(n) . Save a-z in 0-25 and A-Z in 26-51
  public int numJewelsInStonesUsingBucket(String jewel, String stone) {
    boolean[] bucket = new boolean[26 + 26];
    for (char c : jewel.toCharArray()) {
      int index = Character.isLowerCase(c) ? c - 'a' : c - 'A' + 26;
      bucket[index] = true;
    }
    int count = 0;
    for (char c : stone.toCharArray()) {
      int index = Character.isLowerCase(c) ? c - 'a' : c - 'A' + 26;
      if (bucket[index]) count++;
    }

    return count;
  }

  // O(n^2)
  public int numJewelsInStonesWithoutSet(String jewel, String stone) {
    int jewelCount = 0;
    for (int i = 0; i < stone.length(); i++) {
      int jewelIndex = jewel.indexOf(stone.charAt(i));
      if (jewelIndex != -1) jewelCount++;
    }
    return jewelCount;
  }
}
