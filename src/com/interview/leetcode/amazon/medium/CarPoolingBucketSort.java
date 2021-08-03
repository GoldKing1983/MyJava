package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/car-pooling/

1) Similar solution as CarPoolingTreeMap.
2) Interviewer might be interested in solution without sorting. Then use this. 

Time complexity: O(max(N,1001)) -- N can be larger than buckets.   
since we need to iterate over trips and then iterate over our 1001 buckets.
 
Space complexity: O(1001) = O(1) constant...  Better than N, because N can be bigger. 
 
 */
public class CarPoolingBucketSort {
  public boolean carPooling(int[][] trips, int capacity) {
    int[] timestamp = new int[1001];
    for (int[] trip : trips) {
      timestamp[trip[1]] += trip[0];
      timestamp[trip[2]] -= trip[0];
    }
    int usedCapacity = 0;
    for (int number : timestamp) {
      usedCapacity += number;
      if (usedCapacity > capacity) {
        return false;
      }
    }
    return true;
  }
}
