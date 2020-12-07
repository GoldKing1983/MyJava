package com.interview.leetcode.google.medium;

import java.util.Arrays;

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

Input: citations = [50,100]
Output: 2
Explanation: [50,100] means the researcher has 2 papers in total and each of them had
             received 50,100 citations(reviews) respectively.
             Since the researcher has 2 papers with at least 2 or more citations each, count2 is the answer.

Input: citations = [1,2]
Output: 1

Input: citations = [1,2,2]
Output: 2

 */
public class HIndexBinSearch {
  // Ex: [0,1,3,5,6]. For this example low stays in 3.
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int n = citations.length;
    int low = 0, high = n - 1;
    while (low <= high) {
      int mid = (high + low) / 2;
      if (citations[mid] >= n - mid) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return n - low;
  }
}
