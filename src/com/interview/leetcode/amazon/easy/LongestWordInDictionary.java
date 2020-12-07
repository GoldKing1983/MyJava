package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
========================================================================================================================
https://leetcode.com/problems/longest-word-in-dictionary/

Given a list of strings words representing an English Dictionary,
a) find the "longestWord" that can be built from dictionary,
b) build the "longestWord" by one character at a time by other words in words. If there is more than one possible answer,
return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Input:  words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:  The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:  Both "apply" and "apple" can be built from other words in the dictionary. However,
"apple" is lexicographically smaller than "apply".

=============================================Solution Approach================================================================
Handle 1 char word separately, because they are the source.
1) for 1 letter word, set verification is not needed. it can be add to set directly.
2) 1 letter word can be added to result, only when "result.length() == 0"

For the remaining word
1) If the prefix from "0 to n-2"(Ex: for "ap", "a" should exist. ) exists in set, add it to set.
2) The successful word can be added to result, only when "result.length()+1 == word.length".
i.e for that length, first word. Because words are sorted and we want smallest lexicographical order.
==============================================Data Flow Analysis===============================================================
input: ["a", "banana", "app", "appl", "ap", "apply", "apple"] output: "apple"

Sorted input: [a, ap, app, appl, apple, apply, banana]
============================================================================================================================
 */
public class LongestWordInDictionary {

  public String longestWord(String[] words) {
    Arrays.sort(words);
    Set<String> set = new HashSet<>();
    String result = "";
    for (String word : words) {
      if (word.length() == 1) {
        set.add(word);
        if (result.length() == 0) {
          result = word;
        }
      } else if (set.contains(word.substring(0, word.length() - 1))) {
        set.add(word);
        // Ex: "apply" is current..."already" apple is in result... So verify the length.
        if (result.length() + 1 == word.length()) {
          result = word;
        }
      }
    }
    return result;
  }
}
