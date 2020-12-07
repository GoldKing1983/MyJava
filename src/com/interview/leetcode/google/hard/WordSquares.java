package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

https://leetcode.com/problems/word-squares/

1) Building TRIE complicates the solution.
2) Understand this approach, on top of it try to add TRIE.

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

================================================Solution Approach================================================
1) Form prefixMap with all the combinations. Ex: "how" "hox"
h[how,hox]
ho[how, hox]
2) For each of word --> do DFS.
2a) Add the current word to "wordGroup"
2b) Calculate "nextPrefixRequired" from wordGroup.
2c) For each of "word" matching "nextPrefixRequired" do DFS like graph.Ex: for(List<Children> adjMatrix.getChild())
2d) BackTracking is needed. Ex: There are 2 matching words and first word is not satisfying next of "nextPrefixRequired" ,
then 2nd word should be used by removing first word.
===========================================
Input : ["area",
		 "lady",
		 "lead",
		 "wall"]
		============================Trie Build is ============================
							    -------root------
							  /	     /      |     \
							  =========================
							||a		b 		l 		w  ||
							 ===========================
							/	   /	   / \		 \
						   r	  a		  a   e		  a
						  /		 /		 /     \	   \
						 e		l		d       a		l
						/	   /	   /		 \		 \
					   a 	  l		  y			  d		  l

			====prefixMap=====
{a=[area], ar=[area], are=[area], area=[area], l=[lady, lead], la=[lady], lad=[lady], lady=[lady],
le=[lead], lea=[lead], lead=[lead], w=[wall], wa=[wall], wal=[wall], wall=[wall]}
				========
Current Parent String Group: [area]
					area
					 =
For the  Parent String Group:[area] no prefix child found with: "r"
				========
Current Parent String Group: [lady]
					lady
					 =
For the  Parent String Group:[lady] prefix child found for "a" is:[area]

Current Parent String Group: [lady, area]
					lady
					  =
					area
					  =
For the  Parent String Group:[lady, area] no prefix child found with: "de"
				========
Current Parent String Group: [lead]
					lead
					 =
For the  Parent String Group:[lead] no prefix child found with: "e"
				========
Current Parent String Group: [wall]
					wall
					 =
For the  Parent String Group:[wall] prefix child found for "a" is:[area]

Current Parent String Group: [wall, area]
					wall
					  =
					area
					  =
For the  Parent String Group:[wall, area] prefix child found for "le" is:[lead]

Current Parent String Group: [wall, area, lead]
					wall
					   =
					area
					   =
					lead
					   =
==========================
					wall
					   =
					area
					   =
					lady
					   =
==========================
For the  Parent String Group:[wall, area, lead] prefix child found for "lad" is:[lady]

*/
public class WordSquares {
  public List<List<String>> wordSquares(String[] words) {
    Map<String, Set<String>> prefixMap = new HashMap<>();
    for (String word : words) {
      for (int i = 1; i < word.length(); i++) {
        String str = word.substring(0, i);
        prefixMap.putIfAbsent(str, new HashSet<>());
        prefixMap.get(str).add(word);
      }
    }
    List<List<String>> res = new ArrayList<>();
    for (String word : words)
      dfs(new ArrayList<>(Arrays.asList(word)), 1, words[0].length(), prefixMap, res);

    return res;
  }

  private void dfs(
      List<String> wordGroup,
      int prefixIndex,
      int len,
      Map<String, Set<String>> prefix,
      List<List<String>> res) {
    if (prefixIndex == len) {
      res.add(new ArrayList<>(wordGroup));
      return;
    }
    // Get the next prefix;
    StringBuilder nextPrefixRequired = new StringBuilder();
    for (String word : wordGroup) nextPrefixRequired.append(word.charAt(prefixIndex));
    if (!prefix.containsKey(nextPrefixRequired.toString())) return;

    for (String nextEligbileWord : prefix.get(nextPrefixRequired.toString())) {
      wordGroup.add(nextEligbileWord);
      dfs(wordGroup, prefixIndex + 1, len, prefix, res);
      wordGroup.remove(wordGroup.size() - 1);
    }
  }
}
