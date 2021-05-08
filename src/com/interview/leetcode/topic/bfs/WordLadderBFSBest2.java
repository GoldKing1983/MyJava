package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-ladder/description/

1) endWordQ.contains(permutatedWord) takes O(n) operation, avoiding that by using set (beginWordSet and endWordSet).
2) Every time q operation happens by moving data from beginWordSet to q.   

 */


public class WordLadderBFSBest2 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dictionary = new HashSet<>(wordList);

    if (!dictionary.contains(endWord)) return 0;

    Set<String> beginWordSet = new HashSet<>();
    Set<String> endWordSet = new HashSet<>();

    beginWordSet.add(beginWord);
    dictionary.remove(beginWord);

    endWordSet.add(endWord);
    dictionary.remove(endWord);

    int level = 1;

    while (!beginWordSet.isEmpty() && !endWordSet.isEmpty()) {
      level++;

      // consider startQ as base.. if startQSize is big, then swap.. endQ(smaller) to startQ and vice-versa
      if (beginWordSet.size() > endWordSet.size()) {
        Set<String> tmpQ = beginWordSet;
        beginWordSet = endWordSet;
        endWordSet = tmpQ;
      }

      // Fill q from beginWordSet. 
      Deque<String> beginWordQ = new ArrayDeque<>();
      for (String beginWordFromSet : beginWordSet) beginWordQ.offer(beginWordFromSet);
      beginWordSet.clear(); // clear set, because it will be filled with next permutation word.

      int size = beginWordQ.size();
      while (size-- > 0) {
        String currWord = beginWordQ.poll();
        for (int i = 0; i < currWord.length(); ++i) {
          for (char c = 'a'; c <= 'z'; ++c) {
            String permutatedWord = currWord.substring(0, i) + c + currWord.substring(i + 1);

            if (endWordSet.contains(permutatedWord)) return level; // major change. Now we refer endWordSet instead of endWord

            if (!dictionary.contains(permutatedWord)) continue;

            dictionary.remove(permutatedWord); // avoid visited logic by removing the permutatedWord from dictionary.

            beginWordSet.add(permutatedWord);
          }
        }
      }
    }
    return 0;
  }
}
