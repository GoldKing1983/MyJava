package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/partition-labels/

A string S of lowercase letters is given. We want to partition this string into as many
parts as possible so that each letter appears in at most one part, and return a list of
integers representing the size of these parts.

Ex1: abad -- window1 is from a to a and window2 is d
Let's try to repeatedly choose the smallest left-justified partition. Consider the first label,
say it's 'a'. The first partition must include it, and also the last occurrence of 'a'.
However, between those two occurrences of 'a', there could be other labels that make the
minimum size of this partition bigger
Ex2: ababd -- window1 is from a to b and window2 is d

 */
public class PartitionLabels {
  // In first pass save the highest index of character from left to right.
  // In second pass from left to right make sure i<=max index
  public List<Integer> partitionLabels(String S) {
    int[] cache = new int[26];
    for (int i = 0; i < S.length(); i++) cache[S.charAt(i) - 'a'] = i;
    int maxPartitionWindow = Integer.MIN_VALUE, lastResultIndex = -1;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < S.length(); i++) {
      maxPartitionWindow = Math.max(maxPartitionWindow, cache[S.charAt(i) - 'a']);
      if (maxPartitionWindow == i) {
        result.add(i - lastResultIndex);
        lastResultIndex = i;
      }
    }
    return result;
  }
}
