package com.interview.leetcode.linkedin.medium;

import java.util.stream.IntStream;

/*
https://leetcode.com/problems/maximum-product-subarray/description/
https://www.youtube.com/watch?v=vtJvbRlHqTA

Solution is arrived based on 3 cases where longestMaxProduct is possiblefos
case 1:  "prevMaxProduct and current number" -> current Number is positive Number and previous Max Product is positive number
case 2:	 "prevMinProduct and current number" -> current Number is negative Number and previous Min Product is negative number
case 3:  "current number itself" -> current number is +number or 0 or -number. But still it is Max.

        ===== case initial thinking =====
        5 * -10 *  1 ans:6
        5 * -10 * -1 ans:50
        ===== case for 0 ===== 
        5 * 0 * -1
        5 * 0 *  1
        ===== case all negative ===== 
        [-2, -3, -3] ans:9

============Wrong Approach========
Solving this problem by less than 0, equal to 0 and more than 0 with if condition, with multiple condition will keep fail.
Confusion will arrive, to set 0 or 1 in maxProdut, minProduct etc... don't waste time
I spent more than 2 hours and was failing at various test cases and nothing succeeded fully.
=============See also NumberOfNonOverlappingSublistsWithSumOfTarget

 */
public class MaximumProductSubarrayMaths {

  public int maxProduct(int[] nums) {
    int runningMaxProduct = nums[0];
    int runningMinProduct = nums[0];
    int longestMaxProduct = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int cN = nums[i];

      // I always code without this line... after debugging I used to add this line.
      // we need this because runningMaxProduct is updated and runningMinProduct calculation will go wrong. 
      int tempRunningMaxProduct = runningMaxProduct;

      runningMaxProduct =
          IntStream.of(runningMaxProduct * cN, runningMinProduct * cN, cN).max().getAsInt();

      // Below is wrong because runningMaxProduct is updated.
      //      runningMinProduct =
      //          IntStream.of(runningMaxProduct * cN, runningMinProduct * cN, cN).min().getAsInt();

      runningMinProduct =
          IntStream.of(tempRunningMaxProduct * cN, runningMinProduct * cN, cN).min().getAsInt();


      longestMaxProduct = Math.max(longestMaxProduct, runningMaxProduct);

    }
    return longestMaxProduct;
  }
}
