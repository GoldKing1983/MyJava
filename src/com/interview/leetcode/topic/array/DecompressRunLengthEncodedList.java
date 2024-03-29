package com.interview.leetcode.topic.array;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/decompress-run-length-encoded-list/

We are given a list of integers representing a run-length encoding.
Return the decompressed list.

Input: nums = [1,2,3,4]
Output: [2,4,4,4]
Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
At the end the concatenation [2] + [4,4,4] is [2,4,4,4].

Input: nums = [1,1,2,3]
Output: [1,3,3]

 */
public class DecompressRunLengthEncodedList {
  public int[] decompressRLElist(int[] nums) {

    int resultN = 0, resultIndex = 0, n = nums.length;
    /*
    How to move by 2 indexes
    [1,2,3,4,5,6,7,8]
    i = 0 ... 2*0 =0 
    i = 1 ... 2*1 =2
    i = 2 ... 2*2 =4
    i = 3 ... 2*3 =6
    */

    for (int i = 0; i < n / 2; i++) {
      resultN += nums[2 * i];
    }

    // Below also good, instead of above for loop.
    //    for(int i=0; i<n; i=i+2) {
    //      resultN += nums[i];
    //    }

    int[] result = new int[resultN];
    for (int i = 0; i < n / 2; i++) {
      int count = nums[2 * i];
      int value = nums[2 * i + 1];
      while (count-- >= 1) {
        result[resultIndex++] = value;
      }
    }
    return result;
  }

  // Use ArrayList as we don't the resultSize. Then convert the List<Integer> to int[]
  public int[] decompressRLElistApproach2(int[] nums) {

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int count = nums[i++];
      int value = nums[i];
      while (count-- >= 1) {
        result.add(value);
      }
    }

    return result.stream().mapToInt(i -> i).toArray();

  }
}
