package com.interview.leetcode.topic.string;

import java.util.*;

/*
===========================================================Requirement===========================================================
1) Given a string "s" and dictionary of words,
2) construct possible combination of sentence "s" using dictionary of word.
3) Return all such possible combination of "s".

Note: The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
============================================================Example1=============================================================
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
============================================================Example2=============================================================
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
============================================================Example3=============================================================
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
========================================================Solution Approach========================================================
1) Based on WordBreakQueue.
2) When a result is formed, instead of returning true. Add substring to result.
3) visited logic is not needed, because alternate path need to be explored.

 */
public class WordBreakII {
  public List<String> wordBreak(String s, List<String> wordDictList) {
    Set<String> wordDict = new HashSet<>(wordDictList);

    Deque<String> q = new ArrayDeque<>();
    Deque<StringBuilder> result = new ArrayDeque<>();

    result.offer(new StringBuilder());
    q.offer(s);

    List<String> finalResult = new ArrayList<>();

    while(!q.isEmpty()) {
      String currentString = q.poll();
      StringBuilder currentResult = result.poll();

      int n = currentString.length();
      for(int i=0; i<n; i++) {
        String prefixString = currentString.substring(0,i+1);
        if(wordDict.contains(prefixString)) {
          StringBuilder updatedResult = new StringBuilder(currentResult.toString());
          updatedResult.append(prefixString).append(" ");
          String suffixString = currentString.substring(i+1, n);

          q.offer(suffixString);
          result.offer(updatedResult);

          if (i + 1 == n) // reached end.
            finalResult.add(updatedResult.toString().trim());
        }
      }

    }
    return finalResult;
  }
}
