package com.interview.leetcode.google.medium;

import com.interview.leetcode.ArrayReader;

/*

Requirement:
1) Given an integer array sorted in ascending order, write a function to search target in nums.
2) If target exists, then return its index, otherwise return -1.
3) However, the array size is unknown to you. You may only access the array using an ArrayReader interface,
where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

=======================================================Solution Approach=======================================================
1) To use binary search, we need to find the search space defined by low and high.
2) Find high by moving high exponentially.Ex: 2,4,8,16,32,64
3) Once high is found, low is previous high.
Ex: [high=1, low=0] [high=2, low=1] [high=4, low=2] [high=8, low=4] [high=16, low=8].........
4) Then do binary search.
 */
public class SearchInASortedArrayOfUnknownSize {
  public int search(ArrayReader reader, int target) {
    int low = 0, high = 1;
    while (true) {
      int nextHigh = reader.get(high);
      if (nextHigh > target) break;
      low = high; // Keeping the lower search space with low.
      high = high * 2; // high<<2
    }
    return binSearch(reader, low, high, target);
  }

  private int binSearch(ArrayReader reader, int low, int high, int target) {
    if (low > high) return -1;
    int mid = low + (high - low) / 2;
    int midValue = reader.get(mid);
    if (target == midValue) return mid;
    if (target > midValue) return binSearch(reader, mid + 1, high, target);
    return binSearch(reader, low, mid - 1, target);
  }
}
