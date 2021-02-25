package com.interview.leetcode.topic.binarysearch;

/*
https://leetcode.com/problems/kth-missing-positive-number/
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
===========================================================BruteForce============================================================
1) Like Bucket Sort
    a) If the value in bucket is not present in input. Ex: [2,3,4] k =1, decrement k.
        **) At anypoint k==0 return bucket.
    b) If the value in bucket is present in input. Ex: [1,2,3,4] k =2. Move on to next value in input
=======================================Logical Thinking=====================================================
1) Randomly Choose any index.
2) Comparing ============(nums[randomIndex]-1) == random===========  gives number of missing element at left of random.
Like QuickSelect Pivot. This is the key to find kth element by moving left or right.
=======================================Solution Approach=====================================================
Similar to problem MissingElementInSortedArrayBinarySearch. See the detailed analysis there.
*/
public class KthMissingPositiveNumber {
    public int findKthPositiveBruteForce(int[] arr, int k) {

        int lastNumber = arr[arr.length - 1];
        int arrIndex = 0;
        for (int bucket = 1; bucket <= lastNumber; bucket++) {
            if (bucket != arr[arrIndex]) {
                k--;
                if (k == 0) return bucket;
            } else {
                arrIndex++;
            }
        }
        // Ex: [1,2,3,4] k=2
        while (k-- != 0) lastNumber++;

        return lastNumber;
    }

    /*
    if missingGapSize == 0.
    We might think of "return 'high + 1 + k' " immediately by seeing input. Ex: [1,2,3,4] k=2
    But for Ex: [1,2,3,4,6,7,8] k=2.. It will fail. Because mid will fall on 4, missingGapSize==0. So we have to move right.
     */
    public int findKthPositive(int[] nums, int k) {
        // low cannot be 1. index out of bound will come. Ex:[1] k=2... (1+1)/2=1
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int missingGapSize = nums[mid] - 1 - mid;

            // Ex: [1,2,3,4,6,7,8] k=2
            if (missingGapSize == 0) {
                low = mid + 1;
            } else if (missingGapSize == k) { // Go Left. Ex:[2,3,4,5] k=1
                high = mid - 1;
            } else if (missingGapSize > k) { // Go Left.  Ex:[2,50,100] k=1
                high = mid - 1;
            } else if (missingGapSize < k) {// Go Right   Ex:[2,50,100] k=50
                low = mid + 1;
            }
        }

        return high + 1 + k;
    }
}
