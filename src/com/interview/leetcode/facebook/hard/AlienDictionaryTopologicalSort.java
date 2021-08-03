package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.com/problems/alien-dictionary/

https://www.educative.io/collection/page/5668639101419520/5671464854355968/6610306698575872
===========================================================Requirement===========================================================
1) Input words are lexicographically sorted.
Ex1: "abc" and "abd". On this word only one criteria is confirmed. c comes before d. a and b can come anywhere.
Ex2: "abcd" and "abxy". Still on this word only one criteria is confirmed. c comes before x. a, b, d, y can come anywhere.
2) Only difference in input as compared to graph relation is build the graph of the characters by
comparing adjacent words first, and then perform the topological sort for the graph to determine the order of the characters.
============================================================Example1=============================================================
input : ["abc","abd"] answer is abcd or bacd or cdab or "cdba" or acdb or bcda
============================================================Example2=============================================================
input : ["cab","dab"] answer is abcd or bacd or cdab or cdba or acdb or bcda ---> answers are same as Example1 
============================================================Example2=============================================================
input : ["abc","abc"] answer is abc or any permutations of abc
========================================================Solution Approach========================================================
1) Take the adjacent words. Ex: ["abc","abd"]. Word1 is abc. Word2 is abd
2) Compare index by index char values. if the character is not matching at an "index".
We can say word1Char(c) is parent and word2Char(d) is child.
3) From above we know only 1 thing "c comes before d".
4) Derive rest of connections from topology sort.
======Finding sources firsttime and then afterwards ======
1) First time source are found out by "inDegree" with size 0.
2) For the second time and there after,
When a source is processed, corresponding neighbor in-degree count is reduced.
If a in-degree count is 0, then it can be added to source.
=============================
If there is a loop then sortedOrder doesn't match with inDegree. So return "" in that case.

input : ["abc","ab"] output: ""
input : ["ab","adc"] output: abdc or abcd or bdac or bdca
=======================================================Data Flow Analysis========================================================
input : ["abc","abd"] answer is abcd
       
            ---> a --->
            ---> b --->
              c ---> d
a and b are just hanging nodes. only 1 thing is confirmed with input. c is a parent of d                  
      
adjMap   = [a=EMPTY_LIST],[b=EMPTY_LIST],[c=d],[d=EMPTY_LIST]
inDegree = [a=0], [b=0], [c=0], [d=1]

sources = [a,b,c]

remove(poll) a from source.
remove(poll) b from source.
remove(poll) c from source.
c has d with indegreeCount=1. 
decrement indegreeCount.  

push d to source

remove(poll) d from source.

ans=abcd


 */
public class AlienDictionaryTopologicalSort {
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";

    // a. Declare the graph(adjMap and inDegree) variable with size.
    HashMap<Character, Integer> inDegree = new HashMap<>();
    HashMap<Character, List<Character>> adjMap = new HashMap<>(); // adjacency list graph
    for (String word : words) {
      for (char character : word.toCharArray()) inDegree.put(character, 0);
    }

    // b. Build the graph or Initialize the adjMap and inDegree(count of incoming edges for every vertex)
    for (int i = 0; i < words.length - 1; i++) {
      // find ordering of characters from adjacent words
      String parentWord = words[i], childWord = words[i + 1];
      // Corner Case Ex:["abc","ab"] then return ""......for ["abc","abd"] answer is abcd
      if (!parentWord.equals(childWord) && parentWord.startsWith(childWord)) return "";
      for (int j = 0; j < Math.min(parentWord.length(), childWord.length()); j++) {
        char parentChar = parentWord.charAt(j), childChar = childWord.charAt(j);
        if (parentChar != childChar) { // if the two characters are different
          adjMap.computeIfAbsent(parentChar, v -> new ArrayList<>()).add(childChar); // put the child into it's parent's list
          inDegree.put(childChar, inDegree.get(childChar) + 1); // increment child's inDegree
          break; // only the first different character between the two words will help us find the order
        }
      }
    }
    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Character> sources = new LinkedList<>();
    for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) sources.add(entry.getKey());
    }

    // d. For each source, add it to the sortedOrder and subtract one from all of its children's
    // in-degrees. if a child's in-degree becomes zero, add it to the sources queue
    StringBuilder sortedOrder = new StringBuilder();
    while (!sources.isEmpty()) {
      Character parent = sources.poll();
      sortedOrder.append(parent);
      for (Character child : adjMap.getOrDefault(parent, List.of())) { // get the node's children to decrement their in-degrees
        inDegree.put(child, inDegree.get(child) - 1);
        if (inDegree.get(child) == 0) sources.add(child);
      }
    }

    // if sortedOrder doesn't contain all characters, there is a cyclic dependency between
    // characters, therefore, we will not be able to find the correct ordering of the characters
    if (sortedOrder.length() != inDegree.size()) return "";

    return sortedOrder.toString();
  }
}
