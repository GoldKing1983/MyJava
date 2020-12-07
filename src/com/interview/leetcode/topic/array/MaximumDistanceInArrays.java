package com.interview.leetcode.topic.array;

import java.util.List;

/*
===========================================================Requirement===========================================================
You are given m arrays, where each array is sorted in ascending order. Now you can pick up two integers from two different arrays
(each array picks one) and calculate the distance. We define the distance between two integers "a" and "b" to be their absolute 
difference |a - b|. Your task is to find the maximum distance.

=============================================================Example1============================================================
Input: arrays = [[4,5],[1,2,3]]
Output: 4 (5-1)
=============================================================Example2============================================================
Input: arrays = [[1,2,3],[4,5]]
Output: 4 (5-1)
=========================================================Initial Thinking========================================================
1) With 1 list result cannot be formed.  
2) max can be achieved in 2 cases.
    case1) array1LastElement - array2firstElement
    case2) array1FirstElement - array2LastElement
============================================================BruteForce===========================================================
1) Take array1FirstElement and array1LastElement. Compare with all remaining array firstAndLastElement. Cache max.
2) Take array2FirstElement and array2LastElement. Compare with all remaining array firstAndLastElement. Cache max.
3) Keep do for n elements.
========================================================Solution Approach========================================================
1) From list1 cache firstElement as previousMinElement and lastElement as previousMaxElement.
2) From list2 cache firstElement as currentMinElement and lastElement as currentMaxElement. 
3) currentResult = Math.max (list1LastElement - list2FirstElement(Example1) or list2LastElement - list1FirstElement(Example2)).

4) Update result.

5) Update minFirstElement and maxLastElement

     


 */
public class MaximumDistanceInArrays {
  public int maxDistance(List<List<Integer>> list) {
    int result = Integer.MIN_VALUE;
    int previousMinElement = list.get(0).get(0); // 1
    int previousMaxElement = list.get(0).get(list.get(0).size() - 1); // 3

    for (int i = 1; i < list.size(); i++) {

      List<Integer> currentList = list.get(i);
      int n = currentList.size() - 1;
      int currentMinElement = currentList.get(0); // 4
      int currentMaxElement = currentList.get(n); // 5

      // abs is required, because each array is sorted, but overall array is not sorted take Example1. 
      int currentMaxFromFirstElement = Math.abs(previousMaxElement - currentMinElement); // 3-4=1
      int currentMaxFromLastElement = Math.abs(previousMinElement - currentMaxElement); // 1-5=4
      int currentResult = Math.max(currentMaxFromFirstElement, currentMaxFromLastElement); // Math.max(1,4)

      result = Math.max(result, currentResult);

      previousMinElement = Math.min(previousMinElement, currentMinElement);
      previousMaxElement = Math.max(previousMaxElement, currentMaxElement);
    }

    return result;
  }
}
