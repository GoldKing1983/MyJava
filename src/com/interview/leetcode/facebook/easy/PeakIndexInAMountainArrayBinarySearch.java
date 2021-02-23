package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/

Input: [0,1,0]
Output: 1

Input: [0,2,1,0]
Output: 1

Same problem as FindPeakElement with less requirement.

1) But there will be mountain exists "with in input" all the time
2) input size always >=3. So [1,2] ---> invalid input......[1] ---> invalid input.
3) [1,2,3] ---> invalid input. Because with input mountain cannot be formed.
4) [1,2,1,4,5,6,7,8,9] --> invalid input. Any data increases must decrease.

============================================Solution Approach============================================
1) As per requirement If there is increase, it must decrease.Ex:[1,2,1,4,5,6,7,8,9].. This is invalid.. 
from 4 increasing and never decreased
2) So for each mid compare next is bigger. If yes go right. Because it must decrease.
3) Else Go Left.
==========================================================================================================
*/

public class PeakIndexInAMountainArrayBinarySearch {

  public int peakIndexInMountainArraySimple(int[] arr) {
      int low=0, high=arr.length-1;
      while(low<=high) {
          int mid = low+(high-low)/2;
          if(arr[mid+1] < arr[mid]) {// lowering slope... So go up from right
               high = mid-1;
          }else { // slope increasing... so go up from left
              low = mid+1;
          }
      }
      return low;//high... low and high both has answer
  }
  
  public int peakIndexInMountainArray(int[] nums) {
    return binSearch(0, nums.length - 1, nums);
  }

  private int binSearch(final int low, final int high, final int[] nums) {
    int mid = low + (high - low) / 2;
    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // ex: [1,2,1] 2 greater than both adjacent
      return mid;
    } else if (nums[mid + 1] > nums[mid]) {
      return binSearch(mid + 1, high, nums);
    } else {
      return binSearch(low, mid - 1, nums);
    }
  }

  public int peakIndexInMountainArrayForLoop(int[] nums) {
    for (int i = 0; i < nums.length; i++) if (nums[i + 1] < nums[i]) return i;
    return 0;
  }
}
