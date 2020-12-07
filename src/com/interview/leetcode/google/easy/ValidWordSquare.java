package com.interview.leetcode.google.easy;

import java.util.List;

/*
https://leetcode.com/problems/valid-word-square/
See Also WordSquares

Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the kth row and column read the exact same string,
where 0 ≤ k < max(numRows, numColumns).

Note:
The number of words given is at least 1 and does not exceed 500. Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.

Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]

Output:true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.


Input:
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]

Output:true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".

Therefore, it is a valid word square.

Input:
[
  "ball",
  "area",
  "read",
  "lady"
]

Output: false

Explanation: The third row reads "read" while the third column reads "lead".

Therefore, it is NOT a valid word square.

=========================================================Solution Approach=========================================================
Simply check for each row and columns, return false if not match.



 */
public class ValidWordSquare {
  public boolean validWordSquare(List<String> words) {
    if (words == null || words.isEmpty()) return true;

    int totalWords = words.size();
    for (int i = 0; i < totalWords; i++) {
      String currentWord = words.get(i);
      for (int j = 0; j < currentWord.length(); j++) {
        if (j >= totalWords) return false; // Ex: ["abc","b"]

        /*
         * ["ball",
         *  "asee",
         *  "let",
         *  "lep"]
         */
        if (words.get(j).length() <= i) return false;

        if (words.get(j).charAt(i) == currentWord.charAt(j)) continue;

        return false;
      }
    }
    return true;
  }
}
