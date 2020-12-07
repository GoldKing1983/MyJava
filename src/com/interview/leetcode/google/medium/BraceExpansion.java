package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/brace-expansion/

Requirements:
1) For input "{a,b,c}d{e,f}", output ["ade", "adf", "bde", "bdf", "cde", "cdf"].
2) Return all words that can be formed in this manner, in lexicographical order.
Note: In Between "} {" whatever comes considered as single string. So no parsing needed.
=============================================================================================================================
Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]

Input: "{x,a}c,r{d,e}f"
Output: ["acdf","acef","xcdf","xcef"]

Input: "{x,a}c,r{d,e}f"
Output:["ac,rdf","ac,ref","xc,rdf","xc,ref"]
"c,r" considered as one complete String.
==========================================Solution Approach===================================================================
Step1: Split the "complex-word" into List<List<String>>
  1a): On seeing '{' 2 things are happening.
  	   1aa): Add any non-empty word to wordList.
  	   1ab): Collect word between "{" and "}". Split them by ",". Sort it. Add it to wordList
  1b): Add any non-empty word to wordList. Ex: Corner Case "abc"
Step2: Permute using BFS.

==================================Data Flow Analysis=============================
Input: "abc{e,d}xyz" Output: [abcdxyz, abcexyz]

WordsList: [[abc], [d, e], [xyz]]. Size: 3
=========Current Queue Values: []========
Current Combo: . Going to Permute with: [abc]
New Combo: abc
=========Current Queue Values: [abc]========
Current Combo: abc. Going to Permute with: [d, e]
New Combo: abcd
New Combo: abce
=========Current Queue Values: [abcd, abce]========
Current Combo: abcd. Going to Permute with: [xyz]
New Combo: abcdxyz
Current Combo: abce. Going to Permute with: [xyz]
New Combo: abcexyz
=========Final Queue Values: [abcdxyz, abcexyz]========
=========================================================================================================================


 */
public class BraceExpansion {
  public String[] expand(String s) {
    List<List<String>> wordsList = new ArrayList<>();
    // Ex1: "xyz", Ex2:{a,b,c}xyz{g,h}==> topWord=xyz
    StringBuilder currentWord = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      if (s.charAt(i) == '{') {
        if (currentWord.length() > 0) {
          wordsList.add(Arrays.asList(currentWord.toString()));
          currentWord = new StringBuilder();
        }
        i++;
        StringBuilder sb = new StringBuilder();
        while (s.charAt(i) != '}') sb.append(s.charAt(i++));
        String[] words = sb.toString().split(",");
        Arrays.sort(words);
        wordsList.add(Arrays.asList(words));
      } else currentWord.append(s.charAt(i) + "");
      i++;
    }
    if (currentWord.length() > 0) wordsList.add(Arrays.asList(currentWord.toString()));
    Queue<StringBuilder> q = new LinkedList<>();
    q.offer(new StringBuilder());

    for (List<String> words : wordsList) {
      int size = q.size();
      for (i = 0; i < size; i++) {
        StringBuilder oldCombo = q.poll();
        for (String ss : words) {
          StringBuilder newCombo = new StringBuilder(oldCombo);
          newCombo.append(ss);
          q.offer(newCombo);
        }
      }
    }

    String[] result = new String[q.size()];
    for (int j = 0; j < result.length; j++) result[j] = q.poll().toString();

    return result;
  }
}
