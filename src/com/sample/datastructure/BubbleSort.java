package com.sample.datastructure;

/*
https://leetcode.com/problems/sort-an-array
https://www.youtube.com/watch?v=nmhjrI-aW5o

1) Bubble sort pushes the bigNumber from left to right all the way.
This is achieved by swapping current and nextNumber.
Note: We can make note of bigNumber and bigNumberIndex and do 1 swap at end. Then that makes
the algorithm to change into selection sort.  

2) Doing this makes the smallNumber bubble up from bottom(right) to top(left), hence the name bubble sort.
Ex; 5 4 9 1 2 8

Note: tricky, comparism happens for current and nextElement. 
      outer loop just shrink the end of rightSide for inner for loop. 

      
 */
public class BubbleSort {
  //Ex; 5 4 9 1 2 8
  public int[] sortArray(int[] nums) {
    int n = nums.length;// for 2 elements 1 compare
    while (n > 1) {
      for (int j = 0; j + 1 < n; j++) {

        int currentNumber = nums[j], nextNumber = nums[j + 1];

        if (currentNumber > nextNumber) {
          nums[j] = nums[j] + nums[j + 1];
          nums[j + 1] = nums[j] - nums[j + 1];
          nums[j] = nums[j] - nums[j + 1];
        }
      }
      n--;
    }
    return nums;

  }
}
