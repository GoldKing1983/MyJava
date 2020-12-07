package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/relative-sort-array/
============================================================Requirement==========================================================
1) Given 2 Array arr1[] and arr2[].
2) arr1[] contains all of arr2[].
3) Sort arr1[] and return result. 
4) But condition is, return all of arr2 in result first as sorted order. Then left-overs in arr1, still sorted 

====For easier visualization, both arr1 and arr2 are given as sorted. But arr1 and arr2 input will be without sorted====
Ex: arr1 = [1,2,3,4] arr2=[2,3] 
result = [2,3,1,4]

==========================================================Initial Solution=======================================================
1) Offer arr1 to treeSet set1. So it will be available as sorted.
2) Offer arr2 to treeSet set2. So it will be available as sorted.
3) For each element from set2 add it to result and remove from  set1.
4) Add all left-overs from set1 to result.  
=====================================================Solution Based on Bucket Sort===============================================
0) data in arr1 ranges from 0 to 1000.
1) So cache the arr1 from 0 to 1000 in array with count
2) from arr2 value, go index at cache and get index, add that many into result.
Reduce the count.
3) For the left-overs come from 0 to 1000 and add it to result.

*/
public class RelativeSortArray {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {

    int[] result = new int[arr1.length];
    int[] cache = new int[1001];
    for (int data : arr1) cache[data] += 1;
    int resIndex = 0;
    for (int data : arr2) {
      int count = cache[data];
      while (count-- > 0) result[resIndex++] = data;
      cache[data] = 0;
    }
    for (int i = 0; i <= 1000; i++) {
      int count = cache[i];
      while (count-- > 0) result[resIndex++] = i;
    }
    return result;
  }
}
