package com.interview.leetcode.topic.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

https://leetcode.com/problems/word-squares/

1) Building TRIE complicates the solution. PrefixMap works better.
2) Understand this approach, on top of it try to add TRIE.
============================================================Example1=============================================================
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
============================================================Example2=============================================================
Input: words = ["abat","baba","atan","atal"]
Output: ["baba",
         "abat",
         "baba",
         "atal"],
         
         "baba",
         "abat",
         "baba",
         "atan"]]

========================================================Logical Thinking=========================================================
1) A validWordSquare is possible based on picture "WordSquare.png"
2) Take the word1.        Collect word1s       2ndCharacter say "nextPrefixRequired". add values of nextPrefixRequired to wordGroup. 
3) Take the word1, word2. Collect word1,word2s 3rdCharacter say "nextPrefixRequired". add values of nextPrefixRequired to wordGroup.
4) See Example2: For 4Word with 4letter there can be more combination of result. So DFS needs to run for eachOfWord as a start.
So we need backtracking to form alternate result or if word1 is not forming result word2 can be included for result.     
========================================================Solution Approach========================================================
 
1) Form prefixMap with all the combinations. Ex: "how" "hox"
h[how,hox]
ho[how, hox]
2) For each of word --> do DFS.
2a) Add the current word to "wordGroup"
2b) Calculate "nextPrefixRequired" from wordGroup.
2c) For each of "word" matching "nextPrefixRequired" do DFS like graph.Ex: for(List<Children> adjMatrix.getChild())
===========================================
Input : ["area",
		 "lady",
		 "lead",
		 "wall"]
			====prefixMap=====
{a=[area], ar=[area], are=[area], 
l=[lady, lead], la=[lady], lad=[lady], 
le=[lead], lea=[lead], 
w=[wall], wa=[wall], wal=[wall]}
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
public class WordSquaresBackTracking {
  public List<List<String>> wordSquares(String[] words) {
    Map<String, Set<String>> prefixMap = new HashMap<>();
    int squareSize = words[0].length();
    for (String word : words) {
      for (int i = 0; i < squareSize - 1; i++) {
        String str = word.substring(0, i + 1);
        prefixMap.putIfAbsent(str, new HashSet<>());
        prefixMap.get(str).add(word);
      }
    }
    //System.out.println(prefixMap); 
    List<List<String>> res = new ArrayList<>();
    for (String word : words)
      dfs(new ArrayList<>(Arrays.asList(word)), 0, squareSize, prefixMap, res);

    return res;
  }

  private void dfs(List<String> wordGroup, int prefixIndex, int squareSize,
      Map<String, Set<String>> prefix, List<List<String>> res) {
    if (wordGroup.size() == squareSize) {
      res.add(new ArrayList<>(wordGroup));
      return;
    }
    // Get the next prefix;
    StringBuilder nextPrefixRequired = new StringBuilder();
    for (String word : wordGroup) nextPrefixRequired.append(word.charAt(prefixIndex + 1));

    for (String nextEligbileWord : prefix.getOrDefault(nextPrefixRequired.toString(), Set.of())) {
      wordGroup.add(nextEligbileWord);
      dfs(wordGroup, prefixIndex + 1, squareSize, prefix, res);
      wordGroup.remove(wordGroup.size() - 1);
    }
  }
}
