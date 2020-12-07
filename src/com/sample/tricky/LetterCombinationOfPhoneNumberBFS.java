package com.sample.tricky;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
See "LetterCombinationOfPhoneNumber.png"
===========================================================Requirement===========================================================
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
========================================================Solution Approach========================================================
1) Push Empty to result.
2) Ex: 23.
3) Take 2s word "abc".
4) For each of previousCombo add eachCharacter of "abc"
5) Take 3s word "def".
6) For each of previousCombo add eachCharacter of "def".
=======================================================Data Flow Analysis========================================================
[]
a
b
c
ad
ae
af
bd
be
bf
cd
ce
cf
=================================================================================================================================
 */
public class LetterCombinationOfPhoneNumberBFS {

  private static final String[] LETTERS =
      {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    if ("".equals(digits)) return new ArrayList<>();
    LinkedList<StringBuilder> q = new LinkedList<>();
    q.offer(new StringBuilder());
    for (Character d : digits.toCharArray()) {
      String word = LETTERS[d - '0'];
      int size = q.size();
      while (size-- > 0) {
        StringBuilder previousCombo = q.poll();
        for (Character c : word.toCharArray()) {
          StringBuilder newCombo = new StringBuilder(previousCombo);
          newCombo.append(c);
          q.offer(newCombo);
        }
      }
    }
    List<String> result = new ArrayList<>();
    while (!q.isEmpty()) result.add(q.poll().toString());
    return result;
  }
}
