package com.sample.datastructure.recursion;

import java.util.Arrays;

/*
https://leetcode.com/problems/sort-an-array/
https://www.geeksforgeeks.org/merge-sort/

1) Merge Sort is a Divide and Conquer algorithm.
2) It splits input array in two halves,
3) Calls itself for the two halves and then merges the two sorted halves

======Time Complexity: O(n log(n))======
======Space Complexity: O(n)======
left and right recursive calls will create many arrays, but they won't coexist(or previous garbage collected) at the same time.
Space Complexity might look like O(n log n), but it is O(n) only.

=============================================Thinking Process=============================================
We can think of this algorithm as === Tree Post Order Traversal.

================================================Data Flow Diagram====================================
input : [9,8,7,6,5,4,3,2,1], output : [1, 2, 3, 4, 5, 6, 7, 8, 9]
  ===merge flow left===
Left : [9]. Right : [8]. Sorted Result : [8, 9]

Left : [8, 9]. Right : [7]. Sorted Result : [7, 8, 9]

Left : [6]. Right : [5]. Sorted Result : [5, 6]

Left : [7, 8, 9]. Right : [5, 6]. Sorted Result : [5, 6, 7, 8, 9]
  ===merge flow right===
Left : [4]. Right : [3]. Sorted Result : [3, 4]

Left : [2]. Right : [1]. Sorted Result : [1, 2]

Left : [3, 4]. Right : [1, 2]. Sorted Result : [1, 2, 3, 4]

  ===merge flow root===
Left : [5, 6, 7, 8, 9]. Right : [1, 2, 3, 4]. Sorted Result : [1, 2, 3, 4, 5, 6, 7, 8, 9]

 */
public class MergeSort {

  public int[] sortArray(int[] nums) {
    split(nums, nums.length - 1);
    return nums;
  }

  public void split(int[] inputArr, int n) {
    if (n == 0) return;

    int half = n / 2;

    // Copy from 0 - mid to leftSide Array
    int[] leftArr = Arrays.copyOfRange(inputArr, 0, half + 1);
    // Copy mid - end to rightSide Array
    int[] rightArr = Arrays.copyOfRange(inputArr, half + 1, n + 1);

    split(leftArr, leftArr.length - 1);
    split(rightArr, rightArr.length - 1);
    merge(leftArr, rightArr, inputArr);
  }

  public void merge(int[] left, int[] right, int[] result) {
    int resultIndex = 0, leftIndex = 0, rightIndex = 0;
    while (resultIndex < result.length) {
      if (leftIndex == left.length) { // Left Reached max. So copy data from right
        result[resultIndex] = right[rightIndex];
        rightIndex++;
      } else if (rightIndex == right.length) { // Right Reached max. So copy data from left
        result[resultIndex] = left[leftIndex];
        leftIndex++;
      } else if (left[leftIndex] < right[rightIndex]) {
        result[resultIndex] = left[leftIndex];
        leftIndex++;
      } else {
        result[resultIndex] = right[rightIndex];
        rightIndex++;
      }
      resultIndex++;
    }
  }
}
