package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/

Given a non-empty string s and an integer k, rearrange the string such that the same characters
are at least distance k from each other. All input strings are given in lowercase letters.
If it is not possible to rearrange the string, return an empty string "".

Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least distance 3 from each other.

Input: s = "aaabc", k = 3
Output: ""
Explanation: It is not possible to rearrange the string.

Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.

===============================Solution Approach=========================================================================
1) Almost same as TaskSchedulerPriorityQueueApproach.
2) Sorting Logic : ascending of chars, if char matches, else go by count of char
2) In TaskScheduler if n is reached we add idle, here we return "".
===========================================================================================================================
 */
public class RearrangeStringKDistanceApart {
  public String rearrangeString(String s, int k) {
    if (k <= 1) return s;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    Queue<int[]> pQ = new PriorityQueue<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

    for (Map.Entry<Character, Integer> entry : map.entrySet())
      pQ.add(new int[] {entry.getKey(), entry.getValue()});

    StringBuilder result = new StringBuilder();
    while (!pQ.isEmpty()) {
      List<int[]> pendingChars = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        if (pQ.isEmpty() && !pendingChars.isEmpty()) return ""; // case: s="aaabc" k=3
        if (pQ.isEmpty() && pendingChars.isEmpty()) return result.toString(); // case: s="ab" k=3
        int[] current = pQ.poll();
        char currentChar = (char) current[0];
        result.append(currentChar);
        int currentCharCount = current[1];
        currentCharCount--;
        if (currentCharCount > 0) pendingChars.add(new int[] {currentChar, currentCharCount});
      }
      pQ.addAll(pendingChars);
    }
    return result.toString();
  }
}
