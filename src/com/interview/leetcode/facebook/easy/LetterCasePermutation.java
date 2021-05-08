package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/letter-case-permutation/
https://www.educative.io/courses/grokking-the-coding-interview/xVlKmyX542P
===========================================================Requirement===========================================================
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

============================================================Example1=============================================================
Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
============================================================Example1=============================================================
Input: S = "3z4"
Output: ["3z4","3Z4"]
========================================================Solution Approach========================================================
1) Add inputString to result.
2) Parse each character of inputString. 
3) If currentChar is "alphabet", add "newPermutation" for each of previousResult by flipping case. 
=======================================================Data Flow Analysis========================================================
        result = a1b2
        
        === currentChar is a=== 
        a1b2 => previousResult
        A1b2
        === currentChar is b===
        a1b2 => previousResult
        A1b2 => previousResult
        a1B2
        A1B2
        
 */
public class LetterCasePermutation {
  public List<String> letterCasePermutation(String inputString) {
    List<StringBuilder> result = new ArrayList<>();
    result.add(new StringBuilder(inputString));

    for (int i = 0; i < inputString.length(); i++) {
      // if currentChar is number no change. ex: 1234
      char currentChar = inputString.charAt(i);
      if (Character.isDigit(currentChar)) continue;

      // iterate each of previous result
      int size = result.size();
      for (int j = 0; j < size; j++) {
        StringBuilder newPermutation = new StringBuilder(result.get(j));
        if (Character.isUpperCase(currentChar)) {
          newPermutation.setCharAt(i, Character.toLowerCase(currentChar));
        } else {
          newPermutation.setCharAt(i, Character.toUpperCase(currentChar));
        }
        result.add(newPermutation);
      }
    }
    List<String> finalResult = new ArrayList<>();
    for (StringBuilder s : result) finalResult.add(s.toString());
    return finalResult;

  }
}
