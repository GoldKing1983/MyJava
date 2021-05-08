package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/shortest-word-distance/description/
=======================================================Requirement===============================================================
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
=======================================================Example1==================================================================
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1
=======================================================Example12=================================================================
Assume that words = ["a", "a", "b", "b"].

Input: word1 = “a”, word2 = “b”
Output: 1

Input: word1 = "b", word2 = "a"
Output: 1

=====================================================Solution Approach===========================================================
0) Pre-processing of wordsList is not needed, because we are going to run the query only once. 
ShortestWordDistanceII needs Pre-processing, because we fire so many query against wordsList
1) Iterate each of word, word can be either word1 or word2.
2) If both word1Index and word2Index is != -1. Calculate currentShortestDistance and update shortestDistance.

 */
public class ShortestWordDistance {

  public int shortestDistance(String[] words, String word1, String word2) {
    int word1Index = -1;
    int word2Index = -1;
    int currentIndex = 1;
    int shortestDistance = Integer.MAX_VALUE;
    for (String word : words) {
      if (word1.equals(word)) word1Index = currentIndex;
      else if (word2.equals(word)) word2Index = currentIndex;

      if (word1Index != -1 && word2Index != -1) {
        int currentShortestDistance = Math.abs(word1Index - word2Index);
        shortestDistance = Math.min(shortestDistance, currentShortestDistance);
      }

      currentIndex++;
    }
    return shortestDistance;
  }
}
