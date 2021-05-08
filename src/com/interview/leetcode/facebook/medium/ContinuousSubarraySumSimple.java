package com.interview.leetcode.facebook.medium;

import java.util.HashSet;
import java.util.Set;

/*
 https://leetcode.com/problems/continuous-subarray-sum/description/

 1) Iterate through the input array exactly once,
 2) Keep track of the running sum mod k of the elements in the process.
 3) If we find "currentRunningMod" previously seen before then desired sum found.

It works because of magic numbers.

[6,6,7] - k=6 - true
[6,7,6] - K=6 - false --> because it is not continuous
[0,0] - K=0 - true
[23,2,6,4,7] - K=0 - false
[2,5,4,1] - k=6 - true
[2,5,4,2] - k=6 - true
 */
public class ContinuousSubarraySumSimple {
  public boolean checkSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    int prefixSumMod = 0;
    for (int currentNumber : nums) {
      int currentRunningMod = (prefixSumMod + currentNumber) % k;
      // Ex: [10,2].. k=6... at index1 set=[0]..currentRunningMod: 0
      // Ex: [1,10,2].. k=6... at index1 set=[0]..currentRunningMod: 5
      //                       at index2 set=[0,1]..currentRunningMod: 1  
      // Code runs like circularQueue filling prefixSum value from 0 to k-1...
      // Ex: [1,10,2]... k=3 Tricky we might think of 1 and 2 to form 3. But 3 formed with 10 and 2
      // Another point... Ex:: [1,2,4] k=5... Tricky we might think at index2 when 4 comes... 1 already exists.. so this will match..
      //                                      It will fail because prefixSumMod changed. 

      if (set.contains(currentRunningMod)) {
        return true;
      }

      set.add(prefixSumMod);
      prefixSumMod = currentRunningMod;
    }
    return false;
  }
}
