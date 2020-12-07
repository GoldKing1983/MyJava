package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/reorganize-string/
 Similar to TaskSchedulerPriorityQueueApproach

Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each
other are not the same. If possible, output any possible result.  If not possible, return the empty string.

Input: S = "aab"
Output: "aba"

Input: S = "aaab"
Output: ""

Input: S ="vvvlo"  ===> why we need PriorityQueue
Output: "vlvov"
================================================Solution Approach====================================================
1) Idea is to add "countsOfEachCharacter" to a pQ and sort based on the highest frequency.
2) If any characterCount goes beyond (n+1)/2. Ex: "aaab". n=4. 5/2=2.  Then we cannot re-organize. return "". 
This is the only exit condition. Rest of all the cases we can form possibleResult.
3) Pick "currentChar" from pQ.
4) If the "lastResultChar" is different from "currentChar", then insert the "currentChar" to result.
5) Else, poll "nextChar" and insert into result. Offer "currentChar" back to pQ.

 */
public class ReorganizeString {
  public String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    for (char c : s.toCharArray()) {
      int count = map.getOrDefault(c, 0) + 1;
      if (count > (n + 1) / 2) return "";
      map.put(c, count);
    }
    Queue<int[]> pQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (Map.Entry<Character, Integer> entry : map.entrySet())
      pQ.add(new int[] {entry.getKey(), entry.getValue()});

    StringBuilder result = new StringBuilder();
    while (!pQ.isEmpty()) {
      int[] current = pQ.poll();
      char currentChar = (char) current[0];

      if (result.length() == 0 || currentChar != result.charAt(result.length() - 1)) {
        result.append((char) current[0]);
        current[1]--;
        if (current[1] > 0) pQ.add(current);
      } else {
        int[] next = pQ.poll();
        result.append((char) next[0]);
        next[1]--;
        if (next[1] > 0) pQ.add(next);
        pQ.add(current);
      }
    }
    return result.toString();
  }
}
