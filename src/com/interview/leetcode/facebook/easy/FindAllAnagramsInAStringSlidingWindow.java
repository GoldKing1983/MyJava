package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

Same code as PermutationInStringSlidingWindow. Instead of returning true, it finds "allIndexOfStartPattern".

1) Initially for "patternString" do decrement in Map. We are doing decrement instead of increment, because when I
form/do initialWindow/slidingWindow i can remove/decrement on leftSide and add/increment on rightSide.

 
 */
public class FindAllAnagramsInAStringSlidingWindow {

  public List<Integer> findAnagrams(String input, String pattern) {
    List<Integer> result = new ArrayList<>();
    if (input.length() < pattern.length()) return result;
    int right = 0;
    int matchCount = 0;

    Map<Character, Integer> freqMap = new HashMap<>();
    for (Character c : pattern.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c, 0) - 1);

    // Forming initial Window. Move only right
    while (right < pattern.length()) {
      Character rightChar = input.charAt(right);
      if (freqMap.containsKey(rightChar)) {
        int countDecremented = freqMap.get(rightChar) + 1;
        freqMap.put(rightChar, countDecremented);
        if (countDecremented == 0) matchCount++;
      }
      right++;
    }
    if (matchCount == freqMap.size()) result.add(0);

    // Shrink/EnLarge the Window.
    for (int left = 0; right < input.length(); left++, right++) {
      Character leftChar = input.charAt(left);
      Character rightChar = input.charAt(right);
      if (freqMap.containsKey(leftChar)) {
        int leftCharCountIncremented = freqMap.get(leftChar) - 1; // removing from window so -
        freqMap.put(leftChar, leftCharCountIncremented);
        if (leftCharCountIncremented + 1 == 0) matchCount--;
      }
      if (freqMap.containsKey(rightChar)) {
        int rightCharCountDecremented = freqMap.get(rightChar) + 1; // adding to window so +
        freqMap.put(rightChar, rightCharCountDecremented);
        if (rightCharCountDecremented == 0) matchCount++;
      }
      if (matchCount == freqMap.size()) result.add(left + 1);
    }
    return result;
  }
}
