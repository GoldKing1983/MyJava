package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.List;

/*
==================================================Requirement===============================================================
https://leetcode.com/problems/intersection-of-three-sorted-arrays/
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
return a sorted array of only the integers that appeared in all three arrays.
======================================================Example 1=============================================================
Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
=======================================================Solution Approach====================================================
1) Compare arr1 and arr2. Gather result1. 
2) Compare result1 and arr3. Gather finalResult.

Implementation Note: Don't try to hold result1 as finalResult. (i.e) by comparing result1 with arr3, keep whatever exists in 
result1 and remove remaining from result1. It has lot of corner cases. Best is Compare result1 and arr3 and gather finalResult.    

 */
public class IntersectionOfThreeSortedArraysBFS {
  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> result1 = new ArrayList<>();
    int n1 = arr1.length, n2 = arr2.length, n3 = arr3.length, ptrResult1 = 0;
    int ptr1 = 0, ptr2 = 0, ptr3 = 0;
    while (ptr1 < n1 && ptr2 < n2) {
      if (arr1[ptr1] == arr2[ptr2]) {
        result1.add(arr1[ptr1]);
        ptr1++;
        ptr2++;
      } else if (arr1[ptr1] < arr2[ptr2]) ptr1++;
      else ptr2++;
    }
    if (result1.isEmpty()) return result1;

    List<Integer> finalResult = new ArrayList<>();
    while (ptrResult1 < result1.size() && ptr3 < n3) {
      if (result1.get(ptrResult1) == arr3[ptr3]) {
        finalResult.add(arr3[ptr3]);
        ptrResult1++;
        ptr3++;
      } else if (result1.get(ptrResult1) < arr3[ptr3]) ptrResult1++;
      else ptr3++;

    }
    return finalResult;

  }
}
