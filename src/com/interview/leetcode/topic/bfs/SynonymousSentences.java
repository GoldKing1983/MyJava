package com.interview.leetcode.topic.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*

===========================================================Requirement===========================================================
1) Given a list of pairs of equivalent words synonyms and a sentence text. 
2) Return all possible synonymous sentences sorted lexicographically.
 
============================================================Example1=============================================================
Input:
synonyms = [["happy","joy"],
            ["sad","sorrow"],
            ["joy","cheerful"]],
text = "I am happy today but was sad yesterday"
Output:
["I am cheerful today but was sad yesterday",
"I am cheerful today but was sorrow yesterday",
"I am happy today but was sad yesterday",
"I am happy today but was sorrow yesterday",
"I am joy today but was sad yesterday",
"I am joy today but was sorrow yesterday"]
 =======================================================Data Flow Analysis========================================================
    h -> j
    
    j -> h,c
    
    c -> j
    
    s -> so
    
    so -> s
    
    ========

    How the combination sequence generated.
    
    A word ad beginning had 2 synonym. So total of 3 new Combo.
    
    Same word at end had 1 synonym. 3* 2= 6 combination
    
    
 */
public class SynonymousSentences {
  public List<String> generateSentences(List<List<String>> synonyms, String text) {
    Map<String, List<String>> graph = new HashMap<>();
    for (List<String> pair : synonyms) {
      String w1 = pair.get(0), w2 = pair.get(1);
      graph.computeIfAbsent(w1, t -> new LinkedList<>()).add(w2);
      graph.computeIfAbsent(w2, t -> new LinkedList<>()).add(w1);
    }
    // BFS
    Set<String> ans = new TreeSet<>();
    Queue<String> q = new LinkedList<>();
    q.add(text);
    while (!q.isEmpty()) {
      String out = q.remove();
      ans.add(out); // Add to result
      String[] words = out.split("\\s");
      for (int i = 0; i < words.length; i++) {
        if (graph.get(words[i]) == null) continue;
        for (String synonym : graph.get(words[i])) { // Replace words[i] with its synonym
          words[i] = synonym;
          String newText = String.join(" ", words);
          if (!ans.contains(newText)) q.add(newText);
        }
      }
    }
    return new ArrayList<>(ans);
  }

}
