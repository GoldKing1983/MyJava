package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/h-index/

Requirement : Code for H-Index.
Understand H-Index "https://www.youtube.com/watch?v=YAUxtkH4PZU"

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
             received 3, 0, 6, 1, 5 citations(reviews) respectively.
             Since the researcher has 3 papers with at least 3 citations each, count3 is the answer.

Input: citations = [50,100]
Output: 2
Explanation: [50,100] means the researcher has 2 papers in total and each of them had
             received 50,100 citations(reviews) respectively.
             Since the researcher has 2 papers with at least 2 or more citations each, count2 is the answer.

Input: citations = [1,2]
Output: 1

Input: citations = [1,2,2].... citationCount=[0,1,2,0]
Output: 2

Input: citations = [50,100,100].... citationCount=[0,0,0,3]
Output: 3

===================================================Solution Approach===================================================
Step1) Do a count sort of citations.

1a) If the citation goes beyond "n", limit it to n. Similar to FirstMissingPositiveInAnArrayOfDuplicateNumbers
Ex1: [3,0,6,1,5] .... count = [0, 1, 0, 1, 0, 2]

1b) If the count goes beyond the index then reset.
Ex1: [1,1].... count = [0, 1, 0] and not [0, 2, 0]

Step2) Count the hIndex from last.
2a) From last add the citationCount to hIndex.
2b) If hIndex goes beyond currentIndex then return currentIndex. No need to traverse till index0.
Ex: [1,2]... count = [0,1,1]. At index1 hIndex=2 which crosses currentIndex. So return currentIndex i.e 1.


 */
public class HIndexBest {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] citationCount = new int[n + 1]; // for 5 papers. do from 1 to 5, ignoring 0

    // Step1) Do a count sort of citations.
    for (int citation : citations) {
      int index = Math.min(n, citation);
      citationCount[index]++;
      // if the currentCitation goes more than index reset...Ex:[1,1]
      if (citationCount[index] > index) citationCount[index] = index;
    }
    // Step2) Count the hIndex from last.
    int hIndex = 0;
    for (int index = n; index > 0; index--) {
      hIndex = hIndex + citationCount[index];
      // Cannot return hIndex. Because atIndex3 hIndex can be 4 or more
      if (hIndex >= index) return index;
    }
    return hIndex;
  }
}
