package com.interview.leetcode.linkedin.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-ladder/description/

1) Based on "Bidirectional Search".
2) The logic is almost same as WordLadderBFS.
3) The difference is we switch the "begin to end and end to begin" when the beginSize is greater than endSize.
4) This reduces the number of permutations.
		Ex1: beginSet has 1Element and endSet has 1Element.
		Now I can go from "begin to end" or "end to begin" both gives same time complexity.
		ex: dict=[cat, bat] begin="bat" end="cat".

 		Ex2: beginSet has 2Element and endSet has 1Element.
 		In this case beginSet needs to create lot of permutations to verify whether endSet has the combo.
 		Trick is in above case, I can simply invert the startSet to endSet and endSet to startSet.
 		So now I have less permutations to make for startSet and I can verify the newPermutation exists in endSet or not.
		ex: dict=[cat, bat, bot, bit] begin="bit" end="cat".
		In above example, the begin is bit.
		Step1:
						----> bot
			--->bit---->
						----> bat
		Step2: In "WordLadderBFS" for the above input. bot will be permutated with all combo. But it will not find anything next.
													   bat will be permutated with all combo. It finds cat. and result is returned.
			   In "WordLadderBFSBest" we switch the "begin to end" or "end to begin".
			   So now startSet will have cat. cat will be permutated with all combo. It finds bat. and result is returned.

 */
public class WordLadderBFSBest {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);

    if (!dict.contains(endWord)) return 0;

    Set<String> startSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    startSet.add(beginWord);
    endSet.add(endWord);

    int steps = 0;

    while (!startSet.isEmpty() && !endSet.isEmpty()) {
      steps++;

      if (startSet.size() > endSet.size()) {
        Set<String> tmp = startSet;
        startSet = endSet;
        endSet = tmp;
      }

      Set<String> nextStartSet = new HashSet<>();

      for (String word : startSet) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
          char temp = charArray[i];
          for (char c = 'a'; c <= 'z'; ++c) {
            charArray[i] = c;
            String permutedWord = new String(charArray);
            if (endSet.contains(permutedWord)) return steps + 1;
            if (!dict.contains(permutedWord)) continue;
            dict.remove(permutedWord); // To avoid visited Logic. Remove nextWord from dict
            nextStartSet.add(permutedWord);
          }
          charArray[i] = temp;
        }
      }

      startSet = nextStartSet;
    }
    return 0;
  }
}
