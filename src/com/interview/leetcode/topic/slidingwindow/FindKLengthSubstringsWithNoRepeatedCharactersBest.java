package com.interview.leetcode.topic.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/

1) Almost same code as LongestSubstringWithoutRepeatingCharacters.
2) Here we increment uniqueCount instead of finding maxWindow.
=======================================================Data Flow Analysis========================================================
inputString : "havefunonleetcode"
k = 5

[h, a, v, e, f] 1
[h, a, v, e, f, u] 2
[h, a, v, e, f, u, n] 3
[h, a, v, e, f, u, n, o] 4
[e, t, c, o, d] 5
[e, t, c, o, d] 6



 */
public class FindKLengthSubstringsWithNoRepeatedCharactersBest {
  public int numKLenSubstrNoRepeats(String s, int K) {
    int uniqueCount = 0;
    Set<Character> set = new HashSet<>();
    for (int left = 0, right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      if (set.contains(rightChar)) { // duplicate. shrink window.
        char leftChar = s.charAt(left);
        while (leftChar != rightChar) {
          set.remove(leftChar);
          left++;
          leftChar = s.charAt(left);
        }
        left++; // shrink to "previous index of duplicate" + 1.
      } else {
        set.add(rightChar);
      }
      if (set.size() >= K) uniqueCount++;

    }
    return uniqueCount;
  }

}
