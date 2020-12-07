package com.interview.leetcode.facebook.medium;

import com.leetcode.interview.MaximumSubArraySum;
import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-sum-circular-subarray/

Step1) Result can exist in nonCircularArray.Ex: [-1,-2,3]. So calculate nonCircularMaxSum.
Step2) Result can exist in  circularArray. So calculate circularMaxSum
		Consider Ex: [2,-2,3] Ans=5. {3,2}.
		2a) Calculate TotalSum = 3
		2b) Calculate maximumSubArraySum for invertedPositiveNumber [2,-2,3] to [-2,2,-3]= 2
		2c) circularMaxSum = 3+2 = 5
Step3) Result = Math.max(circularMaxSum, nonCircularMaxSum);

 */
public class MaximumSumCircularSubarray {
  MaximumSubArraySum maximumSubArraySum = new MaximumSubArraySum();

  public int maxSubarraySumCircular(int[] nums) {
    // Step1) Result can exist in nonCircularSum Ex: [-1,-2,3].
    int nonCircularMaxSum = maximumSubArraySum.maxSubArray(nums);

    // Step2) Result can exist in with circularSum Ex: [2,-2,3] Ans=5. {3,2}
    int totalSum = Arrays.stream(nums).sum();
    for (int i = 0; i < nums.length; i++) nums[i] = -nums[i];
    int circularMaxSum = totalSum + maximumSubArraySum.maxSubArray(nums);

    // Corner Case AllPositive or AllNegative: [-2,-3,-1] or [2,3,1]. In both case circularMaxSum=0.
    if (circularMaxSum == 0) return nonCircularMaxSum;
    // Step3) Result = Math.max(circularMaxSum, nonCircularMaxSum);
    return Math.max(circularMaxSum, nonCircularMaxSum);
  }
}
