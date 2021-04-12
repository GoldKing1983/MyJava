package com.interview.leetcode.topic.binarysearch;

/*
https://leetcode.com/problems/missing-element-in-sorted-array/

Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
K must always be greater than 0.

Input: A = [4,7,9,10], K = 1 Output: 5
Explanation:  The first missing number is 5.

Input: A = [4,7,9,10], K = 3 Output: 8
Explanation:  The missing numbers are [5,6,8,...], hence the third missing number is 8.

[4,5,6] k = 1 Ans= 7
[4,5,6] k = 2 Ans= 8
[4,6,8] k = 1 Ans= 5
[4,6,8] k = 2 Ans= 7

See Also KthMissingPositiveNumber
=======================================Logical Thinking=====================================================
1) Randomly Choose any index.
2) Comparing ============(nums[random]-nums[0]) == random===========  gives number of missing element at left of random.
Like QuickSelect Pivot. This is the key to find kth element by moving left or right.
=======================================Solution Approach=====================================================

1) Pick a random index between low and high.
2) If (nums[random]-nums[0]) == random, then no elements are missing at left of random. Go Right

Ex: [4,5,6,7,8] random Index=2 ===> (6-4)2==2

3) Pick another index between random and high.
4) If (nums[random]-nums[0]) != random, then some elements are missing at left.

Ex: [3,5,6,7,8] random Index=2 ===> (6-3)3!=2

The missingSize =  nums[random]-nums[0]- random
		if (missingSize == k) { // Go Left
          high = mid - 1;
        } else if (missingSize > k) { // Go Left
          high = mid - 1;
        } else { // (missingSize<k) // Go Right
          low = mid + 1;
        }

Here "randomIndex" is mid
====================================================Data Flow Analysis============================================================
[2,4,6,8] k=4 Output=9
========================================================
Initially ========= low:0, mid: 1, high:3=========
Between 2 and 4, missing size is: 1
Missing size  <k. So going right side. Updating low to 0
Updated low and high are ========= low:2, high:3=========
========================================================
Initially ========= low:2, mid: 2, high:3=========
Between 2 and 6, missing size is: 2
Missing size  <k. So going right side. Updating low to 2
Updated low and high are ========= low:3, high:3=========
========================================================
Initially ========= low:3, mid: 3, high:3=========
Between 2 and 8, missing size is: 3
Missing size  <k. So going right side. Updating low to 3
Updated low and high are ========= low:4, high:3=========
========================================================
low went below high. Calculating kth(4) missing number: nums[0]+k+high=9

====================================================Data Flow Analysis============================================================
[2,4,6,8] k=1 Output=3
========================================================
Initially ========= low:0, mid: 1, high:3=========
Between 2 and 4, missing size is: 1
Missing size  ==k. So going left side. Updating high to 3
Updated low and high are ========= low:0, high:0=========
========================================================
Initially ========= low:0, mid: 0, high:0=========
Between 2 and 2, missing size is: 0
Missing size is 0. So going left side. Updating high to 0
Updated low and high are ========= low:1, high:0=========
========================================================
low went below high. Calculating kth(1) missing number: nums[0]+k+high=3
====================================================Data Flow Analysis============================================================
[2,4,6,8] k=3 Output=7
========================================================
Initially ========= low:0, mid: 1, high:3=========
Between 2 and 4, missing size is: 1
Missing size  <k. So going right side. Updating low to 0
Updated low and high are ========= low:2, high:3=========
========================================================
Initially ========= low:2, mid: 2, high:3=========
Between 2 and 6, missing size is: 2
Missing size  <k. So going right side. Updating low to 2
Updated low and high are ========= low:3, high:3=========
========================================================
Initially ========= low:3, mid: 3, high:3=========
Between 2 and 8, missing size is: 3
Missing size  ==k. So going left side. Updating high to 3
Updated low and high are ========= low:3, high:2=========
========================================================
low went below high. Calculating kth(3) missing number: nums[0]+k+high=7
=====================================================================================================================================
 */
public class MissingElementInSortedArrayBinarySearch {
  // See Analysis KthMissingPositiveNumber
  public int missingElementBruteForce(int[] nums, int k) {
    int n = nums.length, bucketStartNumber = nums[0], bucketEndNumber = nums[n - 1], i = 0;

    while (bucketStartNumber < bucketEndNumber) {
      if (bucketStartNumber == nums[i]) {
        i++;
        bucketStartNumber++;
      } else {
        k--;
        if (k == 0) return bucketStartNumber;
        bucketStartNumber++;
      }
    }
    //Ex:[4,5,6] k=2. return 8
    return bucketEndNumber + k;
  }

  public int missingElement(int[] nums, int k) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      boolean isLeftSideNoneMissing = nums[mid] - nums[0] == mid;
      if (isLeftSideNoneMissing) { // Go Right
        low = mid + 1;
      } else {
        int missingGapSize = nums[mid] - nums[0] - mid;
        if (missingGapSize == k) { // Go Left
          high = mid - 1;
        } else if (missingGapSize > k) { // Go Left
          high = mid - 1;
        } else { // (missingSize<k) // Go Right
          low = mid + 1;
        }
      }
    }
    return high + nums[0] + k;
  }
}
