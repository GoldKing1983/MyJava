package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-ladder/description/

1) Based on "Bidirectional Permute".
2) The logic is almost same as WordLadderBFS.
3) "Permute" for startWord. "Permute" for endWord, whichever has lowest permutation count, take that as base for nextStart permutation. 

4) This reduces the number of permutations.
        
   ex: startWord has 4 permutation. Then that 4 will go another "x" permutation.
       lets say endWord has 1 permutation. This might lead to less permutation result path... 
       
=======================================================Data Flow Analysis========================================================
1) Initially size of both startQ(with startString added) and endQ(with endString added) is same.
2) Lets say we pick startQ as base and it has 4 permutation.
3) Now endQ act as startQ, because it has only 1 permutation. 
4) Swap logic continues till both queues are empty or result is found.       

Important Note: Since I am coming from left(beginWord) and right(endWord). Exit condition changes.
If (endWordQ.contains(permutatedWord)) return level 
 */


public class WordLadderBFSBest {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dictionary = new HashSet<>(wordList);

    if (!dictionary.contains(endWord)) return 0;

    Deque<String> beginWordQ = new ArrayDeque<>();
    Deque<String> endWordQ = new ArrayDeque<>();

    beginWordQ.offer(beginWord);
    dictionary.remove(beginWord);

    endWordQ.offer(endWord);
    dictionary.remove(endWord);

    int level = 1;

    while (!beginWordQ.isEmpty() && !endWordQ.isEmpty()) {
      level++;

      // consider startQ as base.. if startQSize is big, then swap.. endQ(smaller) to startQ and vice-versa
      if (beginWordQ.size() > endWordQ.size()) {
        Deque<String> tmpQ = beginWordQ;
        beginWordQ = endWordQ;
        endWordQ = tmpQ;
      }

      int size = beginWordQ.size();
      while (size-- > 0) {
        String currWord = beginWordQ.poll();
        for (int i = 0; i < currWord.length(); ++i) {
          for (char c = 'a'; c <= 'z'; ++c) {
            String permutatedWord = currWord.substring(0, i) + c + currWord.substring(i + 1);

            // major change. Now we refer endWordQ instead of endWord
            if (endWordQ.contains(permutatedWord)) return level; // this is an O(n) operation. change endWordQ to set. 

            if (!dictionary.contains(permutatedWord)) continue;

            dictionary.remove(permutatedWord); // avoid visited logic by removing the permutatedWord from dictionary.

            beginWordQ.offer(permutatedWord);
          }
        }
      }
    }
    return 0;
  }
}
