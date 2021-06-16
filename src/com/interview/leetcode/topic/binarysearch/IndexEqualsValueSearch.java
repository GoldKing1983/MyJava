package com.interview.leetcode.topic.binarysearch;

/*

https://www.pramp.com/challenge/jKoA5GAVy9Sr9jGBjz04
Problem name : Array Index & Element Equality


1) There can 1 or more value that can exists equal to index.
2) Find 1 such index which is lolw 
3) Input cannot contain duplicate...

Logic: 
1) If I pick any number and its value is greater than index, then result cannot exists in right side.
Because numbers are in ascending order and no duplicate can come. Ex:[0,5,6] ---> ans:0

2) If I pick any number and its value is less than index, then result cannot exists in left side.
Ex: [-1,0,2]---> ans:2

Ex: arr = [-8,0,2,3] --> 2


Ex: 
arr=[0,1,2,3,4] --> arr[i]==i...go left.
output : 0

arr=[0,1,3,4,5] --> arr[i]> i...go left.


arr=[-1,1,2,4,5] --> arr[i]< i...go right.

 */
public class IndexEqualsValueSearch {
  public int indexEqualsValueSearch(int[] arr) {
    return binSearch(arr, 0, arr.length - 1);
  }

  private static int binSearch(int[] nums, int low, int high) {
    if (low > high) return -1;//Result not found

    int mid = low + (high - low) / 2;
    if (nums[mid] == mid) return mid;
    if (nums[mid] > mid) return binSearch(nums, low, high - 1);
    return binSearch(nums, mid + 1, high);
  }
}
