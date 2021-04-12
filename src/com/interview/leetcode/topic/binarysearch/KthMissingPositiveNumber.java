package com.interview.leetcode.topic.binarysearch;

/*
https://leetcode.com/problems/kth-missing-positive-number/
===========================================================Requirement===========================================================
1) Given an array of sorted number from 1 to N. 
2) N is the last number in array.
3) Find Kth missing number.
============================================================Example1=============================================================
Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
============================================================Example2=============================================================
Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
==================================================Initial Thought - First Approach===============================================
1) Create a bucket of array from [1 to N].
2) In first pass, parse the inputArray. Copy the inputArray to bucket. 
3) In second pass, parse the bucket. If the bucketValue 0. It is a miss. Reduce K. if k==0, return currentIndex 
Time Complexity: O(N). Space Complexity: O(N)
==================================================Initial Thought - Better Approach==============================================
1) Above approach is good, if elements are not sorted.
2) Since elements are sorted. I don't need bucket of extra space. 
3) I can Think of problem merge2SortedArray.   
4) one array is 1toN and second array is inputArray. 
5) Compare firstElement from 1ToN with inputArray. 
6) if element is present in both side. move both side. Ex: arr=[1,2,3]
7) Else move only bucketArrayElement. Reduce K. if k==0, return currentIndex. 
Time Complexity: O(N). Space Complexity: O(1)
=======================================Logical Thinking=====================================================
1) Randomly Choose any index.
2) Comparing ============(nums[randomIndex]-1) == random===========  gives number of missing element at left of random.
Like QuickSelect Pivot. This is the key to find kth element by moving left or right.
=======================================Solution Approach=====================================================
Similar to problem MissingElementInSortedArrayBinarySearch. See the detailed analysis there.
*/
public class KthMissingPositiveNumber {
  public int findKthPositiveBruteForce(int[] arr, int k) {
    int lastNumber = arr[arr.length - 1], bucketArrayNumber = 1;
    int arrIndex = 0;
    while (bucketArrayNumber <= lastNumber) {
      if (bucketArrayNumber == arr[arrIndex]) { // Ex: arr=[1,2,3]
        // both array values are matching, increment both the side. 
        arrIndex++;
        bucketArrayNumber++;
      } else { // Ex: arr=[2,3]
        // both array values are not matching, increment only bucketArrayNumber. 
        bucketArrayNumber++;
        k--;
        if (k == 0) return bucketArrayNumber;
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
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      // Ex: [1,2,3,4,6,7,8] k=2
      boolean isLeftSideNoneMissing = nums[mid] - 1 == mid;
      if (isLeftSideNoneMissing) { // Go Right
        low = mid + 1;
      } else {
       // Ex:[2,3,5,6,8]..mid=2, nums[mid]=5, nums[mid] - 1 - mid= 5-1-2=2.. i.e 1 and 4 are missing
        int missingGapSize = nums[mid] - 1 - mid;
        if (missingGapSize == k) { // Go Left. Ex:[2,3,4,5] k=1
          high = mid - 1;
        } else if (missingGapSize > k) { // Go Left.  Ex:[2,50,100] k=1
          high = mid - 1;
        } else if (missingGapSize < k) {// Go Right   Ex:[2,50,100] k=50
          low = mid + 1;
        }
      }
    }

    return high + 1 + k;
  }
}
