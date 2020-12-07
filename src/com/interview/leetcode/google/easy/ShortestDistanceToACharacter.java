package com.interview.leetcode.google.easy;

import java.util.Arrays;

/*
https://leetcode.com/problems/shortest-distance-to-a-character/

Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

==========================================================Solution Approach=========================================
1) from leftToRight update the distance.
2) from rightToLeft update the distance.
3) Result is minimum of leftToRight and rightToLeft position in that character.
==============================================================Data Flow Analysis=========================================
Input: S = "lovelov", C = 'e'
Output: [3,2,1,0,1,2,3]

	S       =  l  o  v  e  l  o  v
leftToRight = [∞, ∞, ∞, 0, 1, 2, 3]
rightToLeft = [3, 2, 1, 0, ∞, ∞, ∞]
			  ====================
Output      = [3, 2, 1, 0, 1, 2, 3
==============================================================Data Flow Analysis=========================================
Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

   S        =  l  o  v  e  l  e  e  t  c  o  d  e
leftToRight = [∞, ∞, ∞, 0, 1, 0, 0, 1, 2, 3, 4, 0]
rightToLeft = [3, 2, 1, 0, 1, 0, 0, 4, 3, 2, 1, 0]
			  =====================================
Output      = [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
============================================================================================================================
 */
public class ShortestDistanceToACharacter {
  public int[] shortestToChar(String S, char C) {
    int n = S.length();

    int[] fromLeftToRight = new int[n];
    Arrays.fill(fromLeftToRight, Integer.MAX_VALUE);

    int[] fromRightToLeft = new int[n];
    Arrays.fill(fromRightToLeft, Integer.MAX_VALUE);

    boolean nothingMatched = true;
    for (int left = 0, matchLocation = 0; left < n; left++) {
      if (S.charAt(left) == C) {
        matchLocation = left;
        nothingMatched = false;
      }
      if (nothingMatched) {
        continue; // Nothing found till from left side. So Integer.MAX_VALUE stays
      }
      fromLeftToRight[left] = left - matchLocation;
    }

    nothingMatched = true;
    for (int right = n - 1, matchLocation = 0; right >= 0; right--) {
      if (S.charAt(right) == C) {
        matchLocation = right;
        nothingMatched = false;
      }
      if (nothingMatched) {
        continue; // Nothing found till from right side. So Integer.MAX_VALUE stays
      }
      fromRightToLeft[right] = matchLocation - right;
    }

    int[] result = new int[n];
    for (int left = 0; left < n; left++) {
      result[left] = Math.min(fromLeftToRight[left], fromRightToLeft[left]);
    }

    return result;
  }
}
