package com.interview.leetcode.linkedin.hard;

/*
https://leetcode.com/problems/median-of-two-sorted-arrays/description/

https://www.youtube.com/watch?v=LPFhl65R7ww


=====================================================Solution Approach=====================================================
1) If we club both array median lies on middle. 
2) So do a simple mergeSort of 2 arrays and return middle.

================================================================= 
 */
public class MedianOfTwoSortedArraysLinearSearchBetter {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double median1 = 0, median2 = 0;
    int n1 = nums1.length, n2 = nums2.length, n = n1 + n2;
    int num1Ptr = 0, num2Ptr = 0;

    for (int i = 0; i <= n / 2; i++) {
      if (num2Ptr == n2) {
        median2 = median1;
        median1 = nums1[num1Ptr];
        num1Ptr++;
      } else if (num1Ptr == n1) {
        median2 = median1;
        median1 = nums2[num2Ptr];
        num2Ptr++;
      } else if (nums1[num1Ptr] <= nums2[num2Ptr]) {
        median2 = median1;
        median1 = nums1[num1Ptr];
        num1Ptr++;
      } else {
        median2 = median1;
        median1 = nums2[num2Ptr];
        num2Ptr++;
      }
    }

    if (n % 2 == 0) return (median1 + median2) / 2; // even length
    else return median1;
  }

}
