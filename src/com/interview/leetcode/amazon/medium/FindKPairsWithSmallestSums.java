package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*

1) It is about doing sum for permutation of number from smallest to largest, since array is sorted.
2) If you think 2 array as 2 rows of matrix with 2 column then sum permutation will be like [0,0] [0,1] [1,0] [1,1] 
3) Because both array are sorted, so we can keep track of the paired index
4) Similar to merge sorted array.

   
   [1,1,2]
   [1,2,3]
   10
   [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
*/
public class FindKPairsWithSmallestSums {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    List<List<Integer>> kPairs = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0 || k == 0) {
      return kPairs;
    }

    int[] index = new int[nums1.length];
    while (k-- > 0) {
      int minVal = Integer.MAX_VALUE;
      int in = -1;
      for (int i = 0; i < nums1.length; i++) {
        if (index[i] >= nums2.length) {
          continue;
        }
        if (nums1[i] + nums2[index[i]] < minVal) {
          minVal = nums1[i] + nums2[index[i]];
          in = i;
        }
      }
      if (in == -1) {
        break;
      }
      kPairs.add(List.of(nums1[in], nums2[index[in]]));
      index[in]++;
    }

    return kPairs;
  }
}
