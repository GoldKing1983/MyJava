package com.interview.leetcode.google.hard;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-k-th-smallest-pair-distance/

Given an integer array, return the k-th smallest distance among all the pairs.
The distance of a pair (A, B) is defined as the absolute difference between A and B.
Constraint : 0 <= nums[i] < 1000000.

Input: nums = [1,3,1]  k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.


If we go by permuting all the combination as per requirement, thats it wrong approach. we are lost. See BruteForce
=========================================Solution Approach=========================================
1) This problem can be compared to MissingElementInSortedArrayBinarySearch,SplitArrayLargestSum, DivideChocolate

2) Sort the data.

Ex: 4 elements in array [1,2,3,4]...(4*(4-1)/2) = 4*3/2 = 6 combinations.
Then we need to calculate distance between [1,2][1,3][1,4] ==> distances are 1,2,3
										   [2,3][2,4]	   ==> distances are 1,2,
										   [3,4]           ==> distances are 1

3) Now the binary-search space is low(0) to high(nums[nums.length - 1] - nums[0])

4) Pick any "random index" between low and high.
"random index" is like a quick-select pivot. measures number of available distance less than selected index.

5) Count number of distance available less than or equal to random index.

6) Move the "random index" left or right based on the count available at left.

*/
public class FindKthSmallestPairDistance {
  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int low = 0, high = nums[nums.length - 1] - nums[0];
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int num = getDistanceCountLessThanOrEqualToDistancePassed(nums, mid);
      /*
       * Returning mid is not possible. Because, if I search for getDistanceCountLessThanOrEqualToDistancePassed for 10.
       * It will return for 1 to 10. Even If there is no pair in 10. So we have to move all the way to left to get result.
       * Ex: [1,1,3] k=1 Output:0.... Here when mid=1... There will be 1 at left. But no pair is there for 1. So it has to go left.
       */
      // if(num==mid) return mid;
      if (num < k) low = mid + 1;
      else high = mid - 1;
    }
    return low;
  }

  private int getDistanceCountLessThanOrEqualToDistancePassed(int[] nums, int distance) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] - nums[i] > distance) break;
        count++;
      }
    }
    return count;
  }
}
