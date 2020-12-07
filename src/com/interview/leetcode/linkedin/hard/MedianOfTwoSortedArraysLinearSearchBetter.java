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
    double median1 = 0;
    double median2 = 0;
    int nums1Length = nums1.length, nums2Length = nums2.length;
    int n = nums1Length + nums2Length;
    int num1Ptr = 0, num2Ptr = 0;
    for (int i = 0; i <= n / 2; i++) {
      if (num2Ptr == nums2Length || num1Ptr != nums1Length && nums1[num1Ptr] <= nums2[num2Ptr]) {
        num1Ptr++;
        median2 = median1;
        median1 = nums1[num1Ptr - 1];
      } else {
        num2Ptr++;
        median2 = median1;
        median1 = nums2[num2Ptr - 1];
      }
    }
    if ((n & 1) == 0) return (median1 + median2) / 2; // even length
    else return median1;
  }
}
