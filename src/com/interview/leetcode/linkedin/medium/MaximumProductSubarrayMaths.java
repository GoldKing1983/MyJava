package com.interview.leetcode.linkedin.medium;

import java.util.stream.IntStream;

/*
https://leetcode.com/problems/maximum-product-subarray/description/
https://www.youtube.com/watch?v=vtJvbRlHqTA

This problem is one of mathematical approach to solve.
At any point in multiplication, there are 2 case 1) max product 2) min product.
Ex:[1,2] -> maxProduct will be answer
   [1,-2]

1) Max Product will be maximum of "prevMaxProduct and current number" or "prevMinProduct and current number" or "current number itself"
This formula is arrived based on 3 cases
case 1:  "prevMaxProduct and current number" -> current Number is positive Number and previous Max Product is positive number
case 2:	 "prevMinProduct and current number" -> current Number is negative Number and previous Min Product is negative number
case 3:  "current number itself" -> current number is +number or 0 or -number. But still it is Max.

2) Min Product will be minimum of "prevMaxProduct and current number" or "prevMinProduct and current number" or "current number itself"
========================================================Solution Approach========================================================
1) At each point find, I will calculate currentMaxProduct.
    currentMaxProduct is maximum of(currentNumber, runningMax*currentNumber, runningMin*currentNumber);
    ex: [-5,10] at index1 max is currentNumber
    ex: [5,10] at index1 max is runningMax*currentNumber
    ex: [-5,-10] at index1 max is runningMin*currentNumber
    

2) At each point find, I will calculate currentMaxProduct, currentMinProduct.
    currentMinProduct is minimum of(currentNumber, runningMax*currentNumber, runningMin*currentNumber);
    ex: [-5,0] at index1 min is currentNumber
    ex: [5,10] at index1 max is runningMax*currentNumber
    ex: [-5,-10] at index1 max is runningMin*currentNumber

3) Update longestMaxProduct from currentMaxProduct.

2) Update longestMaxProduct from currentMaxProduct.



============Wrong Approach========
Solving this problem by less than 0, equal to 0 and more than 0 with if condition, with multiple condition will keep fail.
Confusion will arrive, to set 0 or 1 in maxProdut, minProduct etc... don't waste time
I spent more than 2 hours and was failing at various test cases and nothing succeeded fully.
=============

 */
public class MaximumProductSubarrayMaths {

  /*
   * [-5,5]
   * [-5,5,10]
   * [-5,5,10,-5]--> here I need runningMinProduct cache... at index3 
   * 
   */
  public int maxProduct(int[] nums) {
    int runningMaxProduct = nums[0];
    int runningMinProduct = nums[0];
    int longestMaxProduct = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int cN = nums[i];
      int currentMaxProduct =
          IntStream.of(runningMaxProduct * cN, runningMinProduct * cN, cN).max().getAsInt();

      int currentMinProduct =
          IntStream.of(runningMaxProduct * cN, runningMinProduct * cN, cN).min().getAsInt();


      longestMaxProduct = Math.max(longestMaxProduct, currentMaxProduct);

      runningMaxProduct = currentMaxProduct;
      runningMinProduct = currentMinProduct;
    }
    return longestMaxProduct;
  }
}
