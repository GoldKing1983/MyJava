package com.interview.leetcode.topic.slidingwindow;

import java.util.HashMap;

/*
https://leetcode.com/problems/minimum-window-substring/description/
================================================================================================================
Requirement: Given String S and T, find the minimum window in S which will contain all the characters in T

This problem is similar to "PermutationInStringSlidingWindow" with one difference,
there windowSize==s1.length and here windowSize is variable.
==========KeyPoint==========================================================================================
Ex1: S = "AAB" T= "AB"
1) When A at index1 occurs. Initial thought would be to move left. But that is wrong. See Ex:2
2) Below code waits till to form "all elements" inside window.
3) So window1 would be "AAB".
4) Then left is shrinked. window2 is "AB".

Ex2: S="ABDBC" T="ABC".
1) When seeing B at index4, if I shrink, then I will lose A. So shrink only when complete window formed.
=======================================Solution Approach========================================================
Note1: Moving left and right
1) Keep left and right at 0.
2) Move right alone, till "all elements of s2" found in the first window.
3) Move left and right after first window reached.

Note2:How to update map and count of "noOfMatchingChar"
1) If a right char exists in searchString. Decrement the map count on char and increase noOfMatchingChar
2) If a left char exists in searchString. Increment the map count on char and decrease noOfMatchingChar

Logic : At any point when "noOfMatchingChar" == mapSize a result is found

=========================================================================================================================
Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"

ADOBEC ODEBANC
ECODEBANC
E CODEBANC
BANC

{A=1, B=1, C=1}
Doing Operation for A at index:0
Decrementing Map Count for: 'A'
{A=0, B=1, C=1}
Doing Operation for D at index:1
Doing Operation for O at index:2
Doing Operation for B at index:3
Decrementing Map Count for: 'B'
{A=0, B=0, C=1}
Doing Operation for E at index:4
Doing Operation for C at index:5
Decrementing Map Count for: 'C'
{A=0, B=0, C=0}
Window Found : ADOBEC
Shrinking Window by 1 index. Left moved to Index: 1. Incrementing Map Count for: 'A'
{A=1, B=0, C=0}
Doing Operation for O at index:6
Doing Operation for D at index:7
Doing Operation for E at index:8
Doing Operation for B at index:9
Doing Operation for A at index:10
Decrementing Map Count for: 'A'
{A=0, B=-1, C=0}
Window Found : DOBECODEBA
Window Found : OBECODEBA
Window Found : BECODEBA
Shrinking Window by 1 index. Left moved to Index: 4. Incrementing Map Count for: 'B'
{A=0, B=0, C=0}
Window Found : ECODEBA
Window Found : CODEBA
Shrinking Window by 1 index. Left moved to Index: 6. Incrementing Map Count for: 'C'
{A=0, B=0, C=1}
Doing Operation for N at index:11
Doing Operation for C at index:12
Decrementing Map Count for: 'C'
{A=0, B=0, C=0}
Window Found : ODEBANC
Window Found : DEBANC
Window Found : EBANC
Window Found : BANC
Shrinking Window by 1 index. Left moved to Index: 10. Incrementing Map Count for: 'B'
{A=0, B=1, C=0}
=========================================================================================================================
 */
public class MinimumWindowSubstringSlidingWindow {

  public String minWindow(String inputString, String searchString) {
    int left = 0, noOfMatchingChar = 0, minWindowSize = Integer.MAX_VALUE;
    String result = "";
    HashMap<Character, Integer> freqMap = new HashMap<>();

    if (inputString.length() < searchString.length() || inputString.length() == 0) return "";

    // initialize freqMap
    for (char c : searchString.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);


    for (int right = 0; right < inputString.length(); right++) {
      char rightChar = inputString.charAt(right);
      if (freqMap.containsKey(rightChar)) {
        freqMap.put(rightChar, freqMap.get(rightChar) - 1);

        if (freqMap.get(rightChar) >= 0) noOfMatchingChar++;
        if (noOfMatchingChar != searchString.length()) continue;

        while (true) { // Capture Window and Shrink. 
          int currentWindowSize = right - left + 1;
          if (currentWindowSize < minWindowSize) {
            result = inputString.substring(left, right + 1);
            minWindowSize = currentWindowSize;
          }

          char leftChar = inputString.charAt(left++); //Left is moved when a window is found.
          if (freqMap.containsKey(leftChar)) {
            freqMap.put(leftChar, freqMap.get(leftChar) + 1);
            if (freqMap.get(leftChar) > 0) {
              noOfMatchingChar--; // Shrink stops when noOfMatchingChar size changed
              break;
            }
          }
        }
      }
    }
    return result;
  }

}
