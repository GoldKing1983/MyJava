package com.interview.leetcode.topic.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/maximum-product-of-three-numbers/
===========================================================Requirement===========================================================
1) Given array of numbers find maximumProductOfThreeNumbers.
2) Result can be formed with any 3 numbers. Doesn't have to be consecutive.
=========================================================Initial Thought=========================================================
1) Sort the data.
2) max1 = Pick 2from left, 1 from right. 
3) max2 = Pick 3from right.
4) maxProduct = max of max1 or max2.
========================================================Solution Approach========================================================
1) Cache the max3 number and min2 number
2) maxProduct = max of max1 * max2 * max3 or max1 * min1 * min2

Ex1: -5,-4,-1,0,1,2.....Output is 40. (-5*-4=20*2=40).
Ex2: -4,-1,0,1,2,3,4,5.....Output is 60. (5*4=20*3=60).

 */
public class MaximumProductOfThreeNumber {

  public int maximumProductUsingSort(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length - 1;
    int max1 = nums[0] * nums[1] * nums[n];
    int max2 = nums[n] * nums[n - 1] * nums[n - 2];
    return Math.max(max1, max2);
  }

  public int maximumProduct(int[] nums) {
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE,
        min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    for (int n : nums) {
      if (n > max1) {
        max3 = max2;
        max2 = max1;
        max1 = n;
      } else if (n > max2) {
        max3 = max2;
        max2 = n;
      } else if (n > max3) {
        max3 = n;
      }

      if (n < min1) {
        min2 = min1;
        min1 = n;
      } else if (n < min2) {
        min2 = n;
      }
    }
    return Math.max(max1 * max2 * max3, max1 * min1 * min2);
  }

  public int maximumProductUsingPQ(int[] nums) {
    Queue<Integer> q1 = new PriorityQueue<>(); // Keep Top3.
    Queue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder()); // Keep Bottom2. 
    for (Integer num : nums) {
      q1.offer(num);
      if (q1.size() > 3) q1.poll();
      q2.offer(num);
      if (q2.size() > 2) q2.poll();
    }
    int max1 = q1.poll() * q1.poll();
    int topPositiveNumber = q1.poll();
    max1 = max1 * topPositiveNumber;
    int max2 = topPositiveNumber * q2.poll() * q2.poll();
    return Math.max(max1, max2);
  }
}
