package com.interview.leetcode.amazon.easy;

/*

https://leetcode.com/problems/rotate-array/

One difference why RotateList logic differs from RotateArray is.
Nodes are connected in List, whereas array it is not connected.
So interchanging logic will work. But complicated.

 ===========================================
1) Reverse the whole array from 0 to n-1.
2) Reverse the elements from 0 to k-1.
3) Reverse the elements from k to n−1.

*/
public class RotateArray {

  public void rotate(int[] nums, int k) {
    int n = nums.length;

    k = k % n; // If the number of rotation is more than n. Then rotation = rotation%size of data.

    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    for (; start < end; start++, end--) {
      nums[start] ^= nums[end];
      nums[end] ^= nums[start];
      nums[start] ^= nums[end];
    }
  }
}
