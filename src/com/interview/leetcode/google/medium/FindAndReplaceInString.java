package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*

https://leetcode.com/problems/find-and-replace-in-string/

1) if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff",
then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
So result is "abffff"

2) S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee",
as well as another replacement operation i = 2, x = "ec", y = "ffff",
this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
So result is "eeeffff"
================================================================================================================
Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".

matchIndex = [0, -1, 1, -2]
For Index:0 replacing with:eee
For Index:1 adding from inputStr:b
For Index:2 replacing with:ffff
For Index:3 nothing added/replaced

================================================================================================================
Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
"ec" doesn't starts at index 2 in the original S, so we do nothing.

matchIndex = [0, -2, -1, -1]
For Index:0 replacing with:eee
For Index:1 nothing added/replaced
For Index:2 adding from inputStr:c
For Index:3 adding from inputStr:d
========================================Solution Approach======================================================
1) Fill matchIndex with 0,-1 and -2
if >= 0  -> Then replacement needed with source.
if -1 -> Then inputStr "character" will be added.
if -2 -> Nothing needed to be added to result. Because it is extension of more than one character replacement in source.

 */
public class FindAndReplaceInString {
  public String findReplaceString(
      String inputStr, int[] indexes, String[] sources, String[] targets) {
    int n = inputStr.length();
    int[] matchIndex = new int[n];
    Arrays.fill(matchIndex, -1);

    for (int i = 0; i < indexes.length; ++i) {
      int j = indexes[i];
      if (inputStr.substring(j, j + sources[i].length()).equals(sources[i])) {
        matchIndex[j] = i;
        for (int k = j + 1; k < j + sources[i].length(); k++) matchIndex[k] = -2;
      }
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (matchIndex[i] >= 0) result.append(targets[matchIndex[i]]);
      else if (matchIndex[i] == -1) result.append(inputStr.charAt(i));
    }
    return result.toString();
  }
}
