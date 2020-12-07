package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/h-index/

Requirement : Code for H-Index.
Understand H-Index "https://www.youtube.com/watch?v=YAUxtkH4PZU"

Input is sorted. Just do binary search. See HIndexBinSearch

 */
public class HIndexII {
  public int hIndex(int[] citations) {
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
