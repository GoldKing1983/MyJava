package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;

/*

https://leetcode.com/problems/find-anagram-mappings/description/

Element of A is shuffled placed in B.
Find the index of each elements of A in B.

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]

We should return
[1, 4, 3, 2, 0]

12 in A is present in 1st index of B.
28 in A is present in 4th index of B.
46 in A is present in 3rd index of B.
32 in A is present in 2nd index of B.
50 in A is present in 0th index of B.

============================================Solution Approach============================================
1) Push elements on B into map with its index.
2) For each of elements in A. Fetch the index from map.
*/
public class FindAnagramMappings {
  public int[] anagramMappings(int[] A, int[] B) {
    int[] result = new int[A.length];

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      map.put(B[i], i);
    }
    for (int i = 0; i < A.length; i++) {
      result[i] = map.get(A[i]);
    }
    return result;
  }
}
