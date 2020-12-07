package com.interview.leetcode.google.hard;

/*
Since the array is sorted I can skip the initializing j every-time.
Ex: [1,2,3,4]

if pivot or mid = 4... Then 6 distances are less than the passed distance


This improves the performance upto 60%


*/
public class FindKthSmallestPairDistanceImproved {

  private int getDistanceCountLessThanOrEqualToDistancePassed(int[] nums, int distance) {
    int count = 0, j = 1;
    for (int i = 0; i < nums.length; i++) {
      count += j - i - 1;
      while (j < nums.length) {
        if (nums[j] - nums[i] > distance) break;
        j++;
        count++;
      }
    }
    return count;
  }
}
