package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-ladder/description/
See the picture in Eclipse "word_ladder".jpg

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time. Each transformed word must exist in the word list.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
========================================================Example1=================================================================
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
========================================================Example2=================================================================
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

====================================================Initial Thinking=============================================================
Solution is about permuting beginWord with 1 letter change and go all the way.
At one point endWord might or might not match.
====================================================Solution Approach============================================================
1) Take the beginWord,
2) Change the first character from a-z loop it and see if matches with wordList or Dictionary.
3) If match found push it to queue. Do it for all the characters for beginword.
Now the structure is like Graph(not n-ary tree)... One root node(visited) with multiple child node to visit.
4) Do this operation level by level for all words.
5) Level Order Traversal or BFS is best, because we need the shortest length.
6) If we need the longest length. Then right option is recursion.
 */
public class WordLadderBFS {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Deque<String> q = new ArrayDeque<>();
    Set<String> dictionary = new HashSet<>(wordList);
    q.offer(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int level = 2;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        String curr = q.poll();
        for (int i = 0; i < curr.length(); i++) {
          for (char c = 'a'; c <= 'z'; c++) {
            String newWord = curr.substring(0, i) + c + curr.substring(i + 1);
            if (dictionary.contains(newWord)) {
              if (newWord.equals(endWord)) return level;
              if (visited.contains(newWord)) continue;
              visited.add(newWord);
              q.offer(newWord);
            }
          }
        }
      }
      level++;
    }
    return 0;
  }
}
