package com.interview.leetcode.topic.array;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target

1) given an array of input.
2) group numbers into target... numbers cannot be used only once or cannot be re-used...

Input: nums = [1,1,1,1,1], target = 2
Output: 2
Explanation: There are 2 non-overlapping subarrays [1,1,1,1,1] with sum equals to target(2).
                                                    --- result1
                                                        --- result2
=======================================================Data Flow Analysis========================================================
1) This is like school math... Imagine long line of number with their sum on each index and resultCount

resultCountMap  =    1 1 2 2
prefixSum       =  1 2 3 4 5  
nums            = [1,1,1,1,1], target = 2  ans=2

2) Need for Math.max

resultCountMap  =    1 1 2  1
prefixSum       =  1 2 3 4  3  
nums            = [1,1,1,1,-1], target = 2 ans=2
at index4 sum=3 and currentResultCount=1 which is wrong. So use Math.max to keep the max answer.
  
      
See also SubarraySumEqualsK
                                                    

 */
public class NumberOfNonOverlappingSublistsWithSumOfTarget {

  public int solve(int[] nums, int target) {
    Map<Integer, Integer> resultCountMap = new HashMap<>();
    resultCountMap.put(0, 0);

    int resultCount = 0;
    int prefixSum = 0;

    for (int i = 0; i < nums.length; ++i) {
      prefixSum += nums[i];
      if (resultCountMap.containsKey(prefixSum - target)) {
        int currentResultCount = resultCountMap.get(prefixSum - target) + 1;
        resultCount = Math.max(currentResultCount, resultCount);
      }
      resultCountMap.put(prefixSum, resultCount);
    }

    return resultCount;

  }
}
