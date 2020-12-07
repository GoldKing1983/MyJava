package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

Given the array nums, for each nums[i], find out how many numbers in the array are smaller than it.
Return the answer in an array.

Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
========================================Solution Approach - O(n)================================================================================
                Ex:
                  input : [1,1,2,3,4,5]
             bucketIndex:    0,1,2,3,4   
             bucketValue: [  2,1,1,1,1]
 bucketValueAfterProcess: [  0,2,3,4,5]       
                   0) Sort the element using bucketSort. 
                   1) From left, go and stand in first nonZeroElement
                   2) cache the count of first nonZeroElement. 
                   3) Move to the next nonZeroElement. update nonZeroElementIndex with count.
                                                       update count with nonZeroIndexValue.


*/
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length, bucketSize = 101;
    int[] bucket = new int[bucketSize], result = new int[n];

    for (int num : nums) bucket[num]++;

    int left = 0;
    //From left, go and stand in first nonZeroElement
    while (left < bucketSize && bucket[left] == 0) left++;
    if (left == bucketSize) return result;
    //cache the count of first nonZeroElement.
    int count = bucket[left];
    // for the first nonZeroElement result is 0.
    bucket[left] = 0;
    // find next nonZeroElement left+1.
    left++;
    while (left < bucketSize) {
      while (left < bucketSize - 1 && bucket[left] == 0) left++;
      if (left == bucketSize) break;
      int temp = bucket[left];
      bucket[left] = count;
      count += temp;
      left++;
    }
    for (int i = 0; i < n; i++) result[i] = bucket[nums[i]];

    return result;
  }
}
