package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

1) Given the array nums, for each nums[i], find out how many numbers in the array are smaller than it.
2) Return the answer in an array.

Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).


Input:  [7,7,7,7]
Output: [0,0,0,0]

Input:  [1,2,3,4,5]
Output: [0,1,2,3,4]

Input:  [5,4,3,2,1]
Output: [4,3,2,1,0]
========================================Solution Approach - O(n)================================================================================
                              input: [1,1,2,3,4,5]
             
                              index:    1,2,3,4,5 --> index0 ignored for easier understanding 
                
count of each number or bucketValue: [  2,1,1,1,1] --> after step1
             
            bucketValueAfterProcess: [  0,2,3,4,5] --> after step2
                                
                   
Step1) Sort the element using bucketSort. 
 
Step2) From left keep count the number of occurrence of each index value.
       This makes the bucket looks like for number of smaller number before the index.

Step3) assign result from bucket index value

*/
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length, bucketSize = 101, count = 0;
    int[] bucket = new int[bucketSize], result = new int[n];

    for (int num : nums) bucket[num]++;


    for (int left = 0; left < bucketSize; left++) {
      if (bucket[left] == 0) {
        // no operation
      } else {
        int bucketCount = bucket[left];
        bucket[left] = count;
        count += bucketCount;
      }
    }

    for (int i = 0; i < n; i++) result[i] = bucket[nums[i]];

    return result;
  }
}
